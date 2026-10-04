package com.saucedemo.automation.base;

import org.openqa.selenium.WebDriver;

public final class DriverContext {
    private static final ThreadLocal<WebDriver> DRIVER = new ThreadLocal<>();

    private DriverContext() {
    }

    public static WebDriver getDriver() {
        WebDriver driver = DRIVER.get();
        if (driver == null) {
            throw new IllegalStateException("No WebDriver is active for the current test.");
        }
        return driver;
    }

    static void setDriver(WebDriver driver) {
        DRIVER.set(driver);
    }

    static void clearDriver() {
        DRIVER.remove();
    }
}
