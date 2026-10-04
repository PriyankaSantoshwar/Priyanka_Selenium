package com.saucedemo.automation.tests.logout;

import com.saucedemo.automation.base.DriverContext;
import com.saucedemo.automation.pages.LoginPage;
import com.saucedemo.automation.pages.ProductsPage;
import com.saucedemo.automation.testdata.DemoUsers;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LogoutTests {
    @Test
    public void loggedInUserCanLogOut() {
        ProductsPage productsPage = new LoginPage(DriverContext.getDriver())
                .loginSuccessfully(DemoUsers.STANDARD_USERNAME, DemoUsers.PASSWORD);

        LoginPage loginPage = productsPage.logout();

        Assert.assertTrue(loginPage.isDisplayed(), "Logout should return the user to the login page.");
        Assert.assertTrue(DriverContext.getDriver().getCurrentUrl().endsWith("/"));
    }
}
