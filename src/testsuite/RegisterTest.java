package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RegisterTest extends BaseTest {
    String baseUrl = "https://demo.nopcommerce.com/";
    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }
    @Test
    public void UserShouldNavigateToRegisterPageSuccessfully(){
        // Find Register page and click on register link
        WebElement registerLink = driver.findElement(By.xpath("//a[text()='Register']"));
        registerLink.click();
        String expectedMessage = "Register";
        WebElement actualTextElementMessage = driver.findElement(By.xpath("//h1[text()='Register']"));
        String actualMessage = actualTextElementMessage.getText();
        Assert.assertEquals("Not redirected to register page",expectedMessage,actualMessage);


    }
    @Test
    public void userShouldRegisterAccountSuccessfully(){
        driver.findElement(By.xpath("//a[@class='ico-register']")).click();
        driver.findElement(By.id("gender-female")).click();
        driver.findElement(By.id("FirstName")).sendKeys("Lily");
        driver.findElement(By.id("LastName")).sendKeys("White");
        driver.findElement(By.name("DateOfBirthDay")).sendKeys("20");
        driver.findElement(By.name("DateOfBirthMonth")).sendKeys("July");
        driver.findElement(By.name("DateOfBirthYear")).sendKeys("1999");
        driver.findElement(By.id("Email")).sendKeys("lily1@gmail.com");
        driver.findElement(By.id("Password")).sendKeys("lily123");
        driver.findElement(By.id("ConfirmPassword")).sendKeys("lily123");
        driver.findElement(By.id("register-button")).click();
       String expectedMessage = "Your registration completed";
        WebElement actualElement = driver.findElement(By.xpath("//div[@class ='result']"));
        String actualMessage = actualElement.getText();
        Assert.assertEquals(expectedMessage,actualMessage);



    }
    @After
    public void tearDown(){
        closeBrowser();
    }
}
