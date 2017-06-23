package framework.cars.pages;

import framework.cars.elements.Button;
import framework.cars.elements.Label;
import framework.cars.menu.Menu;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by User on 22.06.2017.
 */
public class MainPage extends BasePage {
    private static final Label UNIQUE_MAIN_PAGE_LOCATOR = new Label(By.xpath("//div[contains(@class,'superwidget')]"));
    private static final Label MAKE_LOCATOR = new Label(By.xpath("//div[@class='input-group-xl']//select[@ng-model='selections.make']"));
    private static final Label VALUE_MAKE_LOCATOR = new Label(By.xpath("//div[@class='input-group-xl']//select[@ng-model='selections.make']/option"));
    private static final Label VALUE_MODEL_LOCATOR = new Label(By.xpath("//div[@class='input-group-xl']//select[@ng-model='selections.model']/option"));
    private static final Label VALUE_YEAR_LOCATOR = new Label(By.xpath("//div[@class='input-group-xl']//select[@ng-model='selections.year']/option"));
    private static final Button SEARCH_LOCATOR = new Button(By.xpath("//input[@data-linkname='Research']"));
    public String make;
    public String model;
    public String year;


    public Menu menu = new Menu();

    public MainPage() throws Exception {
        logger.info("create main page");
        Thread.sleep(5000);
        foundElementPage(UNIQUE_MAIN_PAGE_LOCATOR);
    }

    public boolean isMakeLocator(){
        return MAKE_LOCATOR.isDisplayed();
    }

    public void selectMake(){
        List<WebElement> listMake = VALUE_MAKE_LOCATOR.listElements();
        int index = (int)(Math.random()*listMake.size());
        make = listMake.get(index).getText();
        listMake.get(index).click();
    }

    public void selectModel(){
        List<WebElement> listMake = VALUE_MODEL_LOCATOR.listElements();
        int index = (int)(Math.random()*listMake.size());
        model = listMake.get(index).getText();
        listMake.get(index).click();
    }

    public void selectYear(){
        List<WebElement> listMake = VALUE_YEAR_LOCATOR.listElements();
        int index = (int)(Math.random()*listMake.size());
        year = listMake.get(index).getText();
        listMake.get(index).click();
    }

    public void pushSearchButton(){
        SEARCH_LOCATOR.click();
    }

    public void InputRandomValue() {
        selectMake();
        selectModel();
        selectYear();
        pushSearchButton();
    }
}
