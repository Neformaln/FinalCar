package steps;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import framework.BaseEntity;
import framework.cars.menu.Menu;
import framework.cars.model.Car;
import framework.cars.pages.*;
import framework.utils.browsers.BrowserFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.Properties;

/**
 * Created by d.korobkin on 6/20/17.
 */
public class MyStepdefs extends BaseEntity {

    WebDriver driver;
    Car firstCar;
    Car secondCar;
    MainPage mainPage;
    CarDescriptionPage carDescriptionPage;
    CarModificationPage carModificationPage;
    CarComparisonPage carComparisonPage;
    SecondComparePage secondComparePage;
    Header header;
    EmptyTrimPage emptyTrimPage;

    @Before
    public void setUp() throws Exception {
        BasePage basePage = new BasePage();
        Properties properties = basePage.initProperties();
        String browser = properties.getProperty("browser");
        driver = BrowserFactory.getDriver(browser);
        String mainPage = properties.getProperty("main_page_url");
        basePage = new BasePage(driver);
        basePage.maximiseWindow();
        basePage.navigate(mainPage);
    }

    @Given("^User was opened main page cars$")
    public void userWasOpenedMainPageCars() throws Throwable {
        mainPage = new MainPage();
    }

    @When("^In the search, the user choose \"([^\"]*)\"$")
    public void inTheSearchTheUserChoose(String arg0) throws Throwable {
        mainPage.menu.navigateMenu(Menu.MenuItem.READ);
    }

    @Then("^\"([^\"]*)\" tab is displayed$")
    public void tabIsDisplayed(String arg0) throws Throwable {
        Assert.assertTrue(mainPage.isMakeLocator());
    }

    @When("^The user searches for randomly selected characteristics$")
    public void theUserSearchesForRandomlySelectedCharacteristics() throws Throwable {
        mainPage.InputRandomValue();
    }

    @Then("^After clicking on the Search button, a page describing the auto$")
    public void afterClickingOnTheSearchButtonAPageDescribingTheAuto() throws Throwable {
        emptyTrimPage = new EmptyTrimPage();
        emptyTrimPage.whileTrimDisplayed();
        carDescriptionPage = new CarDescriptionPage();
    }

    @When("^On the Trims tab, the user select the first available vehicle modification$")
    public void onTheTrimsTabTheUserSelectTheFirstAvailableVehicleModification() throws Throwable {
        carDescriptionPage.selectFirstModification();
    }

    @Then("^The page with the characteristics of the selected modification was opened$")
    public void thePageWithTheCharacteristicsOfTheSelectedModificationWasOpened() throws Throwable {
        carModificationPage = new CarModificationPage();
    }

    @When("^Remember 'Available Engines', 'Transmissions' for later comparison$")
    public void rememberAvailableEnginesTransmissionsForLaterComparison() throws Throwable {
        firstCar = new Car(mainPage.make, mainPage.model, mainPage.year, carModificationPage.getEngine(), carModificationPage.getTransmission());
    }

    @Then("^Features 'Available Engines', 'Transmissions'  saved$")
    public void featuresAvailableEnginesTransmissionsSaved() throws Throwable {

    }

    @When("^The user goes to the main page cars$")
    public void theUserGoesToTheMainPageCars() throws Throwable {
        header = new Header();
        header.openMainPage();
    }

    @Then("^The main page of the site is opened$")
    public void theMainPageOfTheSiteIsOpened() throws Throwable {
        mainPage = new MainPage();
    }






    @When("^In the search, the user choose \"([^\"]*)\" for second Car$")
    public void inTheSearchTheUserChooseForSecondCar(String arg0) throws Throwable {
        mainPage.menu.navigateMenu(Menu.MenuItem.READ);
    }

    @Then("^\"([^\"]*)\" tab for second Car is displayed$")
    public void tabForSecondCarIsDisplayed(String arg0) throws Throwable {
        Assert.assertTrue(mainPage.isMakeLocator());
    }

    @When("^The user searches for randomly selected characteristics for second Car$")
    public void theUserSearchesForRandomlySelectedCharacteristicsForSecondCar() throws Throwable {
        mainPage.InputRandomValue();
    }

    @Then("^After clicking on the Search button, a page describing the second auto$")
    public void afterClickingOnTheSearchButtonAPageDescribingTheSecondAuto() throws Throwable {
        emptyTrimPage = new EmptyTrimPage();
        emptyTrimPage.whileTrimDisplayed();
        carDescriptionPage = new CarDescriptionPage();
    }

    @When("^On the Trims tab, the user select the first available vehicle modification of second car$")
    public void onTheTrimsTabTheUserSelectTheFirstAvailableVehicleModificationOfSecondCar() throws Throwable {
        carDescriptionPage.selectFirstModification();
    }

    @Then("^The page with the characteristics for second car of the selected modification was opened$")
    public void thePageWithTheCharacteristicsForSecondCarOfTheSelectedModificationWasOpened() throws Throwable {
         carModificationPage = new CarModificationPage();
    }

    @When("^Remember 'Available Engines', 'Transmissions' of second car for later comparison$")
    public void rememberAvailableEnginesTransmissionsOfSecondCarForLaterComparison() throws Throwable {
        secondCar = new Car(mainPage.make, mainPage.model, mainPage.year, carModificationPage.getEngine(), carModificationPage.getTransmission());
    }

    @Then("^Features 'Available Engines', 'Transmissions'  for second car saved$")
    public void featuresAvailableEnginesTransmissionsForSecondCarSaved() throws Throwable {

    }

    @When("^In the Trims list, select the first current modification for comparison$")
    public void inTheTrimsListSelectTheFirstCurrentModificationForComparison() throws Throwable {
        carModificationPage.openPageCompare();
    }

    @Then("^Moved to the car comparison page$")
    public void movedToTheCarComparisonPage() throws Throwable {
        carComparisonPage = new CarComparisonPage();
    }

    @When("^User Selects the first car for comparison press the Add Another Car button and select the desired model$")
    public void userSelectsTheFirstCarForComparisonPressTheAddAnotherCarButtonAndSelectTheDesiredModel() throws Throwable {
        secondComparePage.addAnotherCar();
    }

    @Then("^Models have been successfully selected for comparison$")
    public void modelsHaveBeenSuccessfullySelectedForComparison() throws Throwable {
        carComparisonPage = new CarComparisonPage();
    }

    @When("^User checks the comparison page of (\\d+) models$")
    public void userChecksTheComparisonPageOfModels(int arg0) throws Throwable {
        carComparisonPage.inputSavedParameters(firstCar.make, firstCar.model, firstCar.year);
    }

    @Then("^The auto characteristics on the page correspond to those obtained in steps (\\d+)-(\\d+)$")
    public void theAutoCharacteristicsOnThePageCorrespondToThoseObtainedInSteps(int arg0, int arg1) throws Throwable {
        logger.info(secondComparePage.getFirstCarEngine());
        Assert.assertEquals(secondCar.engine, secondComparePage.getSecondCarEngine());
        logger.info(secondComparePage.getFirstCarTransmission());
        Thread.sleep(5000);
        Assert.assertEquals(secondCar.transmission, secondComparePage.getSecondCarTransmission());
        logger.info(secondComparePage.getFirstCarEngine());
        Assert.assertEquals(firstCar.engine, secondComparePage.getFirstCarEngine());
        logger.info(secondComparePage.getFirstCarTransmission());
        Assert.assertEquals(firstCar.transmission, secondComparePage.getFirstCarTransmission());
    }
}