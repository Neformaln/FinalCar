package framework.cars.pages;

import framework.BaseEntity;
import framework.cars.elements.BaseElement;
import framework.utils.ConfigReader;
import framework.utils.browsers.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.Properties;

/**
 * Created by User on 22.06.2017.
 */
public class BasePage extends BaseEntity{
    private static final String MAIN_PROPERTY_PATH = "config.properties";

    public BasePage(){}

    public BasePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public BasePage(By titleLocator, String title){}

    public Properties initProperties() {
        ConfigReader configReader = new ConfigReader();
        Properties properties = configReader.readProperties(MAIN_PROPERTY_PATH);
        return properties;
    }

    public void maximiseWindow() {
        BrowserFactory.maximiseWindow();
    }

    public void navigate(String url) {
        BrowserFactory.navigateUrl(url);
    }

    public void exit() {
        BrowserFactory.exit();
    }

    public void foundElementPage (BaseElement element) throws Exception {
        Assert.assertTrue(element.isDisplayed(),"Element not found");
    }
}
