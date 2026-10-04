package com.yourcompany.tests.register;

import com.yourcompany.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegisterTests extends BaseTest {

    @Test
    public void testRegisterPageOpens() {
        driver.get("https://www.jumia.com.eg");
        Assert.assertTrue(driver.getCurrentUrl().contains("jumia"));
    }
}
