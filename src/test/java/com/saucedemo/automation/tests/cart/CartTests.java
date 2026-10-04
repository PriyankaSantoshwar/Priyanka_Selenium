package com.saucedemo.automation.tests.cart;

import com.saucedemo.automation.base.DriverContext;
import com.saucedemo.automation.pages.CartPage;
import com.saucedemo.automation.pages.LoginPage;
import com.saucedemo.automation.pages.ProductsPage;
import com.saucedemo.automation.testdata.DemoUsers;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTests {
    @Test
    public void addedProductAppearsInCart() {
        ProductsPage productsPage = new LoginPage(DriverContext.getDriver())
                .loginSuccessfully(DemoUsers.STANDARD_USERNAME, DemoUsers.PASSWORD);
        productsPage.addBackpackToCart();

        CartPage cartPage = productsPage.openCart();

        Assert.assertEquals(cartPage.getItemCount(), 1);
        Assert.assertTrue(cartPage.containsBackpack(), "The backpack should be present in the cart.");
    }
}
