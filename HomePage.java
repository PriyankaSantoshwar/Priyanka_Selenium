package pages;

import org.openqa.selenium.By;

public class HomePage extends BasePage{

private final By accountButton =By.cssSelector("label[for='dpdw-login']");
private final By myAccountButton=By.linkText("My Account");
private final By signInButton=By.cssSelector("a[class='btn _prim -fw _md']");
private final By logOutButton=By.cssSelector("button[type='submit']");
private final By savedItemsButton=By.linkText("Saved Items");
private final By popUp=By.xpath("//button[@aria-label='newsletter_popup_close-cta']");
private final By searchBar=By.id("fi-q");
private final By searchButton=By.cssSelector(".btn._prim._md.-mls.-fsh0");
private final By signingAssertionText=By.cssSelector("label[for='dpdw-login']");
private final By cartButton=By.id("ci");
private final By arabicLanguageButton=By.cssSelector("a[class='-vrl -fs0'] span[class='-dif -i-ctr -fs12']");
private final By changingLanguageAssertionText=By.xpath("//label[text()='تسجيل الدخول']");
private final By newsLetterEmailField=By.id("fi-nl-ft-email");
private final By newsLetterMale=By.cssSelector("button[value='male']");
private final By newsLetterFemale=By.cssSelector("button[value='female']");
private final By newsLetterMessage=By.cssSelector(".cnt");
private final By existSubscriptionMessage=By.xpath("//div[@class='fi-er']");
private final By cookiesCancelButton=By.cssSelector(".cls");

public void closePopUp(){
    click(popUp);
}
public AuthenticationPage goToSignInPage(){
    click(accountButton);
    click(signInButton);
    return new AuthenticationPage();
}
public SearchResultsPage search(String searchWord){
    sendKeys(searchBar,searchWord);
    click(searchButton);
    return  new SearchResultsPage();
}
public String getAssertionText(){
    return getText(signingAssertionText);
}
public MyAccountPage goToMyAccountPage()   {
    click(accountButton);
    click(myAccountButton);
    return new MyAccountPage();
}
public SavedItemsPage goToSavedItemsPage()   {
        click(accountButton);
        click(savedItemsButton);
        return new SavedItemsPage();
    }
public void Logout(){
    click(accountButton);
    click(logOutButton);
}
public String logOutAssertionText(){
    return getText(accountButton);
}
public CartPage gotoCart(){
    click(cartButton);
    return new CartPage();
}
public void changeToArabic(){
    click(arabicLanguageButton);
}
public String arabicAssertionText(){
    return getText(changingLanguageAssertionText);
}
public void enterEmailForNewsLetter(String email){
    sendKeys(newsLetterEmailField,email);
}
public void chooseGender(String gender){
    if (gender=="male"){
        click(newsLetterMale);
    } else if (gender=="female") {
        click(newsLetterFemale);
    }
}
public String getNewsLetterEmailMessage(){
    return getText(newsLetterMessage);
}
public String getAlreadySubscribedMessage(){
    return getText(existSubscriptionMessage);
}
public void cancelCookiesMessage(){
    elementVisibilityExplicitWait(cookiesCancelButton,8);
    click(cookiesCancelButton);
}

}

//--playwrite
package pages;
 
import com.microsoft.playwright.Page;
 
public class HomePage extends BasePage {
 
private final String accountButton = "label[for='dpdw-login']";
private final String myAccountButton = "text=My Account";
private final String signInButton = "a.btn._prim.-fw._md";
private final String logOutButton = "button[type='submit']";
private final String savedItemsButton = "text=Saved Items";
private final String popUp = "//button[@aria-label='newsletter_popup_close-cta']";
private final String searchBar = "#fi-q";
private final String searchButton = ".btn._prim._md.-mls.-fsh0";
private final String signingAssertionText = "label[for='dpdw-login']";
private final String cartButton = "#ci";
private final String arabicLanguageButton =
"a.-vrl.-fs0 span.-dif.-i-ctr.-fs12";
private final String changingLanguageAssertionText =
"//label[text()='تسجيل الدخول']";
private final String newsLetterEmailField = "#fi-nl-ft-email";
private final String newsLetterMale = "button[value='male']";
private final String newsLetterFemale = "button[value='female']";
private final String newsLetterMessage = ".cnt";
private final String existSubscriptionMessage = "//div[@class='fi-er']";
private final String cookiesCancelButton = ".cls";
 
public HomePage(Page page) {
super(page);
}
 
public void closePopUp() {
page.locator(popUp).click();
}
 
public AuthenticationPage goToSignInPage() {
click(accountButton);
click(signInButton);
return new AuthenticationPage(page);
}
 
public SearchResultsPage search(String searchWord) {
fill(searchBar, searchWord);
click(searchButton);
return new SearchResultsPage(page);
}
 
public String getAssertionText() {
return getText(signingAssertionText);
}
 
public MyAccountPage goToMyAccountPage() {
click(accountButton);
click(myAccountButton);
return new MyAccountPage(page);
}
 
public SavedItemsPage goToSavedItemsPage() {
click(accountButton);
click(savedItemsButton);
return new SavedItemsPage(page);
}
 
public void logout() {
click(accountButton);
click(logOutButton);
}
 
public String logOutAssertionText() {
return getText(accountButton);
}
 
public CartPage gotoCart() {
click(cartButton);
return new CartPage(page);
}
 
public void changeToArabic() {
click(arabicLanguageButton);
}
 
public String arabicAssertionText() {
return getText(changingLanguageAssertionText);
}
 
public void enterEmailForNewsLetter(String email) {
fill(newsLetterEmailField, email);
}
 
public void chooseGender(String gender) {
 
if ("male".equalsIgnoreCase(gender)) {
click(newsLetterMale);
} else if ("female".equalsIgnoreCase(gender)) {
click(newsLetterFemale);
}
}
 
public String getNewsLetterEmailMessage() {
return getText(newsLetterMessage);
}
 
public String getAlreadySubscribedMessage() {
return getText(existSubscriptionMessage);
}
 
public void cancelCookiesMessage() {
page.locator(cookiesCancelButton)
.waitFor();
 
click(cookiesCancelButton);
}
}

