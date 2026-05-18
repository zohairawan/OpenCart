/*
 * Purpose:
 * - This class will read the key from the config.properties file
 *   and return the associated value
 */

package com.opencart.utilities.properties;

import com.opencart.constants.Constant;
import com.opencart.utilities.logger.LogManagerUtils;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigPropertiesFileReaderUtils {

    private static final Properties properties;

    /*
     * Static Block:
     * - Runs only ONCE when the class is first loaded
     * - Which means it's more efficient because rather than
     * - loading the config.properties file everytime
     * - getProperty() is called, it does it once at class load time
     */
    static {
        try (InputStream fileInputStream = new FileInputStream(Constant.CONFIG_PROPERTIES_FILE_PATH.toFile())) {
            properties = new Properties();
            properties.load(fileInputStream);
        } catch (FileNotFoundException e) {
            LogManagerUtils.getLogger(ConfigPropertiesFileReaderUtils.class).error(
                    "config.properties file not found: {}", Constant.CONFIG_PROPERTIES_FILE_PATH.toString());
            throw new RuntimeException(e);
        } catch (IOException e) {
            LogManagerUtils.getLogger(ConfigPropertiesFileReaderUtils.class).error(
                    "Error occurred while reading from config.properties file: {}", Constant.CONFIG_PROPERTIES_FILE_PATH);
            throw new RuntimeException(e);
        }
    }

    private static String getValue(String key) {
        String value = properties.getProperty(key);
        if (value == null) {
            LogManagerUtils.getLogger(ConfigPropertiesFileReaderUtils.class).error(
                    "Key [{}] not found in config.properties file", key);
            throw new RuntimeException("Key [" + key + "] not found in config.properties file");
        } else {
            return value;
        }
    }

    public static boolean getHeadLessValue() {
        return Boolean.parseBoolean(getValue("headless"));
    }

    public static boolean getIncognitoValue() {
        return Boolean.parseBoolean(getValue("incognito"));
    }

    public static long getExplicitWaitInSeconds() {
        return Long.parseLong(getValue("explicitWait"));
    }

    public static String getValidEmail() {
        return getValue("validEmail");
    }

    public static String getValidPassword() {
        return getValue("validPassword");
    }

    public static String getInvalidEmail() {
        return getValue("invalidEmail");
    }

    public static String getInvalidPassword() {
        return getValue("invalidPassword");
    }
}