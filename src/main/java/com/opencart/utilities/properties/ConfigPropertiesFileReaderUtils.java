/**
 * Purpose: This class will read the key from the config.properties file
 *          and return the associated value
 */

package com.opencart.utilities.properties;

import com.opencart.constants.Constant;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigPropertiesFileReaderUtils {

    private static Properties properties;

    /*
     * Static Block:
     * - Runs only ONCE when the class is first loaded
     * - Which means it's more efficient because rather than
     * - loading the config.properties file everytime
     * - getProperty() is called, it does it once at class load time
     */
    static {
        try(FileInputStream fileInputStream = new FileInputStream(Constant.CONFIG_PROPERTIES_FILE_PATH)) {
            properties = new Properties();
            properties.load(fileInputStream);
        } catch (FileNotFoundException e) {
            //todo add log
            throw new RuntimeException("======= FILE DOES NOT EXIST OR INCORRECT PATH TO FILE PROVIDED =======", e);
        } catch (IOException e) {
            //todo add log
            throw new RuntimeException("======= ERROR OCCURRED WHILE READING FROM FILE =======", e);
        }
    }

    private static String getValue(String key) {
        String value = properties.getProperty(key);
        if (value == null) {
            //todo add log
            throw new RuntimeException("Key [" + key + "] not found in config.properties file");
        } else {
            return value;
        }
    }

    public static String getBrowserValue() {
        return getValue("browser");
    }

    public static String getHeadLessValue() {
        return getValue("headless");
    }

    public static String getIncognitoValue() {
        return getValue("incognito");
    }

    public static String getImplicitWaitValue() {
        return getValue("implicitWait");
    }
}