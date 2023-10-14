import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MainTest extends BaseTest {

    @Test
    void mainTest() throws InterruptedException
    {
        // Search Step
        searchPage.openHomePageAndAcceptCookies();
        searchPage.search("İphone 13");
        searchPage.selectProduct();

        // Add Product Step
        addBasketPage.newTabFocusActive();
        addBasketPage.addToCard();

        //Go to Basket
        addBasketPage.goToBasket();

        // Open Modal
        addBasketPage.openShoppingCreditModal();

        // Warning Modal Assert
        Assertions.assertTrue(addBasketPage.isOpenShoppingCreditModal());

        // Close Warning Modal
        addBasketPage.closeShoppingCreditModal();

        // Open Modal
        addBasketPage.openCannotInstallmentCardModal();

        // Warning Modal Assert
        Assertions.assertTrue(addBasketPage.isOpenInstallCardModal());

        // Close Warning Modal
        addBasketPage.closeInstallCardModal();

        // Completed Shopping
        addBasketPage.completeShopping();

    }
}
