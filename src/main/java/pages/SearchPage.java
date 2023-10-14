package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchPage extends BasePage {

    By searchBoxLocator = By.cssSelector(".searchBoxOld-M1esqHPyWSuRUjMCALPK");
    By searchBoxInputLocator = By.cssSelector(".theme-IYtZzqYPto8PhOx3ku3c");
    By firstProductLocator = By.xpath("//*[@id='i0']/div/a");

    private static final String homepageUrl = "https://www.hepsiburada.com/";
    private static final String acceptCookiesButtonId = "onetrust-accept-btn-handler";

    public SearchPage(WebDriver driver, WebDriverWait wait) {
        super(driver,wait);
    }

    public void search(String text) throws InterruptedException {
        click(searchBoxLocator);
        Thread.sleep(1000);
        type(searchBoxInputLocator,text);
        Thread.sleep(1000);
        type(searchBoxInputLocator, String.valueOf(Keys.ENTER));
    }

    public void openHomePageAndAcceptCookies() {
        // Step # | name | target | value
        // 1 | open | / |
        driver.get(homepageUrl);
        // 2 | accept cookies
        waitUntilPageContainElements(By.id(acceptCookiesButtonId));
        click(By.id(acceptCookiesButtonId));
    }

    public void selectProduct() throws InterruptedException {
        Thread.sleep(500);
        click(firstProductLocator);
    }

}
