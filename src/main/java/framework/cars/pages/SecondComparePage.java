package framework.cars.pages;

import framework.cars.elements.Button;
import framework.cars.elements.Label;
import org.openqa.selenium.By;

/**
 * Created by User on 23.06.2017.
 */
public class SecondComparePage extends BasePage {

    private Label UNIQUE_ELEMENT_PAGE = new Label(By.xpath("//div[@id='researchCompareRoot']"));
    private Button ADD_ANOTHER_CAR = new Button(By.xpath("//div[@id='icon-div']"));
    private Label SECOND_ENGINE_CAR = new Label(By.xpath("//cars-compare-compare-info[contains(@header,'Engine')]//div[@id='']//span[1]"));
    private Label FIRST_ENGINE_CAR = new Label(By.xpath("//cars-compare-compare-info[contains(@header,'Engine')]//div[@id='']//span[2]"));
    private Label SECOND_TRANSMISSION_CAR = new Label(By.xpath("//cars-compare-compare-info[contains(@header,'Transmission')]//div[@id='']/span[1]"));
    private Label FIRST_TRANSMISSION_CAR = new Label(By.xpath("//cars-compare-compare-info[contains(@header,'Transmission')]//div[@id='']/span[2]"));

    public SecondComparePage() throws Exception {
        logger.info("Create object PageForCompare");
        foundElementPage(UNIQUE_ELEMENT_PAGE);
    }

    public void addAnotherCar(){
        logger.info("Click addAnotherCar");
        ADD_ANOTHER_CAR.click();
    }

    public String getSecondCarEngine(){
        return SECOND_ENGINE_CAR.getText();
    }
    public String getFirstCarEngine(){
        return FIRST_ENGINE_CAR.getText();
    }
    public String getSecondCarTransmission(){
        return SECOND_TRANSMISSION_CAR.getText();
    }
    public String getFirstCarTransmission(){
        return FIRST_TRANSMISSION_CAR.getText();
    }
}
