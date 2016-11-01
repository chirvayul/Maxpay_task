package BasicClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Yuliya Chyrva on 01.11.2016.
 */

public class NewUserRegistration{

    protected WebDriver driver;

    @FindBy(name = "login")
    protected WebElement email;

    @FindBy(name = "password")
    protected WebElement password;

    @FindBy(name = "confirm")
    protected WebElement confirmpassword;


    private HelpMethods helpMethods;

    public NewUserRegistration (WebDriver driver) {
        this.driver = driver;
        this.helpMethods = new HelpMethods(driver);
    }

    private void shouldWaitForPageToLoad(){
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(),'Welcome!')]")));
    }

    public void newUserCreate (String Email, String PasswordValue) throws InterruptedException {
        helpMethods.shouldWaitForElementPresence("login");
        helpMethods.clearFieldAndInputData(email, Email);
        helpMethods.clearFieldAndInputData(password, PasswordValue);
        helpMethods.clearFieldAndInputData(confirmpassword,PasswordValue);
        WebElement buttonNewAccount = driver.findElement(By.xpath("//*[contains(@type, 'submit')]"));
        buttonNewAccount.click();
        shouldWaitForPageToLoad();
    }



}
