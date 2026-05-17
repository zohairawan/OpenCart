package com.opencart.constants;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Constant {

    public static final String CHROME_BROWSER = "chrome";
    public static final String FIREFOX_BROWSER = "firefox";
    public static final String CONFIG_PROPERTIES_FILE_PATH = System.getProperty("user.dir") + "/src/test/resources/config.properties";
    public static final Path EXTENT_REPORT_PATH = Paths.get(System.getProperty("user.dir"), "reports");
    public static final Path SCREENSHOTS_FILE_PATH = Paths.get(System.getProperty("user.dir"), "screenshots");
    public static final String URL = "https://tutorialsninja.com/demo/";
}