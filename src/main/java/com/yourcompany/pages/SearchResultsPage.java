package com.yourcompany.pages;

import com.yourcompany.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchResultsPage extends BasePage {
    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    public boolean resultContains(String keyword) {
        By result = By.xpath("//*[contains(translate(normalize-space(string(.)), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'),'" + keyword.toLowerCase() + "')]");
        return !driver.findElements(result).isEmpty();
    }
}
