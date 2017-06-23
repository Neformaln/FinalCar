package framework.cars.pages;

import framework.cars.elements.Select;
import org.openqa.selenium.By;

/**
 * Created by User on 23.06.2017.
 */
public class Header extends BasePage {

    private Select UNIQUE_HEAD_LOCATOR = new Select(By.xpath("//a[contains(@class,'logo')]"));

    public Header() throws Exception {
        logger.info("Header create");
        Thread.sleep(5000);
        foundElementPage(UNIQUE_HEAD_LOCATOR);
    }

    public void openMainPage() throws InterruptedException {
        logger.info("Click logo");
        Thread.sleep(5000);
        UNIQUE_HEAD_LOCATOR.click();
    }
}
