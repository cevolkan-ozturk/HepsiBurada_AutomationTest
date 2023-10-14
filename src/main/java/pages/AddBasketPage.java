package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class AddBasketPage extends BasePage {

    By productNameLocator = new By.ByClassName("product_name_2Klj3");
    By addToCardButton = By.id("addToCart");
    By gotoBasketButton = By.xpath("//div[@class='checkoutui-ProductOnBasketHeader-zdTSacusLu4Cu0LDpmnB']//button[1]");

    By shoppingCreditInfoButton = By.xpath("//div[@class='product_info_labels_3AEiL']//div[2]");
    By cannotInstallmentCardModal = By.xpath("//div[@class='product_labels_1sYMC '][2]");
    By displayShoppingCreditModal = By.className("modal_product_info_fgcWz");
    By closeButtonCannotInstallmentCardModal = By.className("close_2kUgV");

    By completeShoppingButton = By.id("continue_step_btn");

    JavascriptExecutor js;

    public AddBasketPage(WebDriver driver, WebDriverWait wait) {
        super(driver,wait);
        js = (JavascriptExecutor) driver;
    }

    public boolean checkIfProductAdded() {
        return getProducts().size() > 0;

    }

    private List<WebElement> getProducts() {
        return findAll(productNameLocator);
    }

    public void addToCard() throws InterruptedException {
        Thread.sleep(500);
        js.executeScript("window.scrollTo(0,104)");
        {
            WebElement element = driver.findElement(By.id("addToCart"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element).perform();
        }
        click(addToCardButton);
        Thread.sleep(4000);
    }

    public void newTabFocusActive()
    {
        ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs.get(tabs.size()-1));
    }

    public void goToBasket() throws InterruptedException {
        Thread.sleep(4000);
        click(gotoBasketButton);
        Thread.sleep(500);
    }

    public void openShoppingCreditModal() throws InterruptedException {
        Thread.sleep(1000);
        click(shoppingCreditInfoButton);
        Thread.sleep(500);
    }

    public Boolean isOpenShoppingCreditModal()
    {
        return isDisplayed(displayShoppingCreditModal);
    }
    public void openCannotInstallmentCardModal() throws InterruptedException {
        Thread.sleep(1000);
        click(cannotInstallmentCardModal);
        Thread.sleep(500);
    }

    public Boolean isOpenInstallCardModal()
    {
        return isDisplayed(cannotInstallmentCardModal);
    }

    public void closeShoppingCreditModal() throws InterruptedException {
        Thread.sleep(1000);
        click(closeButtonCannotInstallmentCardModal);
        Thread.sleep(1000);
    }

    public void closeInstallCardModal() throws InterruptedException {
        Thread.sleep(1000);
        click(closeButtonCannotInstallmentCardModal);
        Thread.sleep(1000);
    }

    public void completeShopping() throws InterruptedException {
        Thread.sleep(3000);
        click(completeShoppingButton);
        Thread.sleep(5000);
    }


}
