package com.yourcompany.pages;

import com.yourcompany.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {
    public CartPage(WebDriver driver) {
        super(driver);
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public void openCart() {
        By cartButton = By.id("ci");
        click(cartButton);
    }
}
