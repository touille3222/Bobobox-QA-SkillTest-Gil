package testcase.transactiontest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.*;

public class TransactionNegativeWithNoInputFirstNameTest {
    WebDriver driver;

    @BeforeClass
    public void setUp(){
        driver = WebDriverManager.chromedriver().create();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
    }

    @Test
    public void transactionTest(){
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        CartPage cartPage = new CartPage(driver);
        CheckoutPage checkoutPage = new CheckoutPage(driver);

        //Login
        //Assertion 1 : cek Current URL apakah sudah sesuai dengan URL Login Page
        Assert.assertEquals(loginPage.getCurrentURL(),"https://www.saucedemo.com/");

        //Assertion 2 : cek Title apakah sudah sesuai dengan Title Login Page
        Assert.assertEquals(loginPage.getTitle(),"Swag Labs");

        //Assertion 3 : cek apakah Field username, password, dan Button login telah muncul
        loginPage.usernameFieldIsDisplayed();
        loginPage.passwordFieldIsDisplayed();
        loginPage.loginButtonIsDisplayed();

        //Element action
        loginPage.inputUsername("standard_user");
        loginPage.inputPassword("secret_sauce");
        loginPage.clickLoginButton();

        //Assertion 4 : cek current URL apakah sudah berpindah halaman sehingga sesuai dengan URL Home Page
        Assert.assertEquals(homePage.getCurrentURL(),"https://www.saucedemo.com/inventory.html");

        //Assertion 5 : cek Title apakah sudah sesuai dengan Title Home Page
        Assert.assertEquals(homePage.getTitle(),"Swag Labs");

        //Assertion 6 : cek dashboard text apakah konten pada halaman Home Page sudah muncul
        Assert.assertEquals(homePage.getDashboardText(),"Products");

        //Add item ke keranjang
        //Element action
        homePage.clickAddToCartButton();

        //Assertion 7 : cek apakah jumlah item yang masuk dalam keranjang muncul
        homePage.indicatorItemsOnCartIsDisplayed();

        //Assertion 8 : cek apakah jumlah item yang masuk dalam keranjang sesuai dengan jumlah user klik Button Add to Cart
        Assert.assertEquals(homePage.getIndicatorItemsOnCart(),"1");

        //Element action
        homePage.clickCartLogo();

        //Assertion 9 : cek current URL apakah sudah berpindah halaman
        Assert.assertEquals(cartPage.getCurrentURL(),"https://www.saucedemo.com/cart.html");

        //Assertion 10 : cek Title apakah sudah sesuai dengan Title Cart Page
        Assert.assertEquals(cartPage.getTitle(),"Swag Labs");

        //Assertion 11 : cek dashboard text apakah konten pada halaman Cart Page sudah muncul
        Assert.assertEquals(cartPage.getDashboardText(),"Your Cart");

        //Assertion 12 : cek apakah barang dalam keranjang sudah sesuai
        Assert.assertEquals(cartPage.getItemName(),"Sauce Labs Backpack");

        //Assertion 13 : cek apakah harga barang sudah sesuai
        Assert.assertEquals(cartPage.getItemPrice(),"$29.99");

        //Element Action
        cartPage.clickCheckoutButton();

        //Assertion 14 : cek current URL apakah sudah berpindah halaman
        Assert.assertEquals(checkoutPage.getCurrentURL(),"https://www.saucedemo.com/checkout-step-one.html");

        //Assertion 15 : cek Title apakah sudah sesuai dengan Title Checkout Page
        Assert.assertEquals(checkoutPage.getTitle(),"Swag Labs");

        //Assertion 16 : cek dashboard text apakah konten pada halaman Checkout Page sudah muncul
        Assert.assertEquals(checkoutPage.getDashboardText(),"Checkout: Your Information");

        //Input information buyer
        //Element action
        checkoutPage.inputFirstNameField("");
        checkoutPage.inputLastNameField("Pamungkas");
        checkoutPage.inputPostalCodeField("40164");
        checkoutPage.clickContinueButton();

        //Assertion 17 : cek apakah error warning muncul
        checkoutPage.errorFieldWarningIsDisplayed();

        //Assertion 18 : cek apakah sudah teks error warning sudah sesuai
        Assert.assertEquals(checkoutPage.getErrorFieldWarningText(),"Error: First Name is required");
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
