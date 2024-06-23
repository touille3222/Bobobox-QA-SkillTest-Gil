package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.By.xpath;

public class HomePage {
    WebDriver driver;
    WebDriverWait wait;

    By dashboardText = By.xpath("//*[@data-test='title']");
    By addToCartButton = By.id("add-to-cart-sauce-labs-backpack");
    By addToCartSecondItemButton = By.id("add-to-cart-sauce-labs-bike-light");
    By indicatorItemsOnCart = By.xpath("//*[@data-test='shopping-cart-badge']");
    By cartLogo = By.xpath("//*[@data-test='shopping-cart-link']");
    By sortingSelect = By.xpath("//*[@data-test='product-sort-container']");
    By hightolow = xpath("//*[@value='hilo']");
    By firstItemPrice = xpath("(//*[@data-test='inventory-item-price'])[1]");
    By secondItemPrice = xpath("(//*[@data-test='inventory-item-price'])[2]");

    public HomePage(WebDriver driver) {
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

    public void clickAddToCartButton(){
        driver.findElement(addToCartButton).click();
    }

    public void clickAddToCartSecondItemButton(){
        driver.findElement(addToCartSecondItemButton).click();
    }

    public void indicatorItemsOnCartIsDisplayed(){
        driver.findElement(indicatorItemsOnCart).isDisplayed();
    }

    public String getIndicatorItemsOnCart(){
        return driver.findElement(indicatorItemsOnCart).getText();
    }

    public void clickCartLogo(){
        driver.findElement(cartLogo).click();
    }

    public void clickSortingSelect(){
        driver.findElement(sortingSelect).click();
    }

    public void clickHighToLow(){
        driver.findElement(hightolow).click();
    }

    public String getPriceFirstItem(){
        WebElement element = driver.findElement(firstItemPrice);
        String elementText = element.getText();
        String[] words = elementText.split(" ");
        StringBuilder modifiedText = new StringBuilder();

        for (String word : words) {
            if (word.length() > 1) {
                modifiedText.append(word.substring(1)).append(" ");
            } else {
                modifiedText.append(" ");
            }
        }

        return modifiedText.toString().trim();
    }

    public String getPriceSecondItem(){
        WebElement element = driver.findElement(secondItemPrice);
        String elementText = element.getText();
        String[] words = elementText.split(" ");
        StringBuilder modifiedText = new StringBuilder();

        for (String word : words) {
            if (word.length() > 1) {
                modifiedText.append(word.substring(1)).append(" ");
            } else {
                modifiedText.append(" ");
            }
        }

        return modifiedText.toString().trim();
    }
}
