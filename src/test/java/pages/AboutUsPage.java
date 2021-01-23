package pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Getter
public class AboutUsPage {
    private WebDriver driver;

    public AboutUsPage(WebDriver pagedriver){
        this.driver= pagedriver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(id = "menu_link_1626469")
    private WebElement aboutUsButton;
    @FindBy(id = "newsletter_email")
    private WebElement subscribeNewsletterField;
    @FindBy(xpath = "//*[@id=\"footer_top_newsletter_form\"]/div/div[2]/button")
    private WebElement subscribeButton;
    @FindBy(id = "message_newsletter_email")
    private WebElement subscribeFailedMessageElement;



    public boolean inputEmailAddressIntoSubscribeField(String email) throws InterruptedException {
        getAboutUsButton().click();
        getSubscribeNewsletterField().sendKeys(email);
        getSubscribeButton().click();
        Thread.sleep(5000);
        if (getSubscribeFailedMessageElement().isDisplayed()){
            return true;
        }else{
            return false;
        }
    }
}

