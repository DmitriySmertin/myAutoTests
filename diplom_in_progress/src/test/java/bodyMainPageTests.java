import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class bodyMainPageTests {
    private static WebDriver driver;
    private static WebDriverWait wait;
    private By lightBoxBooksLocator = By.xpath("//aside[@id='accesspress_storemo-2']");
    private By lightBoxTabletsLocator = By.xpath("//aside[@id='accesspress_storemo-3']");
    private By lightBoxPhotoLocator = By.xpath("//aside[@id='accesspress_storemo-4']");
    private By titleTextLocator = By.xpath("//div[contains(@class,'woocommerce-breadcrumb')]//span");
    private By cardSaleLocator = By.xpath("(//aside[@id='accesspress_store_product-2']//li)[6]");
    private By cardSaleTitleLocator = By.xpath("(//aside[@id='accesspress_store_product-2']//li)[6]//h3");
    private By productTitleLocator = By.xpath("//h1[contains(@class,'product_title')]");
    private By lightBoxPromoLocator = By.xpath("//section[@id='promo-section2']//div[@class='promo-desc-title']");
    private By addCartNewLocator = By.xpath("//aside[@id='accesspress_store_product-3']//a[contains(@class,'button')]");
    private By addCartSaleLocator = By.xpath("//aside[@id='accesspress_store_product-2']//a[contains(@class,'button')]");

    @BeforeClass
    public static void SetUp()
    {
        System.setProperty("webdriver.chrome.driver","drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 5);
    }
    @AfterClass
    public static void TearDown()
    {
        driver.quit();
    }

    @Test
    public void bodyMainPage_ClickToLightBoxBooks_OpenPageBooks()
    {
        driver.navigate().to("http://intershop5.skillbox.ru/");
        driver.findElement(lightBoxBooksLocator).click();
        var expectedResult = "Книги";
        var actualResult = driver.findElement(titleTextLocator).getText();
        Assert.assertEquals("Открылась не страница каталога с книгами", expectedResult, actualResult);
    }

    @Test
    public void bodyMainPage_ClickToLightBoxTablets_OpenPageTablets()
    {
        driver.navigate().to("http://intershop5.skillbox.ru/");
        driver.findElement(lightBoxTabletsLocator).click();
        var expectedResult = "Планшеты";
        var actualResult = driver.findElement(titleTextLocator).getText();
        Assert.assertEquals("Открылась не страница каталога с планшетами", expectedResult, actualResult);
    }

    @Test
    public void bodyMainPage_ClickToLightBoxPhoto_OpenPagePhoto()
    {
        driver.navigate().to("http://intershop5.skillbox.ru/");
        driver.findElement(lightBoxPhotoLocator).click();
        var expectedResult = "Фото/Видео";
        var actualResult = driver.findElement(titleTextLocator).getText();
        Assert.assertEquals("Открылась не страница каталога с фотоаппартами", expectedResult, actualResult);
    }

    @Test
    public void bodyMainPage_OpenSelectProductCard_TitleCardIdentityTitleSelectProduct()
    {
        driver.navigate().to("http://intershop5.skillbox.ru/");
        wait.until(ExpectedConditions.visibilityOfElementLocated(cardSaleLocator));
        var expectedResult = driver.findElement(cardSaleTitleLocator).getText();
        driver.findElement(cardSaleLocator).click();
        var actualResultLowCase = driver.findElement(productTitleLocator).getText();
        var actualResult = actualResultLowCase.toUpperCase();
        Assert.assertEquals("Не совпали заголовки выбранного товара на главной странице и в карточке товара",
                                    expectedResult, actualResult);
    }

    @Test
    public void bodyMainPage_ClickToPromo_OpenPromoPage()
    {
        driver.navigate().to("http://intershop5.skillbox.ru/");
        wait.until(ExpectedConditions.visibilityOfElementLocated(lightBoxPromoLocator));
        var expectedResult = driver.findElement(lightBoxPromoLocator).getAttribute("innerHTML");
        System.out.println(expectedResult);
        driver.findElement(lightBoxPromoLocator).click();
        String actualResult = driver.findElement(productTitleLocator).getText();
        String newActualResult = actualResult.substring(0, 14); // Как сделать, чтобы разбить на 3 слова, по другому??
        Assert.assertEquals("Заголовки не совпали", expectedResult, newActualResult);

    }
    @Test
    public void bodyMainPage_AddCartNewButttonText_IdentityTextAllButton()
    {
        driver.navigate().to("http://intershop5.skillbox.ru/");
        List<WebElement> newCardList = driver.findElements(addCartNewLocator);
        for (int i =0; i<newCardList.toArray().length;i++)
        {
            String rightText = "В корзину";
            var actualText = newCardList.get(i).getAttribute("text");
            Assert.assertEquals("Название кнопки не совпало", rightText,actualText);
        }
    }
    @Test
    public void bodyMainPage_AddCartSaleButtonText_IdentityTextAllButton()
    {
        driver.navigate().to("http://intershop5.skillbox.ru/");
        List<WebElement> newCardList = driver.findElements(addCartSaleLocator);
        for (int i =0; i<newCardList.toArray().length; i++)
        {
            String rightText = "В корзину";
            var actualText = newCardList.get(i).getAttribute("text");
            Assert.assertEquals("Название кнопки не совпало", rightText,actualText);
        }

    }
}
