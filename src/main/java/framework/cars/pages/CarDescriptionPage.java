package framework.cars.pages;

import framework.cars.elements.Image;
import framework.cars.elements.Label;
import framework.utils.browsers.BrowserFactory;
import org.openqa.selenium.By;

/**
 * Created by User on 23.06.2017.
 */
public class CarDescriptionPage extends BasePage {

    public static  Label UNIQUE_PAGE_ELEMENT = new Label(By.xpath("//div[@id='mmy-trims']"));
    public static final Image MODIFICATION_LOCATOR = new Image(By.xpath("//div[@class='trim_listing'][1]/*/div[@class='trim_listing__image']/img"));

    public CarDescriptionPage() throws Exception {
        foundElementPage(UNIQUE_PAGE_ELEMENT);
    }

    public void selectFirstModification(){
        BrowserFactory.waitLoadingPage();
        MODIFICATION_LOCATOR.click();
    }
}
