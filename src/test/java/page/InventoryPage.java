package page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class InventoryPage extends Page{
    @FindBy(xpath = "//span[@class='title']")
    private WebElement nameOfMainPageSection;

    @FindBy(className = "inventory_item_name")
    private List<WebElement> listOfProducts;

    @FindBy(xpath = "//div[@class='inventory_item']//button")
    private List<WebElement> listOfProductButtons;

    @FindBy(xpath = "//a[@class='shopping_cart_link']")
    private WebElement cartButton;


    public String getTextOfNameOfMainPageSection() {
        return nameOfMainPageSection.getText();
    }

    public int getNumberOfProducts() {
        int numberOfProducts = listOfProducts.size();
        return numberOfProducts;
    }

    public int getNumberOfButtons() {
        int numberOfButtons = listOfProductButtons.size();
        return numberOfButtons;
    }

    public List<WebElement> getListOfProducts() {
        return listOfProducts;
    }

    public List<WebElement> getListOfProductButtons() {
        return listOfProductButtons;
    }

    public WebElement getCartButton() {
        return cartButton;
    }
}
