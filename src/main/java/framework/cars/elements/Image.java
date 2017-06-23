package framework.cars.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Created by User on 23.06.2017.
 */
public class Image extends BaseElement {
    WebElement image;

    public Image(WebElement image) {
        this.image = image;
    }

    public Image(By by){
        this.image = findElement(by);
    }

    @Override
    public void click() {
        image.click();
    }

    @Override
    public String getText() {
        return null;
    }

    @Override
    public void moveTo() {

    }

    @Override
    public String getAttribute(String str) {
        return null;
    }
}
