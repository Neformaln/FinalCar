package framework.cars.elements;

import framework.BaseEntity;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Created by User on 22.06.2017.
 */
public abstract class BaseElement extends BaseEntity {
    public By by;

    public BaseElement() {
    }

    public abstract void click();
    public String getText(){
        return elementPage().getText();
    };
    public abstract void moveTo();
    public abstract String getAttribute(String str);

    public BaseElement(By by) {
        this.by=by;
    }

    public WebElement elementPage() {
        return driver.findElement(by);
    }

    public boolean isDisplayed(){
        return elementPage().isDisplayed();
    }

    public WebElement findElement(By locator) {
        return getDriver().findElement(locator);
    }

}
