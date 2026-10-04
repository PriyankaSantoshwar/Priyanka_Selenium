package com.yourcompany.pages;

import com.yourcompany.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
    private final By accountButton = By.cssSelector("label[for='dpdw-login']");
    private final By signInButton = By.cssSelector("a[class='btn _prim -fw _md']");
    private final By searchBar = By.id("fi-q");
    private final By searchButton = By.cssSelector(".btn._prim._md.-mls.-fsh0");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void closePopup() {
        By popup = By.xpath("//button[@aria-label='newsletter_popup_close-cta']");
        if (isDisplayed(popup)) {
            click(popup);
        }
    }

    public LoginPage goToLoginPage() {
        click(accountButton);
        click(signInButton);
        return new LoginPage(driver);
    }

    public SearchResultsPage search(String keyword) {
        type(searchBar, keyword);
        click(searchButton);
        return new SearchResultsPage(driver);
    }
}
