package framework;

import framework.utils.ConfigReader;
import framework.utils.browsers.BrowserEnum;
import framework.utils.browsers.BrowserFactory;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

/**
 * Created by User on 22.06.2017.
 */
public class BaseEntity {

    public Logger logger = Logger.getLogger(BaseEntity.class);
    public static WebDriver driver;

    public BaseEntity() {
    }

    public BaseEntity(WebDriver driver1) {
        driver = driver1;
    }

    public static WebDriver getDriver() {
        return driver;
    }
}
