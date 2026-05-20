package com.opencart.constants;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Constants {

    public static final String EXECUTION_ENV_LOCAL = "local";
    public static final String EXECUTION_ENV_REMOTE = "remote";
    public static final String OS_WINDOWS = "windows";
    public static final String OS_MAC = "mac";
    public static final String OS_LINUX = "linux";
    public static final String GRID_URL = "http://localhost:4444";
    public static final String CHROME_BROWSER = "chrome";
    public static final String FIREFOX_BROWSER = "firefox";
    public static final Path CONFIG_PROPERTIES_FILE_PATH = Paths.get(System.getProperty("user.dir"), "src", "test", "resources", "config", "config.properties");
    public static final Path EXTENT_REPORT_FOLDER_PATH = Paths.get(System.getProperty("user.dir"), "reports");
    public static final Path SCREENSHOTS_FOLDER_PATH = Paths.get(System.getProperty("user.dir"), "screenshots");
    public static final String EXTENT_REPORT_FILE_EXTENSION = ".html";
    public static final String SCREENSHOTS_FILE_EXTENSION = ".png";
    public static final String EXCEL_FILE_EXTENSION_XLSX = ".xlsx";
    public static final String URL = "https://tutorialsninja.com/demo/";
}