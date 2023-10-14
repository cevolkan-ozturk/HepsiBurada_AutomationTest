import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.AddBasketPage;
import pages.SearchPage;

import java.time.Duration;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BaseTest {
    WebDriver driver;
    JavascriptExecutor js;
    WebDriverWait wait;
    SearchPage searchPage;
    AddBasketPage addBasketPage;

    @BeforeAll
    public void setUp(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriverManager.chromedriver().setup();
        // TODO - Volkan bu kısımda drive uyumsuzluk sorunu oluşursa test klasörünün altında bulunan drivers
        //  klasöründe bulunan chromedrive.exe C klasörüne kopyalanmalı yorum satırındaki kod aktif hale getirilmelidir
        //System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        driver = new ChromeDriver(options);
        driver.get("https://www.hepsiburada.com/");
        driver.manage().window().maximize();
        js = (JavascriptExecutor) driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(500));
        searchPage= new SearchPage(driver,wait);
        addBasketPage = new AddBasketPage(driver,wait);
    }

    @AfterAll
    public void tearDown() {
        driver.quit();
    }

}
