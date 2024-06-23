package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.StringReader;
import java.time.Duration;

public class OverviewPage {
    WebDriver driver;
    WebDriverWait wait;

    By dashboardText = By.xpath("//*[@data-test='title']");
    By itemName = By.xpath("(//*[@data-test='inventory-item-name'])[1]");
    By itemSecondName = By.xpath("(//*[@data-test='inventory-item-name'])[2]");
    By itemsTotalPriceBeforeTax = By.xpath("//*[@data-test='subtotal-label']");
    By tax = By.xpath("//*[@data-test='tax-label']");
    By itemsTotalPriceAfterTax = By.xpath("//*[@data-test='total-label']");
    By finishButton = By.id("finish");

    public OverviewPage(WebDriver driver){
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
        wait.until(ExpectedConditions.visibilityOfElementLocated(dashboardText));
        return driver.findElement(dashboardText).getText();
    }

    public String getItemName(){
        return driver.findElement(itemName).getText();
    }

    public String getItemSecondName(){
        return driver.findElement(itemSecondName).getText();
    }

    public String getItemsTotalPriceBeforeTax(){
        String text = driver.findElement(itemsTotalPriceBeforeTax).getText();

        return text.replaceAll("[^\\d.]", "");
    }

    public String getTax(){
        String text = driver.findElement(tax).getText();

        return text.replaceAll("[^\\d.]", "");
    }

    public String getItemsTotalPriceAfterTax(){
        String text = driver.findElement(itemsTotalPriceAfterTax).getText();

        return text.replaceAll("[^\\d.]", "");
    }

    public void clickFinishButton(){
        driver.findElement(finishButton).click();
    }
}
