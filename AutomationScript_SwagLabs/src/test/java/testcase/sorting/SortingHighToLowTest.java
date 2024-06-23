package testcase.sorting;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

//TEST CASE ID: TC_Sorting_006
public class SortingHighToLowTest {
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
        HomePage homePage = new HomePage(driver);

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

        //Element action
        homePage.clickSortingSelect();
        homePage.clickHighToLow();
        float price_first_product= Float.parseFloat(homePage.getPriceFirstItem());
        float price_second_product= Float.parseFloat(homePage.getPriceSecondItem());

        //assertion 6 : cek apakah produk pertama memiliki harga yang lebih besar daripada produk kedua sehingga sorting berhasil
        Assert.assertTrue(price_first_product>price_second_product);
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
