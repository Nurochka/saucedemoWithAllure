package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import io.qameta.allure.TmsLink;
import model.User;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import serviceSteps.CartPageService;
import serviceSteps.InventoryPageService;
import serviceSteps.LoginPageService;

import java.util.Arrays;

public class CartTest extends BaseTest{
    private int productIndex;

    @BeforeClass
    public void setUp() {
        loginPageService = new LoginPageService();
        user = new User();
    }

    @Test(description="Checking name of previously added product in the cart")
    @Description("Validation adding product process")
    @Issue("ISSUE-222")
    @TmsLink("TMS-13")
    public void checkNameOfAddedProductInCartTest() {
        InventoryPageService inventoryPageService = loginPageService.login(user);
        productIndex = 4;
        String nameOfAddedToCartProduct = inventoryPageService.getProductNameByIndex(productIndex);
        inventoryPageService.clickAddToCartButtonByIndex(productIndex);
        CartPageService cartPageService = inventoryPageService.navigateToShoppingCart();
        String[] namesOfProductsInCart = cartPageService.getProductNamesInCart();
        Boolean isProductInCart = Arrays.asList(namesOfProductsInCart).contains(nameOfAddedToCartProduct);
        Assert.assertTrue(isProductInCart);
    }

    @Test(description="Checking cart counter")
    @Description("Validation cart counter after adding products")
    public void checkCounterValueCorrespondsNumberOfProductsInCartTest() {
        InventoryPageService inventoryPageService = loginPageService.login(user);
        productIndex = 1;
        inventoryPageService.clickAddToCartButtonByIndex(productIndex);
        CartPageService cartPageService = inventoryPageService.navigateToShoppingCart();
        int numberOfProductsInCart = cartPageService.getProductNamesInCart().length;
        int counterValue = cartPageService.getCartCounterValue();
        Assert.assertEquals(numberOfProductsInCart, counterValue);
    }

    @Test(description="Checking product can be removed from the cart")
    @Description("Removing product from the cart")
    public void checkProductCanBeRemovedFromCartTest() {
        InventoryPageService inventoryPageService = loginPageService.login(user);
        productIndex = 3;
        inventoryPageService.clickAddToCartButtonByIndex(productIndex);
        CartPageService cartPageService = inventoryPageService.navigateToShoppingCart();
        int initialNumberOfProductsInCart = cartPageService.getProductNamesInCart().length;
        cartPageService.RemoveFirstProductInCart();
        int numberOfProductsInCartAfterRemoving = cartPageService.getProductNamesInCart().length;
        int removedQuantity = initialNumberOfProductsInCart - numberOfProductsInCartAfterRemoving;
        Assert.assertEquals(removedQuantity, 1);
    }
}
