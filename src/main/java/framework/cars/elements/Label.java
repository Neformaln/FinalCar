package framework.cars.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by User on 23.06.2017.
 */
public class Label extends BaseElement {
    WebElement label;

    @Override
    public void click() {
        label.click();
    }

    @Override
    public void moveTo() {

    }

    @Override
    public String getAttribute(String str) {
        return null;
    }

    public Label(By by) {
        super(by);
    }

    public List<WebElement> listElements(){
        return driver.findElements(by);
    }

}
