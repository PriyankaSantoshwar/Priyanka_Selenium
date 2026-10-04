package com.saucedemo.automation.pages;

import com.saucedemo.automation.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CheckoutPage extends BasePage {
    private final By firstNameField = By.cssSelector("[data-test='firstName']");
    private final By lastNameField = By.cssSelector("[data-test='lastName']");
    private final By postalCodeField = By.cssSelector("[data-test='postalCode']");

    public CheckoutPage(WebDriver driver) {
        super(driver);
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstNameField));
    }

    public boolean isCustomerDetailsFormDisplayed() {
        return isDisplayed(firstNameField)
                && isDisplayed(lastNameField)
                && isDisplayed(postalCodeField);
    }
}
