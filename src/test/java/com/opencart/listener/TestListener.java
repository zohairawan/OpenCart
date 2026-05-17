/*
 * Purpose:
 * - Runs specified actions based on test events
 * - Creates report on test start
 * - Captures screenshot on test fail
 */

package com.opencart.listener;

import com.aventstack.extentreports.ExtentReports;
import com.opencart.utilities.report.ExtentReportUtils;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import java.util.List;

public class TestListener implements ITestListener {

    @Override
    public void onStart(ITestContext context) {
        ExtentReports extentReport = ExtentReportUtils.createAndReturnExtentReport();
        extentReport.setSystemInfo("Browser", context.getCurrentXmlTest().getParameter("browser"));

        List<String> includedGroups = context.getCurrentXmlTest().getIncludedGroups();
        if (!includedGroups.isEmpty()) {
            extentReport.setSystemInfo("Groups", includedGroups.toString());
        }
    }

    @Override
    public void onTestStart(ITestResult result) {
        String testName = result.getMethod().getMethodName();
        ExtentReportUtils.createThreadLocalTest(testName);
        ExtentReportUtils.getThreadLocalTest().info("TEST STARTED: " + testName);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        String testName = result.getMethod().getMethodName();
        ExtentReportUtils.getThreadLocalTest().pass("TEST PASSED: " + testName);
        ExtentReportUtils.unloadThreadLocalTest();
    }

    @Override
    public void onTestFailure(ITestResult result) {
        String testName = result.getMethod().getMethodName();
        ExtentReportUtils.getThreadLocalTest().fail("TEST FAILED: " + testName);
        Throwable error = result.getThrowable();
        if (error != null) {
            ExtentReportUtils.getThreadLocalTest().fail(error);
        }
        ExtentReportUtils.unloadThreadLocalTest();
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        String testName = result.getMethod().getMethodName();
        ExtentReportUtils.getThreadLocalTest().skip("TEST SKIPPED: " + testName);
        ExtentReportUtils.unloadThreadLocalTest();
    }

    @Override
    public void onFinish(ITestContext context) {
        ExtentReportUtils.flushExtentReport();
    }
}