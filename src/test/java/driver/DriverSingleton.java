package driver;

import org.openqa.selenium.WebDriver;

public class DriverSingleton {
    private static ThreadLocal<DriverSingleton> instance = new ThreadLocal<>(); //потокобезопасность! предоставляет локальные переменные потока (hashCode)
    // для каждого потока свой driverSingleTone
    private WebDriver driver;

    private DriverSingleton() {

        driver = WebDriverFactory.getWebDriver();
    }

    public static synchronized DriverSingleton getInstance() {
        if (null == instance.get()) {
            instance.set(new DriverSingleton());
        }
        return instance.get();
    }

    public WebDriver getDriver() {
        return driver;
    }


    public void closeDriver() {
        try {
            driver.quit();
            driver = null;
        } finally {
            instance.remove();
        }
    }
}
