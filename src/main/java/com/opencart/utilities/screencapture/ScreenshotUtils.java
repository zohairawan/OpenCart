package com.opencart.utilities.screencapture;

import com.opencart.constants.Constant;
import com.opencart.utilities.browser.DriverManagerUtils;
import com.opencart.utilities.logger.LogManagerUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotUtils {

    public static void takeScreenshot() {
        try {
            Files.createDirectories(Constant.SCREENSHOTS_FOLDER_PATH);
        } catch (IOException e) {
            LogManagerUtils.getLogger(ScreenshotUtils.class).error(
                    "Failed to create screenshots directory");
            throw new RuntimeException(e);
        }

        TakesScreenshot takeScreenshot = (TakesScreenshot) DriverManagerUtils.getDriver();
        File screenshotSourceFile = takeScreenshot.getScreenshotAs(OutputType.FILE);
        String screenshotTimestamp = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
        Path screenshotTargetFile = Constant.SCREENSHOTS_FOLDER_PATH.resolve(screenshotTimestamp + ".png");
        try {
            Files.copy(screenshotSourceFile.toPath(), screenshotTargetFile);
        } catch (IOException e) {
            LogManagerUtils.getLogger(ScreenshotUtils.class).error(
                    "Unable to store screenshot, " +
                            "invalid path to screenshots directory {}",
                    screenshotTargetFile.toString());
        }
    }
}