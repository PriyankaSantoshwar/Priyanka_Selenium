package com.yourcompany.tests.login;

import com.yourcompany.base.BaseTest;
import com.yourcompany.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {

    @Test
    public void testSuccessfulLogin() {
        HomePage homePage = new HomePage(driver);
        homePage.closePopup();
        homePage.goToLoginPage().login("testuser@example.com", "Test@1234");
        Assert.assertTrue(driver.getCurrentUrl().contains("jumia"));
    }
}
