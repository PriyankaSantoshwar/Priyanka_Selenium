package com.saucedemo.automation.pages;

import com.saucedemo.automation.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {
    private final By usernameField = By.cssSelector("[data-test='username']");
    private final By passwordField = By.cssSelector("[data-test='password']");
    private final By loginButton = By.cssSelector("[data-test='login-button']");
    private final By errorMessage = By.cssSelector("[data-test='error']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void login(String username, String password) {
        type(usernameField, username);
        type(passwordField, password);
        click(loginButton);
    }

    public ProductsPage loginSuccessfully(String username, String password) {
        login(username, password);
        wait.until(ExpectedConditions.urlContains("inventory.html"));
        return new ProductsPage(driver);
    }

    public boolean isDisplayed() {
        return isDisplayed(loginButton) && isDisplayed(usernameField);
    }

    public String getErrorMessage() {
        return text(errorMessage);
    }
}
