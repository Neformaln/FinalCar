package framework.utils.browsers;

import framework.utils.OSHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class ChromeFactory extends BrowserFactory {
    private static final String driverName= "webdriver.chrome.driver";
    private static final String driverKeyWin = "driver_chrome_location_win";
    private static final String driverKeyLin = "driver_chrome_location_lin";
    private static  ChromeFactory instance = null;
    private static ChromeDriver driver;

    public static synchronized WebDriver getInstance() {
        if (instance == null)
            instance = new ChromeFactory();
        if(driver==null) {
            driver = new ChromeDriver();
        }
        return driver;
    }

    private ChromeFactory() {
        OSHelper os = new OSHelper();
        os.osHelper(driverName, driverKeyWin, driverKeyLin);
    }

    @Override
    public ChromeDriver getDriver() {
        return new ChromeDriver();
    }

}