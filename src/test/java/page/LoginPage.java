package page;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.Waiter;

@Log4j2
public class LoginPage extends Page{
    @FindBy(xpath = "//input[@id='user-name']")
    // более эффективный способ инициализации, но не подходит для динамических локаторов
    private WebElement usernameField;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement passwordField;

    @FindBy(xpath = "//input[@id='login-button']")
    private WebElement loginButton;

    public LoginPage openPage(String url) {
        driver.get(url);
        return this;
    }

    public LoginPage fillInUserName(String userName) {
        log.info("Enter login");
        Waiter.waitElementToBeVisible(usernameField).sendKeys(userName);    //пример ожидания
        return this;
    }

    public LoginPage fillInPassword(String password) {
        log.info("Enter password");
        Waiter.waitElementToBeVisible(passwordField).sendKeys(password); //пример ожидания
        return this;
    }

    public LoginPage clickLoginButton() {
        log.info("Click button");
        Waiter.waitElementToBeClickable(loginButton).click(); //пример ожидания
        return this;
    }
}
