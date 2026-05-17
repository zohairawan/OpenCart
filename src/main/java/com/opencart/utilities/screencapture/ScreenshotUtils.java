package com.opencart.utilities.screencapture;

import com.opencart.constants.Constant;
import com.opencart.utilities.browser.DriverManagerUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotUtils {

    public static void takeScreenshot() {
        TakesScreenshot screenshot = (TakesScreenshot) DriverManagerUtils.getDriver();
        File screenshotSourceFile = screenshot.getScreenshotAs(OutputType.FILE);
        String screenshotTimestamp = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
        File screenshotTargetFile = new File(Constant.SCREENSHOTS_FILE_PATH + screenshotTimestamp + ".png");
        screenshotSourceFile.renameTo(screenshotTargetFile);
    }
}