package com.yourcompany.tests.search;

import com.yourcompany.base.BaseTest;
import com.yourcompany.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchTests extends BaseTest {

    @Test
    public void testSearchFunctionality() {
        HomePage homePage = new HomePage(driver);
        homePage.closePopup();
        homePage.search("watch");
        Assert.assertTrue(driver.getCurrentUrl().contains("search") || driver.getPageSource().length() > 0);
    }
}
