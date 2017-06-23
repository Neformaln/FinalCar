package framework.utils;

import org.openqa.selenium.WebDriver;

/**
 * Created by User on 22.06.2017.
 */
public class OSHelper {
private static WebDriver driver;

    public void osHelper(String driverName, String driverKeyWin, String driverKeyLin) {
        ConfigReader generalFunctions = new ConfigReader();
        String osType = System.getProperty("os.name").toLowerCase();
        if(osType.indexOf( "win" ) >= 0){
            System.setProperty(driverName, generalFunctions.readProperties("config.properties").getProperty(driverKeyWin));
        }
        else if(osType.indexOf( "nix") >=0 || osType.indexOf( "nux") >=0) {
            System.setProperty(driverName, generalFunctions.readProperties("config.properties").getProperty(driverKeyLin));
        }
    }


}
