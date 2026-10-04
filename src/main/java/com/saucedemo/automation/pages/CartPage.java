package com.saucedemo.automation.pages;

import com.saucedemo.automation.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CartPage extends BasePage {
    private final By itemNames = By.className("inventory_item_name");
    private final By checkoutButton = By.cssSelector("[data-test='checkout']");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public boolean containsBackpack() {
        return findAll(itemNames).stream()
                .anyMatch(item -> item.getText().equals("Sauce Labs Backpack"));
    }

    public int getItemCount() {
        return findAll(itemNames).size();
    }

    public CheckoutPage checkout() {
        clickWithJavaScript(checkoutButton);
        wait.until(ExpectedConditions.urlContains("checkout-step-one.html"));
        return new CheckoutPage(driver);
    }
}
