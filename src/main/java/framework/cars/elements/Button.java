package framework.cars.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

/**
 * Created by User on 22.06.2017.
 */
public class Button extends BaseElement {
    WebElement button;

    @Override
    public void click() {
        elementPage().click();
    }

    @Override
    public String getText() {
        return null;
    }

    @Override
    public void moveTo() {
        Actions actions = new Actions(super.getDriver());
        actions.moveToElement(button).build().perform();
    }

    @Override
    public String getAttribute(String str) {
        return null;
    }

    public Button(By by) {
        super(by);
    }

    public void submit(){
        button.submit();
    }
}
