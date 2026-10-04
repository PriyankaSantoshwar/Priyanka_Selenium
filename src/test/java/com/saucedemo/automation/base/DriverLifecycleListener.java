package com.saucedemo.automation.base;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DriverLifecycleListener implements IInvokedMethodListener {
    @Override
    public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
        if (!method.isTestMethod()) {
            return;
        }

        WebDriver driver = createDriver(System.getProperty("browser", "chrome"));
        try {
            driver.manage().timeouts().implicitlyWait(Duration.ZERO);
            if (!isHeadless()) {
                driver.manage().window().maximize();
            }
            driver.get(System.getProperty("site.url", "https://www.saucedemo.com/"));
            DriverContext.setDriver(driver);
        } catch (RuntimeException exception) {
            driver.quit();
            throw exception;
        }
    }

    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
        if (!method.isTestMethod()) {
            return;
        }

        try {
            WebDriver driver = DriverContext.getDriver();
            if (!testResult.isSuccess()) {
                saveFailureScreenshot(driver, testResult.getName());
            }
            driver.quit();
        } finally {
            DriverContext.clearDriver();
        }
    }

    private WebDriver createDriver(String browserName) {
        String browser = browserName.toLowerCase(Locale.ROOT);
        boolean headless = isHeadless();

        return switch (browser) {
            case "chrome" -> {
                ChromeOptions options = new ChromeOptions();
                if (headless) {
                    options.addArguments("--headless=new", "--window-size=1440,1000");
                }
                yield new ChromeDriver(options);
            }
            case "firefox" -> {
                FirefoxOptions options = new FirefoxOptions();
                if (headless) {
                    options.addArguments("-headless");
                }
                yield new FirefoxDriver(options);
            }
            case "edge" -> {
                EdgeOptions options = new EdgeOptions();
                if (headless) {
                    options.addArguments("--headless=new", "--window-size=1440,1000");
                }
                yield new EdgeDriver(options);
            }
            default -> throw new IllegalArgumentException(
                    "Unsupported browser '%s'. Choose chrome, firefox, or edge.".formatted(browserName));
        };
    }

    private boolean isHeadless() {
        return Boolean.parseBoolean(System.getProperty("selenium.headless", "false"));
    }

    private void saveFailureScreenshot(WebDriver driver, String testName) {
        try {
            Path screenshotDirectory = Path.of("target", "screenshots");
            Files.createDirectories(screenshotDirectory);
            String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss"));
            Path screenshot = screenshotDirectory.resolve("%s-%s.png".formatted(testName, timestamp));
            Files.write(screenshot, ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
            System.err.println("Saved failure screenshot: " + screenshot);
        } catch (IOException exception) {
            System.err.println("Could not save failure screenshot for " + testName + ": " + exception.getMessage());
        }
    }
}
