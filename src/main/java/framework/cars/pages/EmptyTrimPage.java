package framework.cars.pages;

import framework.cars.menu.Menu;
import org.openqa.selenium.NoSuchElementException;

/**
 * Created by User on 23.06.2017.
 */
public class EmptyTrimPage  extends BasePage{
    public MainPage mainPage;
    public Header header;

    public boolean isTrimIsDisplayed(){
        boolean boo = false;
        try {
            if(CarDescriptionPage.UNIQUE_PAGE_ELEMENT.isDisplayed()){
                boo=true;
            }
        } catch (NoSuchElementException e) {
            logger.info("Trim not found");
            e.printStackTrace();
        }
        return boo;
    }

    public void whileTrimDisplayed(){
        while(!isTrimIsDisplayed()){
            try {
                header = new Header();
                header.openMainPage();
                mainPage = new MainPage();
                mainPage.menu.navigateMenu(Menu.MenuItem.READ);
                mainPage.InputRandomValue();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        logger.info("trim is displayed");
    }

}
