package com.saucedemo.automation.pages;

import com.saucedemo.automation.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.math.BigDecimal;
import java.util.List;

public class ProductsPage extends BasePage {
    private final By inventoryList = By.className("inventory_list");
    private final By productPrices = By.className("inventory_item_price");
    private final By sortDropdown = By.cssSelector("[data-test='product-sort-container']");
    private final By cartLink = By.className("shopping_cart_link");
    private final By menuButton = By.id("react-burger-menu-btn");
    private final By logoutLink = By.id("logout_sidebar_link");
    private final By loginButton = By.cssSelector("[data-test='login-button']");

    public ProductsPage(WebDriver driver) {
        super(driver);
        wait.until(ExpectedConditions.visibilityOfElementLocated(inventoryList));
    }

    public List<BigDecimal> getProductPrices() {
        return findAll(productPrices).stream()
                .map(element -> new BigDecimal(element.getText().replace("$", "")))
                .toList();
    }

    public void sortPriceLowToHigh() {
        new Select(find(sortDropdown)).selectByValue("lohi");
    }

    public void addBackpackToCart() {
        By addBackpackButton = By.id("add-to-cart-sauce-labs-backpack");
        clickWithJavaScript(addBackpackButton);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("shopping_cart_badge")));
    }

    public CartPage openCart() {
        clickWithJavaScript(cartLink);
        wait.until(ExpectedConditions.urlContains("cart.html"));
        return new CartPage(driver);
    }

    public LoginPage logout() {
        click(menuButton);
        clickWithJavaScript(logoutLink);
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginButton));
        return new LoginPage(driver);
    }
}
