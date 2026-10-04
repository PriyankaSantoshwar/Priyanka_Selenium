package com.saucedemo.automation.tests.products;

import com.saucedemo.automation.base.DriverContext;
import com.saucedemo.automation.pages.LoginPage;
import com.saucedemo.automation.pages.ProductsPage;
import com.saucedemo.automation.testdata.DemoUsers;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProductsTests {
    @Test
    public void productsCanBeSortedByPriceAscending() {
        ProductsPage productsPage = new LoginPage(DriverContext.getDriver())
                .loginSuccessfully(DemoUsers.STANDARD_USERNAME, DemoUsers.PASSWORD);
        productsPage.sortPriceLowToHigh();

        List<BigDecimal> displayedPrices = productsPage.getProductPrices();
        List<BigDecimal> ascendingPrices = new ArrayList<>(displayedPrices);
        Collections.sort(ascendingPrices);

        Assert.assertEquals(displayedPrices, ascendingPrices,
                "Product prices should appear in ascending order after sorting.");
    }
}
