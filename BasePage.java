package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    protected static WebDriver driver;

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    /****Common Methods Used in Test Pages****/
    protected WebElement find(By locator){
        return driver.findElement(locator);
    }
    protected void click(By locator){
        find(locator).click();
    }
    protected String getText(By locator){
         return find(locator).getText();
    }
    protected void sendKeys(By locator, String text){
        find(locator).sendKeys(text);
    }
    protected void elementVisibilityExplicitWait(By locator, int duration){
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(duration));
            wait.until(ExpectedConditions.visibilityOf(driver.findElement(locator)));
    }
    protected void elementClickableExplicitWait(By locator, int duration){
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(duration));
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(locator)));
    }
    protected void elementInvisibilityExplicitWait(By locator, int duration){
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(duration));
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(locator)));
    }

}


//---Playwrite
package pages;
 
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
 
public class BasePage {
 
protected Page page;
 
public BasePage(Page page) {
this.page = page;
}
 
/**** Common Methods Used in Test Pages ****/
 
protected Locator find(String locator) {
return page.locator(locator);
}
 
protected void click(String locator) {
find(locator).click();
}
 
protected String getText(String locator) {
return find(locator).textContent();
}
 
protected void fill(String locator, String text) {
find(locator).fill(text);
}
 
protected void waitForElementVisible(String locator) {
find(locator).waitFor();
}
 
protected void waitForElementVisible(String locator, int timeoutMillis) {
find(locator).waitFor(
new Locator.WaitForOptions().setTimeout(timeoutMillis)
);
}
 
protected void waitForElementHidden(String locator, int timeoutMillis) {
find(locator).waitFor(
new Locator.WaitForOptions()
.setState(com.microsoft.playwright.options.WaitForSelectorState.HIDDEN)
.setTimeout(timeoutMillis)
);
}
 
protected boolean isVisible(String locator) {
return find(locator).isVisible();
}
 
protected boolean isEnabled(String locator) {
return find(locator).isEnabled();
}
}
