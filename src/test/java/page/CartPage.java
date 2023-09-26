package page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CartPage extends Page{
    @FindBy(className = "cart_item")
    private List<WebElement> listOfProductsInCart;

    @FindBy(className = "inventory_item_name")
    private List<WebElement> listOfProductNamesInCart;

    @FindBy(className = "shopping_cart_badge")
    private WebElement cartCounter;

    @FindBy(xpath = "//div[@class='cart_item']//button")
    private List<WebElement> listOfRemoveButtonsInCart;


    public List<WebElement> getListOfProductsInCart() {
        return listOfProductsInCart;
    }

    public List<WebElement> getListOfProductNamesInCart() {
        return listOfProductNamesInCart;
    }

    public int getNumberOfProductsInCart() {
        int numberOfProducts = listOfProductsInCart.size();
        return numberOfProducts;
    }

    public int getNumberOfProductNamesInCart() {
        int numberOfProductNames = listOfProductNamesInCart.size();
        return numberOfProductNames;
    }

    public WebElement getCartCounter() {
        return cartCounter;
    }

    public List<WebElement> getListOfRemoveButtonsInCart() {
        return listOfRemoveButtonsInCart;
    }
}
