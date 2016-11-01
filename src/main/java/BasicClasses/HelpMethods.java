package BasicClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Yuliya Chyrva on 01.11.2016.
 */

public class HelpMethods {

    protected WebDriver driver;

    HelpMethods(WebDriver driver) {
        this.driver = driver;
    }

    public void clearFieldAndInputData(WebElement webElement, String text) {
        webElement.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        webElement.sendKeys(Keys.DELETE);
        webElement.clear();
        webElement.sendKeys(text);
    }

    public void shouldWaitForElementPresence(String ElementName){
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.name(ElementName)));
    }

}

