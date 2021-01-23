package utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.MainPage;

public class NavigationUtils extends MainPage {
    private WebDriver driver;

    public NavigationUtils(WebDriver driverPagina) {
        super(driverPagina);
        this.driver = driverPagina;
        //PageFactory.initElements(driverPagina, this);
    }

    public void navigateToLoginPage() {
        getButtonLogin().click();
    }

    public void navigateToNoutatiPage() {
        getButtonNoutati().click();
    }

    public void navigateToFavouritePage() {
        getButtonFavorite().click();
    }

    public void scrollToElement(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void scroolToAllPage() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    public void changeLanguage() throws InterruptedException {
        if (getAcceptConditions().isDisplayed()) {
            getAcceptConditions().click();
        }
        getLanguageButton().click();
        // Thread.sleep(2000);
        getBulgarianlanguageButton().click();
    }
}