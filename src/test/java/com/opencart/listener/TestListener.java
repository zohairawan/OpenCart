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
        ExtentReportUtils.createThreadLocalTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentReportUtils.getThreadLocalTest().pass(result.getMethod().getMethodName() + " passed");
        ExtentReportUtils.unloadThreadLocalTest();
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ExtentReportUtils.getThreadLocalTest().fail(result.getThrowable());
        ExtentReportUtils.unloadThreadLocalTest();
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ExtentReportUtils.getThreadLocalTest().skip(result.getMethod().getMethodName() + " skipped");
        ExtentReportUtils.unloadThreadLocalTest();
    }

    @Override
    public void onFinish(ITestContext context) {
        ExtentReportUtils.flushExtentReport();
    }
}