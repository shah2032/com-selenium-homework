package testsuite;

import browserfactory.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest  extends BaseTest {

    String baseUrl = " https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldNavigateToLoginPageSuccessfully() {
        // Find login link and click on login link
        WebElement loginLink = driver.findElement(By.linkText("Log in"));
        loginLink.click();
        String expectedMessage = "Welcome, Please Sign In!";
        WebElement actualTextElement = driver.findElement(By.xpath("//h1[contains(text(), 'Welcome, Please Sign In!')]"));
        String actualMessage = actualTextElement.getText();
        Assert.assertEquals("Not redirected to login page", expectedMessage, actualMessage);


    }
@Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {

   // find login link and click on login link
    WebElement loginLink = driver.findElement(By.linkText("Log in"));
    loginLink.click();
    // find the email field element and type email
    WebElement emailField = driver.findElement(By.id("Email"));
    emailField.sendKeys("Prime1234@gmail.com");

    // find the password field element and type the password
    driver.findElement(By.name("Password")).sendKeys("Prime123");

    //Find the Login btn Element and click
    WebElement loginBtn = driver.findElement(By.xpath("//button[contains(text(),'Log in')]"));
    loginBtn.click();
    String expectedMessage = "Log Out";
    driver.quit();
    }


    @Test
    public void verifyTheErrorMessage() {
        // Find login link and click on login link
        WebElement loginLink = driver.findElement(By.linkText("Log in"));
        loginLink.click();
        // Find username field and enter username on username field
        driver.findElement(By.id("Email")).sendKeys("prime123@gmail.com");
        // find the password field and enter password on password field
        driver.findElement(By.name("Password")).sendKeys("Prime123");
        // Find the Login button Element and click
        WebElement loginBtn = driver.findElement(By.xpath("//button [contains(text(),'Log in')]"));
        loginBtn.click();
        // String expectedMessage = "Login was successfully\n";
        //  WebElement actualTextElement = driver.findElement(By.xpath();
        //  String actualMessage = actualTextElement.getText();
        //  Assert.assertEquals("Error message not displayed", expectedMessage,actualMessage);
    }
}
