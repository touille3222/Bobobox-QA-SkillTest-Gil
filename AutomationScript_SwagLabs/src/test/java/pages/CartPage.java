package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage {
    WebDriver driver;
    WebDriverWait wait;

    By dashboardText = By.xpath("//*[@data-test='title']");
    By itemName = By.xpath("(//*[@data-test='inventory-item-name'])[1]");
    By itemSecondName = By.xpath("(//*[@data-test='inventory-item-name'])[2]");
    By itemPrice = By.xpath("(//*[@data-test='inventory-item-price'])[1]");
    By itemSecondPrice = By.xpath("(//*[@data-test='inventory-item-price'])[2]");
    By checkoutButton = By.id("checkout");

    public CartPage(WebDriver driver) {
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

    public String getItemName(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(itemName));
        return driver.findElement(itemName).getText();
    }

    public String getItemSecondName(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(itemName));
        return driver.findElement(itemSecondName).getText();
    }

    public String getItemPrice(){
        return driver.findElement(itemPrice).getText();
    }

    public String getItemSecondPrice(){
        return driver.findElement(itemSecondPrice).getText();
    }

    public void clickCheckoutButton(){
        driver.findElement(checkoutButton).click();
    }
}
