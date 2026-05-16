package com.opencart.listener;

import com.opencart.utilities.report.ExtentReportUtils;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    @Override
    public void onStart(ITestContext context) {
        ExtentReportUtils.createAndReturnExtentReport();
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