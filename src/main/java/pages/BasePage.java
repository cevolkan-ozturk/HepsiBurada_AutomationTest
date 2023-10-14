package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BasePage {

    WebDriver driver;
    WebDriverWait wait;

    public BasePage (WebDriver driver, WebDriverWait wait)
    {
        this.driver = driver;
        this.wait= wait;
    }

    public WebElement find(By locator) {
        return driver.findElement(locator);

    }

    public List<WebElement> findAll(By locator) {
        return driver.findElements(locator);

    }

    public void click(By locator){

        find(locator).click();
    }


    public void type(By locator, String text ) {

        find(locator).sendKeys(text);
    }

    public boolean isDisplayed(By locator){
        return
                find(locator).isDisplayed();
    }

    public void waitUntilPageContainElements(By locator)
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator)); //waits until specified element is loaded
    }

}
