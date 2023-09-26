package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import io.qameta.allure.Link;
import io.qameta.allure.TmsLink;
import model.User;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import serviceSteps.InventoryPageService;
import serviceSteps.LoginPageService;

public class LoginPageTest extends BaseTest{

    @BeforeClass
    public void setUp() {
        loginPageService = new LoginPageService();
        user = new User(); //можно инициализировать и в тестовом методе
    }

    @Test(description="Checking success login")
    @Description("Validation of login process")
    @Issue("ISSUE-123")
    @TmsLink("TMS-12")
    public void checkSuccessfulLoginTest() {
        InventoryPageService inventoryPageService = loginPageService.login(user);
        String actualTextOfMainPageSection = inventoryPageService.getActualNameOfMainPageSection();
        String expectedTextOfMainPageSection = "Products";
        Assert.assertEquals(actualTextOfMainPageSection, expectedTextOfMainPageSection, "Login failed!" +
                " Actual name doesn't match expected");

    }
}
