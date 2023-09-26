package serviceSteps;

import io.qameta.allure.Step;
import page.CartPage;

public class CartPageService {
    private CartPage cartPage = new CartPage();

    @Step("Getting names of products in the cart")
    public String[] getProductNamesInCart() {
        int numberOfProductNames = cartPage.getNumberOfProductNamesInCart();
        String[] productNamesInCart = new String[numberOfProductNames];
        for (int i = 0; i < numberOfProductNames; i++) {
            productNamesInCart[i] = cartPage.getListOfProductNamesInCart().get(i).getText();
        }
        return productNamesInCart;
    }

    @Step("Getting cart counter value")
    public int getCartCounterValue() {
        int cartCounterValue = Integer.parseInt(cartPage.getCartCounter().getText());
        return cartCounterValue;
    }

    @Step("Removing first product from the cart")
    public CartPageService RemoveFirstProductInCart() {
        cartPage.getListOfRemoveButtonsInCart().get(0).click();
        return this;
    }
}
