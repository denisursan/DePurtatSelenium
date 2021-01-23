package pages;

import lombok.Getter;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.NavigationUtils;

@Getter
public class LogInPage {
    private WebDriver driver;
    NavigationUtils navigationUtils;

    public LogInPage(WebDriver driver) {
        this.driver = driver;
        navigationUtils = new NavigationUtils(driver);
        PageFactory.initElements(driver, this);
    }

    private String title = "Acces cont - dEpurtat";
    @FindBy(id = "profile_email")
    private WebElement inputEmailField;
    @FindBy(id = "profile_password")
    private WebElement inputPasswordField;
    @FindBy(xpath = "//*[@id=\"page_login_form\"]/div[4]/button")
    private WebElement buttonAccesCont;
    @FindBy(xpath= "//body/main[@id='main']/div[1]/div[1]/div[1]/div[4]/div[1]/div[1]/ul[1]/li[6]/a[1]")
    private WebElement buttonIesireCont;
    @FindBy(id = "newsletter_email")
    WebElement SubscribeFieldEmail;
    @FindBy(id = "message_newsletter_email")
    WebElement messageAddressIsAlreadyUsedForNewsletter;

    public void inputUserNameAndPassword(String email, String password) {
        getInputEmailField().click();
        getInputEmailField().sendKeys(email);
        getInputPasswordField().click();
        getInputPasswordField().sendKeys(password);
        getButtonAccesCont().click();
    }

    public void logOutFromAccount() {
        buttonIesireCont.click();

    }

    public boolean checkThatImLogOut() throws InterruptedException {
        navigationUtils.getButtonLogin().click();
        if (inputEmailField.isDisplayed()) {
            return true;
        }
        return false;
    }

    public boolean subscribeToNewsletter(String email) {
        JavascriptExecutor jse = ((JavascriptExecutor) driver);
        jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        getSubscribeFieldEmail().sendKeys(email);
        getSubscribeFieldEmail().sendKeys(Keys.ENTER);
        // public boolean checkIfSubscriptionWasSucces(){
        if (messageAddressIsAlreadyUsedForNewsletter.isDisplayed()) {
            return true;
        } else {
            return false;
        }

    }
}


