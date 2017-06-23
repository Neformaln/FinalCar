package framework.cars.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

/**
 * Created by User on 23.06.2017.
 */
public class Select extends BaseElement {

    WebElement select;

    public Select(By by) {
        this.select= findElement(by);
    }

    public Select(WebElement select) {
        this.select = select;
    }


    public void click() {
        Actions action = new Actions(super.getDriver());
        action.moveToElement(select).build().perform();
        select.click();
    }

    @Override
    public String getText(){
        return select.getText();
    }

    @Override
    public boolean isDisplayed() {
        return false;
    }

    @Override
    public void moveTo() {
        Actions action = new Actions(super.getDriver());
        action.moveToElement(select).build().perform();
    }

    @Override
    public String getAttribute(String str) {
        return null;
    }


}
