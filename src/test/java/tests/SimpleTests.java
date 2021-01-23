package tests;


import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.*;
import utils.NavigationUtils;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class SimpleTests {
    WebDriver driver;
    MainPage mainPage;
    LogInPage loginPage;
    AboutUsPage aboutUsPage;
    ProductsPage productsPage;
    NoutatiPage noutatiPage;
    NavigationUtils navigationUtils;
    FavouritePage favouritePage;
    WebDriverWait wait;
    SeparateLInksPage separateLInksPage;
    SocialMediaPages socialMediaPages;


    @BeforeEach
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/seleniumdriver/chromedriver/chromedriver 2");
        driver = new ChromeDriver();
        mainPage = new MainPage(driver);
        loginPage = new LogInPage(driver);
        aboutUsPage = new AboutUsPage(driver);
        productsPage = new ProductsPage(driver);
        noutatiPage = new NoutatiPage(driver);
        navigationUtils = new NavigationUtils(driver);
        favouritePage = new FavouritePage(driver);
        separateLInksPage = new SeparateLInksPage(driver);
        socialMediaPages = new SocialMediaPages(driver);
        wait = new WebDriverWait(driver, 5);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("https://www.depurtat.ro/");
    }

     @AfterEach
     public void tearDown() {
       driver.quit();
    }

    @Test
    @Order(1)
    public void checkThatUserIsAbleToAccessMainPage() {
        assertEquals(driver.getTitle(), mainPage.getTitle());
        assertTrue(mainPage.checkThatIamOnMainPage());

    }

    @Test
    @Order(2)
    public void checkThatUserIsAbleToLoginWithCorrectUserAndPassword() {

        String user = "eneredqa@gmail.com", password = "Parola123!@";
        String titleUserPage = "dEpurtat - Vizualizare cont";
        navigationUtils.navigateToLoginPage();
        loginPage.inputUserNameAndPassword(user, password);
        assertEquals(driver.getTitle(), titleUserPage);
        assertEquals(driver.getCurrentUrl(), "https://www.depurtat.ro/profile");
    }

    @Test
    @Order(3)
    public void checkThatUserIsAbleToLogOut() throws InterruptedException {
        String user = "eneredqa@gmail.com", password = "Parola123!@";
        String titleUserPage = "dEpurtat - Vizualizare cont";
        navigationUtils.navigateToLoginPage();
        loginPage.inputUserNameAndPassword(user, password);
        navigationUtils.getAcceptConditions().click();
        loginPage.logOutFromAccount();
        assertTrue(loginPage.checkThatImLogOut());
    }

    @Test
    @Order(4)
    public void checkThatUserIsAbleToAddMultipleProductsToFavourite() throws InterruptedException {
        navigationUtils.navigateToNoutatiPage();
        noutatiPage.addMultipleProductsToFavourite();
        Thread.sleep(3000);
        int counterFavourite = noutatiPage.getNumberOfFavouriteProducts();
        assertEquals(counterFavourite, 4);
    }

    @Test
    @Order(5)
    public void checkThatUserIsAbleToRemoveAFavouriteProductFromItsFavouritesList() throws InterruptedException {
        navigationUtils.navigateToNoutatiPage();
        noutatiPage.addMultipleProductsToFavourite();
        Thread.sleep(3000);
        navigationUtils.navigateToFavouritePage();
        int counterFavouriteProducts = 4;
        assertEquals(noutatiPage.getNumberOfFavouriteProducts(), counterFavouriteProducts);
        favouritePage.deleteMultipleProductsFromFavouritesList();
        wait.until(ExpectedConditions.visibilityOf(noutatiPage.getButtonAllFavouriteProducts()));
        assertEquals(noutatiPage.getNumberOfFavouriteProducts(), 2);
    }

    @Test
    @Order(6)
    public void checkThatUserIsAbleToSorProductFromNoutatiPageOrderBy() throws InterruptedException {
        navigationUtils.navigateToNoutatiPage();
        noutatiPage.getDropdownCategorii().click();
        noutatiPage.getCheckboxGhete().click();
        navigationUtils.navigateToFavouritePage();

    }

    @Test
    @Order(7)
    public void checkThatUserIsAbleToSortBYPriceDescending() throws InterruptedException {
        String url = "https://www.depurtat.ro/sport?s=price_desc";
        String actualurl = driver.getCurrentUrl();
        productsPage.orderProductsByPriceDescending();
        //de facut un assert


    }

    @Test
    @Order(8)
    public void checkThatUserIsAbleToSubscribeToNewsletter() {
        String email = "0eneredqa@gmail.com";
        assertTrue(loginPage.subscribeToNewsletter(email));
    }

    @Test
    @Order(9)
    public void checkIfMapPageIsOpen() throws InterruptedException {
        navigationUtils.scroolToAllPage();
        separateLInksPage.openMapPage();
        String expectedtitle = "Șoseaua Virtuții 148 - Google Maps";
        String actualtitle = driver.getTitle();
        assertEquals(expectedtitle, actualtitle);

    }

    @Test
    @Order(10)
    public void checkYoutubeIcon() {
        navigationUtils.scroolToAllPage();
        separateLInksPage.openYoutubePage();
        String expectedTitle = "dEpurtat Incaltamine de dama - YouTube";
        String actualTitle = driver.getTitle();
        assertEquals(expectedTitle, actualTitle);

    }

    @Test
    @Order(11)
    public void checkInstagramButton() {
        navigationUtils.scroolToAllPage();
        separateLInksPage.openInstagramPage();
        String expectedTitle = "dEpurtat.ro (@depurtatro) • Fotografii şi clipuri video pe Instagram";
        String actualTitle = driver.getTitle();
        assertEquals(expectedTitle, actualTitle);
    }

    @Test
    @Order(12)
    public void checkFacebookButton() {
        navigationUtils.scroolToAllPage();
        separateLInksPage.openFacebookPage();
        String expectedTitle = "dEpurtat.ro - Home | Facebook";
        String actualTitle = driver.getTitle();
        assertEquals(expectedTitle, actualTitle);
    }

    @Test
    @Order(13)
    public void checkLanguageSwitchFunction() throws InterruptedException {
        navigationUtils.scroolToAllPage();
        navigationUtils.changeLanguage();
        String pageTitle = "Udobni damski obuvki - udobni.bg";
        String actualTitle = driver.getTitle();
        assertEquals(actualTitle, pageTitle);
        // navigationUtils.changeLanguage();
    }

    @Test
    @Order(14)
    public void checkDropDownCategorii() throws InterruptedException {
        navigationUtils.getButtonNoutati().click();
        //  Thread.sleep(3000);
        //Select dropDownselect = new Select(driver.findElement(By.xpath("//*[@id=\"page_top_box_product_filters_content\"]/div[1]/div/button")));
        //dropDownselect.selectByVisibleText("Ghete");
        WebElement categorii = driver.findElement(By.xpath("//*[@id=\"page_top_box_product_filters_content\"]/div[1]/div/button"));
        categorii.click();
        Thread.sleep(3000);
        List<WebElement> elm = driver.findElements(By.xpath("//*[@id=\"page_top_box_cat_cat_content\"]/div[2]/div/ul"));
        // int s = elm.size();
        for (int j = 0; j < elm.size(); j++) {
            System.out.println(elm.get(j).getText());
            if(elm.get(j).getText().equals("Ghete")){
                elm.get(j).click();
//
            }
            break;
        }
    }


}

