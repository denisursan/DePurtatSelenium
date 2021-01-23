package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Iterator;
import java.util.Set;

public class SeparateLInksPage {
    WebDriver driver;

    public SeparateLInksPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"footer\"]/div[3]/div/div/div[3]/div[2]/div[1]/a/img")
    WebElement buttonMap;
    @FindBy(xpath = "//*[@id=\"footer_social_icons\"]/a[3]")
    WebElement buttonYoutube;
    @FindBy(xpath = "//*[@id=\"footer_social_icons\"]/a[2]")
    WebElement instagramButton;
    @FindBy(xpath = "//*[@id=\"footer_social_icons\"]/a[1]")
    WebElement facebookButton;


    public void openMapPage() {
        buttonMap.click();
        String currentWindowHandle = driver.getWindowHandle();
        Set<String> allWindowHandles = driver.getWindowHandles();
        Iterator iter = allWindowHandles.iterator();
        while (iter.hasNext()) {
            String windowHandle = (String) iter.next();
            // Thread.sleep(3000);
            driver.switchTo().window(windowHandle);
            if (driver.getTitle().equals("Șoseaua Virtuții 148 - Google Maps")) {
                break;
            }
        }
    }

    public void openYoutubePage() {
        buttonYoutube.click();
        String currentWindowHandle = driver.getWindowHandle();
        Set<String> allWindowHandles = driver.getWindowHandles();
        Iterator iter = allWindowHandles.iterator();
        while (iter.hasNext()) {
            String windowHandle = (String) iter.next();
            // Thread.sleep(3000);
            driver.switchTo().window(windowHandle);
            if (driver.getTitle().equals("dEpurtat Incaltamine de dama - YouTube")) {
                break;
            }
        }
    }

    public void openInstagramPage() {
        instagramButton.click();
        String currentWindowHandle = driver.getWindowHandle();
        Set<String> allWindowHandles = driver.getWindowHandles();
        Iterator iter = allWindowHandles.iterator();
        while (iter.hasNext()) {
            String windowHandle = (String) iter.next();
            // Thread.sleep(3000);
            driver.switchTo().window(windowHandle);
            if (driver.getTitle().equals("dEpurtat.ro (@depurtatro) • Fotografii şi clipuri video pe Instagram")) {
                break;
            }
        }

    }

    public void openFacebookPage() {
        facebookButton.click();
        String currentWindowHandle = driver.getWindowHandle();
        Set<String> allWindowHandles = driver.getWindowHandles();
        Iterator iter = allWindowHandles.iterator();
        while (iter.hasNext()) {
            String windowHandle = (String) iter.next();
            // Thread.sleep(3000);
            driver.switchTo().window(windowHandle);
            if (driver.getTitle().equals("dEpurtat.ro - Home | Facebook")) {
                break;
            }
        }
    }
}




