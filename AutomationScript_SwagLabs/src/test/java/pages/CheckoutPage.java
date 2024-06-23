package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckoutPage {
    WebDriver driver;
    WebDriverWait wait;

    By dashboardText = By.xpath("//*[@data-test='title']");
    By firstNameField = By.id("first-name");
    By lastNameField = By.id("last-name");
    By postalCodeField = By.id("postal-code");
    By continueButton = By.id("continue");
    By errorFieldWarning = By.xpath("//*[@data-test='error']");

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public String getCurrentURL() {
        return driver.getCurrentUrl();
    }

    public String getTitle(){
        return driver.getTitle();
    }

    public String getDashboardText(){
        return driver.findElement(dashboardText).getText();
    }

    public void inputFirstNameField(String firstname) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstNameField));
        driver.findElement(firstNameField).sendKeys(firstname);
    }

    public void inputLastNameField(String lastName){
        driver.findElement(lastNameField).sendKeys(lastName);
    }

    public void inputPostalCodeField(String postalcode){
        driver.findElement(postalCodeField).sendKeys(postalcode);
    }

    public void clickContinueButton(){
        driver.findElement(continueButton).click();
    }

    public void errorFieldWarningIsDisplayed(){
        driver.findElement(errorFieldWarning).isDisplayed();
    }

    public String getErrorFieldWarningText(){
        return driver.findElement(errorFieldWarning).getText();
    }
}
