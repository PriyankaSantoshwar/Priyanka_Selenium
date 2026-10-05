package com.saucedemo.automation.tests.login;

import com.saucedemo.automation.base.DriverContext;
import com.saucedemo.automation.pages.LoginPage;
import com.saucedemo.automation.pages.ProductsPage;
import com.saucedemo.automation.testdata.DemoUsers;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests {
    @Test

    public void validUserCanLogIn() {
        ProductsPage productsPage = new LoginPage(DriverContext.getDriver())
                .loginSuccessfully(DemoUsers.STANDARD_USERNAME, DemoUsers.PASSWORD);

        Assert.assertEquals(DriverContext.getDriver().getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
        Assert.assertFalse(productsPage.getProductPrices().isEmpty(), "The inventory should be displayed.");
    }

    @Test
    public void invalidPasswordShowsAnError() {
        LoginPage loginPage = new LoginPage(DriverContext.getDriver());
        loginPage.login(DemoUsers.STANDARD_USERNAME, "incorrect-password");

        Assert.assertEquals(
                loginPage.getErrorMessage(),
                "Epic sadface: Username and password do not match any user in this service");
        Assert.assertTrue(loginPage.isDisplayed(), "The user should remain on the login page.");
    }
}
