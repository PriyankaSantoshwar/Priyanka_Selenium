package com.yourcompany.tests.logout;

import com.yourcompany.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LogoutTests extends BaseTest {

    @Test
    public void testLogoutEntryPoint() {
        Assert.assertTrue(driver.getCurrentUrl().contains("jumia"));
    }
}
