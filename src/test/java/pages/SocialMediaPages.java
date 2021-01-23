package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SocialMediaPages {

    WebDriver driver;
    public SocialMediaPages(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath ="//*[@id=\"footer_social_icons\"]/a[1]")
    WebElement buttonFacebook;
    public void checkThatSocialMediaButtonsWork(){
        buttonFacebook.click();
    }

}
