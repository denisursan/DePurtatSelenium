package pages;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

@Getter
public class DropDownButtons {
    WebDriver driver;

    public DropDownButtons(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebElement findCategoryByText(List<WebElement> liElements, String text) {
        for (WebElement element :
                liElements) {
            WebElement anchorElement = element.findElement(By.tagName("a"));
            if (anchorElement.getText().equals(text)) {
                return anchorElement;
            }
        }
        return null;
    }

    public void accesDropDownButtonCategories() {
        WebElement dropdownCategoriesBtn = driver.findElement(By.xpath("//*[@id=\"page_top_box_product_filters_content\"]/div[1]/div/button"));
        dropdownCategoriesBtn.click();


    }

    public void accesDropDownButtonMarime() {
        WebElement dropDownMarime = driver.findElement(By.xpath("//*[@id=\"page_top_box_product_filters_content\"]/div[2]/div/button"));
        dropDownMarime.click();

    }


}
