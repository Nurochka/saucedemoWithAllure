package tests;

import driver.DriverSingleton;
import model.User;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Listeners;
import serviceSteps.LoginPageService;

@Listeners(TestListener.class)
public class BaseTest {
    protected LoginPageService loginPageService;
    protected User user;

    @AfterClass
    public void stopBrowser() {
        DriverSingleton.getInstance().closeDriver();
    }

}
