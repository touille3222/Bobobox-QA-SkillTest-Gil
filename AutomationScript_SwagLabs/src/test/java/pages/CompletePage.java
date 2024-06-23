package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CompletePage {
    WebDriver driver;
    WebDriverWait wait;

    By dashboardText = By.xpath("//*[@data-test='title']");
    By completeContainer = By.id("checkout_complete_container");
    By backHomeButton = By.id("back-to-products");

    public CompletePage(WebDriver driver){
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

    public void completeContainerIsDisplayed(){
        driver.findElement(completeContainer).isDisplayed();
    }

    public void clickBackHomeButton(){
        driver.findElement(backHomeButton).click();
    }
}
