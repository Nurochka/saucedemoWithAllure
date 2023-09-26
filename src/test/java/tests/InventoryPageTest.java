package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import io.qameta.allure.TmsLink;
import model.User;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import serviceSteps.InventoryPageService;
import serviceSteps.LoginPageService;

public class InventoryPageTest extends BaseTest {
    private int productIndex;

    @BeforeClass
    public void setUp() {
        loginPageService = new LoginPageService();
        user = new User();
    }

    @Test(description="Checking that button name is changed after clicking")
    @Description("Validation of changing button name after clicking")
    @Issue("ISSUE-999")
    @TmsLink("TMS-66")
    public void checkAddToCartButtonChangeItsNameAfterClickingTest() {
        InventoryPageService inventoryPageService = loginPageService.login(user);
        productIndex = 4;
        //String initialButtonName = inventoryPageService.getButtonNameByIndex(productIndex);
        String clickedButtonName = inventoryPageService.clickAddToCartButtonByIndex(productIndex).getButtonNameByIndex(productIndex);
        Assert.assertEquals(clickedButtonName, "Remove");
    }
}
