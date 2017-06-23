package framework.utils.browsers;


import framework.utils.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.naming.NamingException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


public abstract class BrowserFactory {
    private static final String MAIN_PROPERTY_PATH= "config.properties";
    private static WebDriver driver;
    private static Properties properties;
    public abstract WebDriver getDriver();


    public static WebDriver getDriver(final BrowserEnum type) throws Exception {
        switch (type) {
            case CHROME: {
                driver = ChromeFactory.getInstance();
                initProperties();
                return driver;
            }
            case FIREFOX: {
                driver = FirefoxFactory.getInstance();
                initProperties();
                return driver;
            }
            default:throw new Exception("Browser not found");
        }
    }

    public static WebDriver getDriver(final String type) throws Exception {
        for (BrowserEnum t : BrowserEnum.values()){
            if (t.toString().equalsIgnoreCase(type)){
                return getDriver(t);
            }
        }
        throw new NamingException("Wrong name browser");
    }

    public static void initProperties(){
        ConfigReader configReader = new ConfigReader();
        properties = configReader.readProperties(MAIN_PROPERTY_PATH);
    }

    public static void waitWithIgnoring(){
        Wait<WebDriver> wait = new WebDriverWait(driver, getTimeForLoadElement())
                .ignoring(java.util.NoSuchElementException.class, ElementNotVisibleException.class);
    }

    public static void waitImplicitly(){
        driver.manage().timeouts().implicitlyWait(getTimeForLoadElement(), TimeUnit.SECONDS);
    }

    public static void waitLoadingPage(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void waitElementExplicide(String locator){
        WebDriverWait wait = new WebDriverWait(driver, getTimeForLoadElement());
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
    }

    public static void waitElementsExplicide(String locator){
        WebDriverWait wait = new WebDriverWait(driver, getTimeForLoadElement());
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(locator)));
    }

    public static void maximiseWindow(){
        driver.manage().window().maximize();
    }

    public static void navigateUrl(String url){
        driver.navigate().to(url);
    }

    public static Long getTimeForLoadPage(){
        return Long.parseLong(properties.getProperty("timeoutLoad"));
    }

    public static Long getTimeForLoadElement(){
        return Long.parseLong(properties.getProperty("timeout"));
    }

    public static void waitPageToLoad(){
        try {
            Thread.sleep(getTimeForLoadPage());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void exit(){
        driver.close();
    }
}
