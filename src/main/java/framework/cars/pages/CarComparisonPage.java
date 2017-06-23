package framework.cars.pages;

import framework.cars.elements.Button;
import framework.cars.elements.ComboBox;
import framework.cars.elements.Label;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by User on 22.06.2017.
 */
public class CarComparisonPage extends BasePage {
    private static final Label ADD_CAR_LOCATOR = new Label(By.xpath("//div[@id='icon-div']"));
    private static final ComboBox MAKE_LOCATOR = new ComboBox(By.xpath("//select[@name='makeDropdown']"));
    private static final Label VALUE_MAKE_LOCATOR = new Label(By.xpath("//select[@name='makeDropdown']/option"));
    private static final ComboBox MODEL_LOCATOR = new ComboBox(By.xpath("//select[@name='modelDropdown']"));
    private static final Label VALUE_MODEL_LOCATOR = new Label(By.xpath("//select[@name='modelDropdown']/option"));
    private static final ComboBox YEAR_LOCATOR = new ComboBox(By.xpath("//select[@name='yearDropdown']"));
    private static final Label VALUE_YEAR_LOCATOR = new Label(By.xpath("//select[@name='yearDropdown']/option"));
    private static final Button BUTTON_LOCATOR = new Button(By.xpath("//button[@class='modal-button']"));

    private Label labelAddCar;

    public CarComparisonPage() {
    }

    public void clickToAddAnotherCar() {
        logger.info("Initializing locator and click on Label Add another Car");
        ADD_CAR_LOCATOR.click();
    }

    public void inputSavedMake(String arg) {
        MAKE_LOCATOR.click();
        List<WebElement> listMake = VALUE_MAKE_LOCATOR.listElements();
        for (WebElement w : listMake) {
            logger.info(w.getText());
            if (w.getText().equals(arg)) {
                logger.info("First car was " + w.getText());
                w.click();
                break;
            }
        }
    }

    public void inputSavedModel(String arg) {
        MODEL_LOCATOR.click();
        List<WebElement> listModel = VALUE_MODEL_LOCATOR.listElements();
        for (WebElement w : listModel) {
            if (w.getText().equals(arg)) {
                logger.info("First model was " + w.getText());
                w.click();
                break;
            }
        }
    }

    public void inpitSavedYear(String arg){
        YEAR_LOCATOR.click();
        List<WebElement> listYear = VALUE_YEAR_LOCATOR.listElements();
        for(WebElement w:listYear) {
            if (w.getText().equals(arg)) {
                logger.info("First model was " + w.getText());
                w.click();
                break;
            }
        }
    }

    public void inputSavedParameters(String make, String model, String year) {
        inputSavedMake(make);
        inputSavedModel(model);
        inpitSavedYear(year);
        BUTTON_LOCATOR.click();
    }
}
