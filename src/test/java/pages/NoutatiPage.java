package pages;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.NavigationUtils;

import javax.xml.xpath.XPath;

@Getter
public class NoutatiPage {
    WebDriver driver;
    NavigationUtils navigationUtils;


    public NoutatiPage(WebDriver driver) {
        this.driver = driver;
        navigationUtils = new NavigationUtils(driver);
        PageFactory.initElements(driver, this);
    }

    private String title = "Produse noi - dEpurtat";
    private String pageHeaderMessage = "Produse noi";


    @FindBy(xpath = "//*[@id=\"page_content\"]/h1")
    private WebElement pageHeaderWebelement;
    @FindBy(xpath = "//*[@id=\"page_content\"]/div[5]/div/div[1]/div/div[1]/a[2]/span")
    private WebElement buttonAddToFavourite1;
    @FindBy(xpath = "//*[@id=\"page_content\"]/div[5]/div/div[2]/div/div[1]/a[2]/span")
    private WebElement buttonAddToFavourite2;
    @FindBy(xpath = "//*[@id=\"page_content\"]/div[5]/div/div[3]/div/div[1]/a[2]/span")
    private WebElement buttonAddToFavourite3;
    @FindBy(xpath = "//*[@id=\"page_content\"]/div[5]/div/div[5]/div/div[1]/a[2]/span")
    private WebElement buttonAddToFavourite5;
    @FindBy(xpath = "//*[@id=\"header\"]/div[2]/div[1]/div/a[2]/span[1]")
    private WebElement buttonAllFavouriteProducts;
    @FindBy(xpath = "//*[@id=\"page_top_box_product_filters_content\"]/div[1]/div/button")
    private WebElement dropdownCategorii;
    @FindBy(xpath = "//*[@id=\"page_top_box_cat_cat_content\"]/div[2]/div/ul/li[1]/div/a")
    private WebElement checkboxGhete;
    @FindBy(xpath = "//*[@id=\"header\"]/div[3]/div/nav/ul/li[1]/a")
    WebElement noutatiButton;


    public void addProductToFavourite(WebElement element) {
        navigationUtils.scrollToElement(element);
        element.click();
    }

    public void addMultipleProductsToFavourite() {
        addProductToFavourite(buttonAddToFavourite1);
        addProductToFavourite(buttonAddToFavourite2);
        addProductToFavourite(buttonAddToFavourite3);
        addProductToFavourite(buttonAddToFavourite5);
    }

    public int getNumberOfFavouriteProducts() {
        buttonAllFavouriteProducts.click();
        // navigationUtils.scrollToElement(buttonAllFavouriteProducts);
        return Integer.parseInt(buttonAllFavouriteProducts.getAttribute("data-counter"));
    }
}