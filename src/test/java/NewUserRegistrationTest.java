
import BasicClasses.AccountSettingsPage;
import BasicClasses.NewUserRegistration;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by Yuliya Chyrva on 01.11.2016.
 */

public class NewUserRegistrationTest {
    private WebDriver driver;
    private String baseUrl ="https://my.maxpay.com/#/signup";
    private String textAfterSuccessLogin = "We’re glad to welcome you in MaxPay merchant portal.";

    @BeforeClass
    public void setUp() throws Exception {
        ChromeDriverManager.getInstance().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get(baseUrl);
    }

    @AfterClass
    public void tearDown() throws Exception {
        driver.close();
    }

    @Test
    public void createNewAccountAndCheckSuccessfulLoginTest() throws InterruptedException {
        String emailValue = RandomStringUtils.randomAlphabetic(10).toLowerCase()+"@"+RandomStringUtils.randomAlphabetic(3).toLowerCase()+"."
                +RandomStringUtils.randomAlphabetic(3).toLowerCase();
        System.out.println("Email is "+ emailValue);
        String passwordValue = RandomStringUtils.randomNumeric(3)+RandomStringUtils.randomAlphabetic(2).toLowerCase()
                +RandomStringUtils.randomAlphabetic(3).toUpperCase();
        System.out.println("Password is "+ passwordValue);

        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl,baseUrl);
        NewUserRegistration NewUser = PageFactory.initElements(driver, NewUserRegistration.class);

        NewUser.newUserCreate(emailValue, passwordValue);

        driver.switchTo().window(driver.getWindowHandle());

        WebElement successTextActual = driver.findElement(By.xpath("//*[contains(text(),'"+textAfterSuccessLogin+"')]"));
        Assert.assertEquals(successTextActual.getText(),textAfterSuccessLogin);

        AccountSettingsPage Settings = PageFactory.initElements(driver, AccountSettingsPage.class);
        Settings.checkUserName(emailValue);
    }



}
