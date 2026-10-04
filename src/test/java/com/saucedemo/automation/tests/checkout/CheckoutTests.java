package com.saucedemo.automation.tests.checkout;

import com.saucedemo.automation.base.DriverContext;
import com.saucedemo.automation.pages.CartPage;
import com.saucedemo.automation.pages.CheckoutPage;
import com.saucedemo.automation.pages.LoginPage;
import com.saucedemo.automation.pages.ProductsPage;
import com.saucedemo.automation.testdata.DemoUsers;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutTests {
    @Test
    public void cartCanProceedToCustomerDetails() {
        ProductsPage productsPage = new LoginPage(DriverContext.getDriver())
                .loginSuccessfully(DemoUsers.STANDARD_USERNAME, DemoUsers.PASSWORD);
        productsPage.addBackpackToCart();

        CartPage cartPage = productsPage.openCart();
        CheckoutPage checkoutPage = cartPage.checkout();

        Assert.assertTrue(checkoutPage.isCustomerDetailsFormDisplayed(),
                "Checkout should display the required customer information fields.");
    }
}
