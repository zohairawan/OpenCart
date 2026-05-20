package com.opencart.driver.environment;

import com.opencart.constants.Constants;
import com.opencart.driver.DriverProvider;
import com.opencart.utilities.logger.LogManagerUtils;
import com.opencart.utilities.properties.ConfigPropertiesFileReaderUtils;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

public class RemoteDriverEnvironment implements DriverEnvironment {

    @Override
    public WebDriver createWebDriver(MutableCapabilities options, DriverProvider provider) {
        String os = ConfigPropertiesFileReaderUtils.getOS().toLowerCase();
        switch (os) {
            case Constants.OS_WINDOWS,
                 Constants.OS_MAC,
                 Constants.OS_LINUX -> options.setCapability("platformName", os);
            default -> {
                String invalidOSMessage = "Invalid Operating System type: '" + os + "'";
                LogManagerUtils.getLogger(RemoteDriverEnvironment.class).error(invalidOSMessage);
                throw new IllegalArgumentException(invalidOSMessage);
            }
        }

        try {
            URL gridURL = URI.create(Constants.GRID_URL).toURL();
            return new RemoteWebDriver(gridURL, options);
        } catch (MalformedURLException e) {
            String invalidGridURLMessage = "Invalid Selenium Grid URL: '" + Constants.GRID_URL + "'";
            LogManagerUtils.getLogger(RemoteDriverEnvironment.class).error(invalidGridURLMessage, e);
            throw new IllegalStateException(invalidGridURLMessage, e);
        }
    }
}