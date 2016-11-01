package BasicClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

/**
 * Created by Yuliya Chyrva on 01.11.2016.
 */
public class AccountSettingsPage {

    protected WebDriver driver;

    private HelpMethods helpMethods;

    public AccountSettingsPage (WebDriver driver) {
        this.driver = driver;
        this.helpMethods = new HelpMethods(driver);
    }

    @FindBy(name = "email")
    protected WebElement email;

    public void checkUserName (String expectedEmail) throws InterruptedException {
        driver.get("https://my.maxpay.com/app.php#/app/settings/general");
        Thread.sleep(5000);
        String emailValue = email.getAttribute("value");
        Assert.assertEquals(emailValue,expectedEmail);
    }
}
