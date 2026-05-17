package com.opencart.utilities.report;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.opencart.constants.Constant;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentReportUtils {

    private static ExtentReports extentReport = null;
    /*
     * Benefits of ThreadLocal?
     * The WebDriver value stored inside ThreadLocal is isolated per thread,
     * meaning each thread gets its own independent ExtentTest instance
     * even though the ThreadLocal itself is shared
     * ThreadLocal = locker room
     * Locker contains ExtentTest specific to that thread
     * Threads can access any locker room (ThreadLocal)
     *
     * Why is ThreadLocal static?
     * So it can be globally accessible
     */
    private static final ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

    public static ExtentReports createReport() {
        if (extentReport == null) {
            String timestamp = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
            Path reportFilePath = Constant.EXTENT_REPORT_PATH.resolve("ExtentReport_" + timestamp + ".html");
            String extentReportFileName = reportFilePath.toString();

            ExtentSparkReporter extentSparkReport = new ExtentSparkReporter(extentReportFileName);
            extentSparkReport.config().setDocumentTitle("OpenCart Automation Test Report");
            extentSparkReport.config().setReportName("Test Execution Report");

            extentReport = new ExtentReports();
            extentReport.attachReporter(extentSparkReport);
            extentReport.setSystemInfo("Application", "OpenCart");
            extentReport.setSystemInfo("Tester", System.getProperty("user.name"));
            extentReport.setSystemInfo("Environment", "QA");
        }
        return extentReport;
    }

    public static void createTest(String testName) {
        extentTest.set(extentReport.createTest(testName));
    }

    public static ExtentTest getTest() {
        return extentTest.get();
    }

    public static void unloadTest() {
        extentTest.remove();
    }

    public static void flushExtentReport() {
        if (extentReport != null) {
            extentReport.flush();
        }
    }
}