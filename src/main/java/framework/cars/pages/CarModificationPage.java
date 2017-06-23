package framework.cars.pages;


import framework.cars.elements.Button;
import framework.cars.elements.CheckBox;
import framework.cars.elements.Label;
import org.openqa.selenium.By;

/**
 * Created by User on 23.06.2017.
 */
public class CarModificationPage extends BasePage {
    private Label UNIQUE_PAGE_MODIF_LOCATOR = new Label(By.xpath("//div[@id='mmy-overview']"));
    private static final Label ENGINE_LOCATOR = new Label(By.xpath("//td[@id='engine']"));
    private static final Label TRANSMISSION_LOCATOR = new Label(By.xpath("//td[@id='transmission']"));
    private static final CheckBox CHECKBOX_LOCATOR = new CheckBox(By.xpath("//div[@class='trim_listing__footer']//div//div[@class='checkbox']"));
    private static final Button BUTTON_LOCATOR = new Button(By.xpath("//button[@class='cui-button']"));

    public CarModificationPage() throws Exception {
        foundElementPage(UNIQUE_PAGE_MODIF_LOCATOR);
    }

    public String getEngine(){
        logger.info("Get engine first car");
        return ENGINE_LOCATOR.getText();
    }

    public String getTransmission(){
        logger.info("Get transmission first car");
        return TRANSMISSION_LOCATOR.getText();
    }

    private void compareCar (){
        logger.info("Click compare");
        CHECKBOX_LOCATOR.click();
    }

    private void setCompareNow(){
        logger.info("Click button compare now");
        BUTTON_LOCATOR.click();
    }

    public void openPageCompare(){
        compareCar();
        setCompareNow();
    }
}
