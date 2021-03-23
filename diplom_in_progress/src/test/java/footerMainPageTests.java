import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class footerMainPageTests {
    private static WebDriver driver;
    private static WebDriverWait wait;
    private By allProductsLinkLocator = By.xpath("//aside[@id='pages-2']//a[@href='http://intershop5.skillbox.ru/shop/']");
    private By mainLinkLocator = By.xpath("//aside[@id='pages-2']//a[@href='http://intershop5.skillbox.ru/']");
    private By cartLinkLocator = By.xpath("//aside[@id='pages-2']//a[@href='http://intershop5.skillbox.ru/cart/']");
    private By myAccountLinkLocator = By.xpath("//aside[@id='pages-2']//a[@href='http://intershop5.skillbox.ru/my-account/']");
    private By confirmOrderLinkLocator = By.xpath("//aside[@id='pages-2']//a[@href='http://intershop5.skillbox.ru/checkout/']");
    private By registrationLinkLocator = By.xpath("//aside[@id='pages-2']//a[@href='http://intershop5.skillbox.ru/register/']");
    private By titleLocator = By.xpath("//h1[contains(@class,'entry-title')]");
    private By titleLittleLocator = By.xpath("//h2[@class='entry-title']");
    private By mainMenuLocator = By.xpath("//li[contains(@class,'menu')]/a[@href='http://intershop5.skillbox.ru/']");
    private By addCartLocator = By.xpath("(//div[@class='price-cart']//a)[1]");
    private By lightBoxTabletsLocator = By.xpath("//aside[@id='accesspress_storemo-3']");

    @BeforeClass
    public static void SetUp() {
        System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 5);
    }

    @AfterClass
    public static void TearDown() {
        driver.quit();
    }

    @Test
    public void footerMainPage_NavigationForClickLinkAllProducts_OpenPageAllProducts() {
        driver.navigate().to("http://intershop5.skillbox.ru/");
        var extendedResult = driver.findElement(allProductsLinkLocator).getAttribute("textContent");
        driver.findElement(allProductsLinkLocator).click();
        var actualResult = driver.findElement(titleLocator).getAttribute("textContent");
        Assert.assertEquals("Открылась не та страница", extendedResult, actualResult);
    }

    @Test
    public void footerMainPage_NavigationForClickLinkMain_OpenMainPage() {
        driver.navigate().to("http://intershop5.skillbox.ru/");
        var extendedResult = driver.findElement(mainLinkLocator).getAttribute("textContent");
        driver.findElement(mainLinkLocator).click();
        var actualResult = driver.findElement(mainMenuLocator).getAttribute("textContent");
        Assert.assertEquals("Открылась не та страница", extendedResult, actualResult);
    }

    @Test
    public void footerMainPage_NavigationForClickLinkCart_OpenCartPage() {
        driver.navigate().to("http://intershop5.skillbox.ru/");
        var extendedResult = driver.findElement(cartLinkLocator).getAttribute("textContent");
        driver.findElement(cartLinkLocator).click();
        var actualResult = driver.findElement(titleLittleLocator).getAttribute("textContent");
        Assert.assertEquals("Открылась не та страница", extendedResult, actualResult);
    }

    @Test
    public void footerMainPage_NavigationForClickLinkAccount_OpenAccountPage() {
        driver.navigate().to("http://intershop5.skillbox.ru/");
        var extendedResult = driver.findElement(myAccountLinkLocator).getAttribute("textContent");
        driver.findElement(myAccountLinkLocator).click();
        var actualResult = driver.findElement(titleLittleLocator).getAttribute("textContent");
        Assert.assertEquals("Открылась не та страница", extendedResult, actualResult);
    }

    @Test
    public void footerMainPage_NavigationForClickLinkCheckout_OpenCheckoutPage() {
        driver.navigate().to("http://intershop5.skillbox.ru/");
        driver.findElement(lightBoxTabletsLocator).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(addCartLocator));
        driver.findElement(addCartLocator).click();
        driver.findElement(mainMenuLocator).click();
        var extendedResult = driver.findElement(confirmOrderLinkLocator).getAttribute("textContent");
        driver.findElement(confirmOrderLinkLocator).click();
        var actualResult = driver.findElement(titleLittleLocator).getAttribute("textContent");
        Assert.assertEquals("Открылась не та страница", extendedResult, actualResult);
    }

    @Test
    public void footerMainPage_NavigationForClickLinkRegistration_OpenRegistrationPage() {
        driver.navigate().to("http://intershop5.skillbox.ru/");
        var extendedResult = driver.findElement(registrationLinkLocator).getAttribute("textContent");
        driver.findElement(registrationLinkLocator).click();
        var actualResult = driver.findElement(titleLittleLocator).getAttribute("textContent");
        Assert.assertEquals("Открылась не та страница", extendedResult, actualResult);
    }
}