package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LoginTest extends BaseTest {
    static String baseUrl = "https://www.saucedemo.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        //Find username filed element and enter “standard_user” username
        WebElement Username = driver.findElement(By.id("user-name"));
        Username.sendKeys("standard_user");
        //Find password filed element and enter “secret_sauce” password
        WebElement Password = driver.findElement(By.id("password"));
        Password.sendKeys("secret_sauce");
        //Find Click on button and ‘LOGIN’
        WebElement loginButtonElement = driver.findElement(By.id("login-button"));
        loginButtonElement.click();
        //Verify the text “PRODUCTS”
        String expectedMessage = "Products";
        WebElement actualTextElement = driver.findElement(By.xpath("//span[@class='title']"));
        String actualText = actualTextElement.getText();
        Assert.assertEquals("Redirected to Products", expectedMessage, actualText);
    }

    @Test
    public void verifyThatSixProductsAreDisplayedOnPage() {
        //Find username filed element and enter “standard_user” username
        WebElement Username = driver.findElement(By.id("user-name"));
        Username.sendKeys("standard_user");
        //Find password filed element and enter “secret_sauce” password
        WebElement Password = driver.findElement(By.id("password"));
        Password.sendKeys("secret_sauce");
        //Find Click on button and ‘LOGIN’
        WebElement loginButtonElement = driver.findElement(By.id("login-button"));
        loginButtonElement.click();
        //Verify that six products are displayed on page
        int expectedProducts = 6;
        //WebElement prod = driver.findElements(By.xpath("//div[@class='inventory_list']"));
        List<WebElement> prodlist = driver.findElements(By.xpath("//div[@class='inventory_item']"));
        int actualProducts = prodlist.size();
        //verify expected and actual products
        Assert.assertEquals("Not redirected to Login page",expectedProducts,actualProducts);
    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}
