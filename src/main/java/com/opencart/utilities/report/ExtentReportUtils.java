package com.opencart.utilities.report;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.opencart.constants.Constant;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentReportUtils {

    private static ExtentReports extentReport = null;
    /*
     * Why static?
     * The WebDriver value stored inside ThreadLocal is isolated per thread,
     * meaning each thread gets its own independent ExtentTest instance
     * even though the ThreadLocal itself is shared
     * ThreadLocal = locker room
     * Locker contains ExtentTest specific to that thread
     * Threads can access any locker room (ThreadLocal)
     */
    private static final ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

    public static ExtentReports createAndReturnExtentReport() {
        if (extentReport == null) {
            String timestamp = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
            String extentReportPath = Constant.EXTENT_REPORT_PATH + "ExtentReport_" + timestamp + ".html";

            ExtentSparkReporter extentSparkReport = new ExtentSparkReporter(extentReportPath);
            extentSparkReport.config().setDocumentTitle("OpenCart Automation Test Report");
            extentSparkReport.config().setReportName("Test Execution Report");

            extentReport = new ExtentReports();
            extentReport.attachReporter(extentSparkReport);
        }
        return extentReport;
    }

    public static void createThreadLocalTest(String testName) {
        extentTest.set(createAndReturnExtentReport().createTest(testName));
    }

    public static ExtentTest getThreadLocalTest() {
        return extentTest.get();
    }

    public static void unloadThreadLocalTest() {
        extentTest.remove();
    }

    public static void flushExtentReport() {
        if (extentReport != null) {
            extentReport.flush();
        }
    }
}