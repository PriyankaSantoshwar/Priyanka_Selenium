package com.yourcompany.pages;

import com.yourcompany.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    private final By emailField = By.id("fi-login-email");
    private final By continueButton = By.cssSelector("button[type='submit']");
    private final By passwordField = By.id("fi-login-pass");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void login(String email, String password) {
        type(emailField, email);
        click(continueButton);
        type(passwordField, password);
        click(continueButton);
    }
}
