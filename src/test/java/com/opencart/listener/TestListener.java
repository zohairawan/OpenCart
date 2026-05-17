/*
 * Purpose:
 * - Runs specified actions based on test events
 * - Creates report on test start
 * - Captures screenshot on test fail
 */

package com.opencart.listener;

import com.aventstack.extentreports.ExtentReports;
import com.opencart.utilities.report.ExtentReportUtils;
import org.apache.logging.log4j.ThreadContext;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import java.util.List;

public class TestListener implements ITestListener {

    @Override
    public void onStart(ITestContext context) {
        ExtentReports extentReport = ExtentReportUtils.createReport();
        extentReport.setSystemInfo("Browser", context.getCurrentXmlTest().getParameter("browser"));

        List<String> includedGroups = context.getCurrentXmlTest().getIncludedGroups();
        if (!includedGroups.isEmpty()) {
            extentReport.setSystemInfo("Groups", includedGroups.toString());
        }
    }

    @Override
    public void onTestStart(ITestResult result) {
        String testName = result.getMethod().getMethodName();
        ThreadContext.put("testName", testName);
        ExtentReportUtils.createTest(testName);
        ExtentReportUtils.getTest().info("TEST STARTED: " + testName);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        String testName = result.getMethod().getMethodName();
        ExtentReportUtils.getTest().pass("TEST PASSED: " + testName);
        ExtentReportUtils.unloadTest();
        ThreadContext.clearAll();
    }

    @Override
    public void onTestFailure(ITestResult result) {
        String testName = result.getMethod().getMethodName();
        ExtentReportUtils.getTest().fail("TEST FAILED: " + testName);
        Throwable error = result.getThrowable();
        if (error != null) {
            ExtentReportUtils.getTest().fail(error);
        }
        ExtentReportUtils.unloadTest();
        ThreadContext.clearAll();
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        String testName = result.getMethod().getMethodName();
        ExtentReportUtils.getTest().skip("TEST SKIPPED: " + testName);
        ExtentReportUtils.unloadTest();
        ThreadContext.clearAll();
    }

    @Override
    public void onFinish(ITestContext context) {
        ExtentReportUtils.flushExtentReport();
    }
}