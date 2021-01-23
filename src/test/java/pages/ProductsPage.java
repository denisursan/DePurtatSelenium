package pages;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Getter
public class ProductsPage {
    private WebDriver driver;

    public ProductsPage(WebDriver driverpage) {
        this.driver = driverpage;
        //acts as an extension to the PageObject
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//header/div[3]/div[1]/nav[1]/ul[1]/li[7]/a[1]")
    private WebElement sportButton;
    @FindBy(xpath = "//*[@id=\"page_content\"]/div[5]/div/div[1]/div/div[1]/a[2]/span")
    private WebElement addToFavouriteButton;
    @FindBy(xpath = "//*[@id=\"header\"]/div[2]/div[1]/div/a[2]/span[1]")
    private WebElement goToFavouriteButton;
    @FindBy(xpath = "//*[@id=\"page_content\"]/div[4]/div/div/div/div[1]/a[2]/span")
    private WebElement deleteProductFromFavorites;
    @FindBy(id = "btn_cart_main_10683414")
    private WebElement adaugaInCos;
    @FindBy(xpath = "/html/body/main/div/div/div/div[5]/div/div[1]/div/div[1]/a[1]/img")
    WebElement produs;
    @FindBy(xpath = "//*[@id=\"buy_prod_specifications_form\"]/div[6]/div[3]/div/div/label/span[2]")
    WebElement sizeButton;
    @FindBy(xpath = "//*[@id=\"btn_cart_main_10683414\"]")
    WebElement adaugaInCos1;
    @FindBy(xpath = "//*[@id=\"header_middle_cart_preview\"]/a/span[2]")
    WebElement GoToBasket;
    @FindBy(css = "#page_cart_form > div.d-flex.flex-wrap.flex-lg-nowrap > div.box-cart-left.bg-cart > div > table > tbody > tr > td > div > table > tbody > tr > td:nth-child(1) > p > a > span")
    WebElement deleteProduct;
    @FindBy(xpath = "//*[@id=\"page_top_box_product_filters_content\"]/div[7]/div/button")
    WebElement celeMaiNoi;
    @FindBy(xpath = "//*[@id=\"page_top_box_sorting_content\"]/div[2]/div/ul/li[5]/div/a")
    WebElement priceDescending;
    @FindBy(xpath = "//*[@id=\"page_content\"]/div[5]/div/div[1]/div/div[2]/div[1]/div/span")
    WebElement descrierePret;

    //

    public void addAproductToFavouritesAndDeleteIt() throws InterruptedException {
        getSportButton().click();
        // todo de pus cu explicit
        Thread.sleep(5000);
        getAddToFavouriteButton().click();
        getGoToFavouriteButton().click();
        getDeleteProductFromFavorites().click();
    }

    public void setSizeOfAProductandSetSizeAndAddItInTheBasketAndDeleteIt() throws InterruptedException {
        getSportButton().click();
        Thread.sleep(5000);
        getProdus().click();
        getSizeButton().click();
        Thread.sleep(5000);
        getAdaugaInCos1().click();
        getGoToBasket().click();
        //Thread.sleep(5000);
        // getDeleteProduct().click();
        //getProdus().click();
        // getAdaugaInCos().click();


    }
    public void orderProductsByPriceDescending() throws InterruptedException {
        getSportButton().click();
        celeMaiNoi.click();
        priceDescending.click();
    }
}
