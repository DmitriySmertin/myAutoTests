import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class bodyCatalogPageTests {
    private static WebDriver driver;
    private static WebDriverWait wait;

    private By buttonAddCartLocator = By.xpath("(//a[contains(@class,'add_to_cart_button')])[1]");
    private By buttonMoreInfoLocator = By.xpath("//a[contains(@class,'wc-forward')]");
    private By buttonCheckOutLocator = By.xpath("//a[contains(@class,'checkout-button')]");
    private By linkLoginLocator = By.className("showlogin");
    private By fieldUserNameLocator = By.id("username");
    private By fieldPasswordLocator = By.id("password");
    private By buttonLoginLocator = By.xpath("//button[contains(@class,'woocommerce-form-login__submit')]");
    private By fieldFirstNameLocator = By.id("billing_first_name");
    private By fieldLastNameLocator = By.id("billing_last_name");
    private By fieldAddressLocator = By.id("billing_address_1");
    private By fieldCityLocator = By.id("billing_city");
    private By fieldStateLocator = By.id("billing_state");
    private By fieldPostCodeLocator = By.id("billing_postcode");
    private By fieldPhoneLocator = By.id("billing_phone");
    private By buttonConfirmOrderLocator = By.id("place_order");
    private By lightBoxOrderInfo = By.className("content-inner");
    private By titleSectCatalogLocator = By.xpath("//h1[contains(@class,'entry-title')]");
    private By uncategorizedSectionMenuLocator = By.xpath("//a[@href='http://intershop5.skillbox.ru/product-category/uncategorized/']");
    private By appliancesSectionMenuLocator = By.xpath("//div[@id='woocommerce_product_categories-2']//a[@href='http://intershop5.skillbox.ru/product-category/catalog/appliances/']");
    private By catalogSectionMenuLocator = By.xpath("//div[@id='woocommerce_product_categories-2']//a[@href='http://intershop5.skillbox.ru/product-category/catalog/']");
    private By booksSectionMenuLocator = By.xpath("//div[@id='woocommerce_product_categories-2']//a[@href='http://intershop5.skillbox.ru/product-category/catalog/books/']");
    private By clothesSectionMenuLocator = By.xpath("//div[@id='woocommerce_product_categories-2']//a[@href='http://intershop5.skillbox.ru/product-category/catalog/clothes/']");
    private By padSectionMenuLocator = By.xpath("//div[@id='woocommerce_product_categories-2']//a[@href='http://intershop5.skillbox.ru/product-category/catalog/electronics/pad/']");
    private By washSectionMenuLocator = By.xpath("//div[@id='woocommerce_product_categories-2']//a[@href='http://intershop5.skillbox.ru/product-category/catalog/appliances/wash/']");
    private By tvSectionMenuLocator = By.xpath("//div[@id='woocommerce_product_categories-2']//a[@href='http://intershop5.skillbox.ru/product-category/catalog/electronics/tv/']");
    private By phoneSectionMenuLocator = By.xpath("//div[@id='woocommerce_product_categories-2']//a[@href='http://intershop5.skillbox.ru/product-category/catalog/electronics/phones/']");
    private By photoSectionMenuLocator = By.xpath("//div[@id='woocommerce_product_categories-2']//a[@href='http://intershop5.skillbox.ru/product-category/catalog/electronics/photo_video/']");
    private By refrigeratorSectionMenuLocator = By.xpath("//div[@id='woocommerce_product_categories-2']//a[@href='http://intershop5.skillbox.ru/product-category/catalog/appliances/refrigerators/']");
    private By watchSectionMenuLocator = By.xpath("//div[@id='woocommerce_product_categories-2']//a[@href='http://intershop5.skillbox.ru/product-category/catalog/electronics/watch/']");
    private By electronicsSectionMenuLocator = By.xpath("//div[@id='woocommerce_product_categories-2']//a[@href='http://intershop5.skillbox.ru/product-category/catalog/electronics/']");
    private By countSectionsLocator = By.xpath("//ul//span[@class='count']");
    private By emptyProductLocator = By.xpath("//p[@class='woocommerce-info']");
    private By linkSectionsLocator = By.xpath("//ul//li[contains(@class,'cat-item')]//a");

    @BeforeClass
    public static void SetUp()
    {
        System.setProperty("webdriver.chrome.driver","drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 10);
    }
    @AfterClass
    public static void TearDown()
    {
        driver.quit();
    }

    @Test
    public void bodyCatalog_positiveCaseBuyProduct_SuccessfulPurchaseOperation()
    {
        var testUsername = "test112233";
        var testPass = "112233";
        var testData = "test";
        var testAddress = "Testovaya 123";
        var testState = "Testoviy";
        var testPostCode = "444444";
        var testPhone = "+79999999999";
        Actions action = new Actions(driver);
        driver.navigate().to("http://intershop5.skillbox.ru/product-category/catalog/");
        driver.findElement(buttonAddCartLocator).click();
        driver.findElement(buttonMoreInfoLocator).click();
        driver.findElement(buttonCheckOutLocator).click();
        driver.findElement(linkLoginLocator).click();
        driver.findElement(fieldUserNameLocator).sendKeys(testUsername);
        driver.findElement(fieldPasswordLocator).sendKeys(testPass);
        driver.findElement(buttonLoginLocator).click();

        driver.findElement(fieldFirstNameLocator).clear();
        driver.findElement(fieldLastNameLocator).clear();
        driver.findElement(fieldAddressLocator).clear();
        driver.findElement(fieldCityLocator).clear();
        driver.findElement(fieldStateLocator).clear();
        driver.findElement(fieldPostCodeLocator).clear();
        driver.findElement(fieldPhoneLocator).clear();

        driver.findElement(fieldFirstNameLocator).sendKeys(testData);
        driver.findElement(fieldLastNameLocator).sendKeys(testData);
        driver.findElement(fieldAddressLocator).sendKeys(testAddress);
        driver.findElement(fieldCityLocator).sendKeys(testData);
        driver.findElement(fieldStateLocator).sendKeys(testState);
        driver.findElement(fieldPostCodeLocator).sendKeys(testPostCode);
        driver.findElement(fieldPhoneLocator).sendKeys(testPhone);
        wait.until(ExpectedConditions.elementToBeClickable(buttonConfirmOrderLocator));
        var buttonConfirm = driver.findElement(buttonConfirmOrderLocator);
        action.moveToElement(buttonConfirm).click(buttonConfirm).perform();
        wait.until(ExpectedConditions.presenceOfElementLocated(lightBoxOrderInfo));
        var boxOrderInfo = driver.findElement(lightBoxOrderInfo);
        Assert.assertTrue("Форма заказа отсутсвует на экране", boxOrderInfo.isDisplayed());
    }
    @Test
    public void bodyCatalog_ClickOnASectionWithoutCategory_OpenSectionWithoutCategory()
    {
        driver.navigate().to("http://intershop5.skillbox.ru/product-category/catalog/");
        driver.findElement(uncategorizedSectionMenuLocator).click();
        var actualResult = driver.findElement(titleSectCatalogLocator).getText();
        var expectedResult = "БЕЗ КАТЕГОРИИ";
        Assert.assertEquals("Заголовок секции не совпал с выбранным", actualResult, expectedResult);
    }

    @Test
    public void bodyCatalog_ClickOnASectionMenuAppliances_OpenSectionAppliances()
    {
        driver.navigate().to("http://intershop5.skillbox.ru/product-category/catalog/");
        driver.findElement(appliancesSectionMenuLocator).click();
        var actualResult = driver.findElement(titleSectCatalogLocator).getText();
        var expectedResult = "БЫТОВАЯ ТЕХНИКА";
        Assert.assertEquals("Заголовок секции не совпал с выбранным", actualResult, expectedResult);
    }

    @Test
    public void bodyCatalog_ClickOnASectionMenuCatalog_OpenSectionCatalog()
    {
        driver.navigate().to("http://intershop5.skillbox.ru/product-category/catalog/");
        driver.findElement(catalogSectionMenuLocator).click();
        var actualResult = driver.findElement(titleSectCatalogLocator).getText();
        var expectedResult = "КАТАЛОГ";
        Assert.assertEquals("Заголовок секции не совпал с выбранным", actualResult, expectedResult);
    }

    @Test
    public void bodyCatalog_ClickOnASectionMenuBooks_OpenSectionBooks()
    {
        driver.navigate().to("http://intershop5.skillbox.ru/product-category/catalog/");
        driver.findElement(booksSectionMenuLocator).click();
        var actualResult = driver.findElement(titleSectCatalogLocator).getText();
        var expectedResult = "КНИГИ";
        Assert.assertEquals("Заголовок секции не совпал с выбранным", actualResult, expectedResult);
    }

    @Test
    public void bodyCatalog_ClickOnASectionMenuClothes_OpenSectionClothes()
    {
        driver.navigate().to("http://intershop5.skillbox.ru/product-category/catalog/");
        driver.findElement(clothesSectionMenuLocator).click();
        var actualResult = driver.findElement(titleSectCatalogLocator).getText();
        var expectedResult = "ОДЕЖДА";
        Assert.assertEquals("Заголовок секции не совпал с выбранным", actualResult, expectedResult);
    }

    @Test
    public void bodyCatalog_ClickOnASectionMenuPad_OpenSectionPad()
    {
        driver.navigate().to("http://intershop5.skillbox.ru/product-category/catalog/");
        driver.findElement(padSectionMenuLocator).click();
        var actualResult = driver.findElement(titleSectCatalogLocator).getText();
        var expectedResult = "ПЛАНШЕТЫ";
        Assert.assertEquals("Заголовок секции не совпал с выбранным", actualResult, expectedResult);
    }

    @Test
    public void bodyCatalog_ClickOnASectionMenuWash_OpenSectionWash()
    {
        driver.navigate().to("http://intershop5.skillbox.ru/product-category/catalog/");
        driver.findElement(washSectionMenuLocator).click();
        var actualResult = driver.findElement(titleSectCatalogLocator).getText();
        var expectedResult = "СТИРАЛЬНЫЕ МАШИНЫ";
        Assert.assertEquals("Заголовок секции не совпал с выбранным", actualResult, expectedResult);
    }

    @Test
    public void bodyCatalog_ClickOnASectionMenuTv_OpenSectionTv()
    {
        driver.navigate().to("http://intershop5.skillbox.ru/product-category/catalog/");
        driver.findElement(tvSectionMenuLocator).click();
        var actualResult = driver.findElement(titleSectCatalogLocator).getText();
        var expectedResult = "ТЕЛЕВИЗОРЫ";
        Assert.assertEquals("Заголовок секции не совпал с выбранным", actualResult, expectedResult);
    }

    @Test
    public void bodyCatalog_ClickOnASectionMenuPhone_OpenSectionPhone()
    {
        driver.navigate().to("http://intershop5.skillbox.ru/product-category/catalog/");
        driver.findElement(phoneSectionMenuLocator).click();
        var actualResult = driver.findElement(titleSectCatalogLocator).getText();
        var expectedResult = "ТЕЛЕФОНЫ";
        Assert.assertEquals("Заголовок секции не совпал с выбранным", actualResult, expectedResult);
    }

    @Test
    public void bodyCatalog_ClickOnASectionMenuPhotoVideo_OpenSectionPhotoVideo()
    {
        driver.navigate().to("http://intershop5.skillbox.ru/product-category/catalog/");
        driver.findElement(photoSectionMenuLocator).click();
        var actualResult = driver.findElement(titleSectCatalogLocator).getText();
        var expectedResult = "ФОТО/ВИДЕО";
        Assert.assertEquals("Заголовок секции не совпал с выбранным", actualResult, expectedResult);
    }

    @Test
    public void bodyCatalog_ClickOnASectionMenuRefr_OpenSectionRefr()
    {
        driver.navigate().to("http://intershop5.skillbox.ru/product-category/catalog/");
        driver.findElement(refrigeratorSectionMenuLocator).click();
        var actualResult = driver.findElement(titleSectCatalogLocator).getText();
        var expectedResult = "ХОЛОДИЛЬНИКИ";
        Assert.assertEquals("Заголовок секции не совпал с выбранным", actualResult, expectedResult);
    }

    @Test
    public void bodyCatalog_ClickOnASectionMenuWatch_OpenSectionWatch()
    {
        driver.navigate().to("http://intershop5.skillbox.ru/product-category/catalog/");
        driver.findElement(watchSectionMenuLocator).click();
        var actualResult = driver.findElement(titleSectCatalogLocator).getText();
        var expectedResult = "ЧАСЫ";
        Assert.assertEquals("Заголовок секции не совпал с выбранным", actualResult, expectedResult);
    }

    @Test
    public void bodyCatalog_ClickOnASectionMenuElectronics_OpenSectionElectronic()
    {
        driver.navigate().to("http://intershop5.skillbox.ru/product-category/catalog/");
        driver.findElement(electronicsSectionMenuLocator).click();
        var actualResult = driver.findElement(titleSectCatalogLocator).getText();
        var expectedResult = "ЭЛЕКТРОНИКА";
        Assert.assertEquals("Заголовок секции не совпал с выбранным", actualResult, expectedResult);
    }


    @Test
    public void bodyCatalog_VisibilityRightCountInSection_TheNumberOfProductsIsTheSameAsTheOneSpecifiedInTheMenu()
    {
        driver.navigate().to("http://intershop5.skillbox.ru/product-category/catalog/");

        List <WebElement> sectionsList = driver.findElements(linkSectionsLocator);
        for (int i=0; i < sectionsList.toArray().length; i++)
        {
            sectionsList.get(i).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("content-inner")));

        }



    }




}
