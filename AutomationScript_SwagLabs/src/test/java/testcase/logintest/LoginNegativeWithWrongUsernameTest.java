package testcase.logintest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginNegativeWithWrongUsernameTest {
    WebDriver driver;

    @BeforeClass
    public void setUp(){
        driver = WebDriverManager.chromedriver().create();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
    }

    @Test
    public void loginTest(){
        LoginPage loginPage = new LoginPage(driver);

        //Assertion 1 : cek Current URL apakah sudah sesuai dengan URL Login Page
        Assert.assertEquals(loginPage.getCurrentURL(),"https://www.saucedemo.com/");

        //Assertion 2 : cek Title apakah sudah sesuai dengan Title Login Page
        Assert.assertEquals(loginPage.getTitle(),"Swag Labs");

        //Assertion 3 : cek apakah Field username, password, dan Button login telah muncul
        loginPage.usernameFieldIsDisplayed();
        loginPage.passwordFieldIsDisplayed();
        loginPage.loginButtonIsDisplayed();

        //Element action
        loginPage.inputUsername("wrong_user"); //diisi dengan username yang salah
        loginPage.inputPassword("secret_sauce");
        loginPage.clickLoginButton();

        //assertion 4 : cek current URL apakah URL halaman tidak berubah
        Assert.assertEquals(loginPage.getCurrentURL(),"https://www.saucedemo.com/");

        //assertion 5 : cek apakah Error Warning muncul
        loginPage.errorWarningIsDisplayed();

        //assertion 6 : cek apakah teks Error sudah sesuai ekspektasi
        Assert.assertEquals(loginPage.errorGetText(),"Epic sadface: Username and password do not match any user in this service");
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
