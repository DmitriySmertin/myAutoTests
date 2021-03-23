import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class footerCataloqPageTests {
    private static WebDriver driver;
    private static WebDriverWait wait;

    private By navCatalogLocator = By.xpath("//a[@aria-current='page']");
    private By navCatSectApplLocator = By.xpath("//li[@id]//a[@href='http://intershop5.skillbox.ru/product-category/catalog/appliances/']");
    private By titleSectCatalogLocator = By.xpath("//h1[contains(@class,'entry-title')]");
    private By navApplSectWashMachLocator = By.xpath("//li[@id]//a[@href='http://intershop5.skillbox.ru/product-category/catalog/appliances/wash/']");
    private By navApplSectRefrLocator = By.xpath("//li[@id]//a[@href='http://intershop5.skillbox.ru/product-category/catalog/appliances/refrigerators/']");
    private By navCatSectElectrLocator = By.xpath("//li[contains(@class,'menu-item-object-product_cat')]//a[@href='http://intershop5.skillbox.ru/product-category/catalog/electronics/']");
    private By navElectrSectPhoneLocator = By.xpath("//li[contains(@class,'menu-item-object-product_cat')]//a[@href='http://intershop5.skillbox.ru/product-category/catalog/electronics/phones/']");
    private By navElectrSectPadsLocator = By.xpath("//li[contains(@class,'menu-item-object-product_cat')]//a[@href='http://intershop5.skillbox.ru/product-category/catalog/electronics/pad/']");
    private By navElectrSectTvLocator = By.xpath("//li[contains(@class,'menu-item-object-product_cat')]//a[@href='http://intershop5.skillbox.ru/product-category/catalog/electronics/tv/']");
    private By navElectrSectPhotoVideoLocator = By.xpath("//li[contains(@class,'menu-item-object-product_cat')]//a[@href='http://intershop5.skillbox.ru/product-category/catalog/electronics/photo_video/']");
    private By navElectrSectWatchLocator = By.xpath("//li[contains(@class,'menu-item-object-product_cat')]//a[@href='http://intershop5.skillbox.ru/product-category/catalog/electronics/watch/']");
    private By navCatSectBooksLocator = By.xpath("//li[contains(@class,'menu-item-object-product_cat')]//a[@href='http://intershop5.skillbox.ru/product-category/catalog/books/']");
    private By navCatSectClothesLocator = By.xpath("//li[contains(@class,'menu-item-object-product_cat')]//a[@href='http://intershop5.skillbox.ru/product-category/catalog/clothes/']");
    private By searchInputFieldLocator = By.className("search-field");
    private By searchInputButtonLocator = By.className("searchsubmit");
    private By washMashSearchElementsLocator = By.xpath("//ul//li[contains(@class,'product_cat-wash')]//h3");

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
    public void footerCatalog_ClickToCatalogSectionAppliances_OpenSectionAppliances()
    {
        driver.navigate().to("http://intershop5.skillbox.ru/product-category/catalog/");
        Actions action = new Actions(driver);
        var navCatalog = driver.findElement(navCatalogLocator);
        var navCatalogAppl = driver.findElement(navCatSectApplLocator);
        action.moveToElement(navCatalog).moveToElement(navCatalogAppl).click(navCatalogAppl).perform();
        var actualResult = driver.findElement(titleSectCatalogLocator).getText();
        var expectedResult = "БЫТОВАЯ ТЕХНИКА";
        Assert.assertEquals("Заголовок не совпал с выбранным пунктом каталога", actualResult, expectedResult);
    }

    @Test
    public void footerCatalog_ClickToAppliancesSectionWashMach_OpenSectionWasMach()
    {
        driver.navigate().to("http://intershop5.skillbox.ru/product-category/catalog/");
        Actions action = new Actions(driver);
        var navCatalog = driver.findElement(navCatalogLocator);
        var navCatalogAppl = driver.findElement(navCatSectApplLocator);
        var navWashMach = driver.findElement(navApplSectWashMachLocator);
        action.moveToElement(navCatalog).moveToElement(navCatalogAppl).moveToElement(navWashMach).click(navWashMach).perform();
        var actualResult = driver.findElement(titleSectCatalogLocator).getText();
        var expectedResult = "СТИРАЛЬНЫЕ МАШИНЫ";
        Assert.assertEquals("Заголовок не совпал с выбранным пунктом каталога", actualResult, expectedResult);
    }

    @Test
    public void footerCatalog_ClickToAppliancesSectionRefr_OpenSectionRefr()
    {
        driver.navigate().to("http://intershop5.skillbox.ru/product-category/catalog/");
        Actions action = new Actions(driver);
        var navCatalog = driver.findElement(navCatalogLocator);
        var navCatalogAppl = driver.findElement(navCatSectApplLocator);
        var navRefr = driver.findElement(navApplSectRefrLocator);
        action.moveToElement(navCatalog).moveToElement(navCatalogAppl).moveToElement(navRefr).click(navRefr).perform();
        var actualResult = driver.findElement(titleSectCatalogLocator).getText();
        var expectedResult = "ХОЛОДИЛЬНИКИ";
        Assert.assertEquals("Заголовок не совпал с выбранным пунктом каталога", actualResult, expectedResult);
    }

    @Test
    public void footerCatalog_ClickToCatalogSectionElectronics_OpenSectionElectronics()
    {
        driver.navigate().to("http://intershop5.skillbox.ru/product-category/catalog/");
        Actions action = new Actions(driver);
        var navCatalog = driver.findElement(navCatalogLocator);
        var navElectronics = driver.findElement(navCatSectElectrLocator);
        action.moveToElement(navCatalog).moveToElement(navElectronics).click(navElectronics).perform();
        var actualResult = driver.findElement(titleSectCatalogLocator).getText();
        var expectedResult = "ЭЛЕКТРОНИКА";
        Assert.assertEquals("Заголовок не совпал с выбранным пунктом каталога", actualResult, expectedResult);
    }

    @Test
    public void footerCatalog_ClickToElectronicsSectionPhone_OpenSectionPhone()
    {
        driver.navigate().to("http://intershop5.skillbox.ru/product-category/catalog/");
        Actions action = new Actions(driver);
        var navCatalog = driver.findElement(navCatalogLocator);
        var navElectronics = driver.findElement(navCatSectElectrLocator);
        var navPhone = driver.findElement(navElectrSectPhoneLocator);
        action.moveToElement(navCatalog).moveToElement(navElectronics).moveToElement(navPhone).click(navPhone).perform();
        var actualResult = driver.findElement(titleSectCatalogLocator).getText();
        var expectedResult = "ТЕЛЕФОНЫ";
        Assert.assertEquals("Заголовок не совпал с выбранным пунктом каталога", actualResult, expectedResult);
    }

    @Test
    public void footerCatalog_ClickToElectronicsSectionPad_OpenSectionPad()
    {
        driver.navigate().to("http://intershop5.skillbox.ru/product-category/catalog/");
        Actions action = new Actions(driver);
        var navCatalog = driver.findElement(navCatalogLocator);
        var navElectronics = driver.findElement(navCatSectElectrLocator);
        var navPad = driver.findElement(navElectrSectPadsLocator);
        action.moveToElement(navCatalog).moveToElement(navElectronics).moveToElement(navPad).click(navPad).perform();
        var actualResult = driver.findElement(titleSectCatalogLocator).getText();
        var expectedResult = "ПЛАНШЕТЫ";
        Assert.assertEquals("Заголовок не совпал с выбранным пунктом каталога", actualResult, expectedResult);
    }

    @Test
    public void footerCatalog_ClickToElectronicsSectionTv_OpenSectionTv()
    {
        driver.navigate().to("http://intershop5.skillbox.ru/product-category/catalog/");
        Actions action = new Actions(driver);
        var navCatalog = driver.findElement(navCatalogLocator);
        var navElectronics = driver.findElement(navCatSectElectrLocator);
        var navTv = driver.findElement(navElectrSectTvLocator);
        action.moveToElement(navCatalog).moveToElement(navElectronics).moveToElement(navTv).click(navTv).perform();
        var actualResult = driver.findElement(titleSectCatalogLocator).getText();
        var expectedResult = "ТЕЛЕВИЗОРЫ";
        Assert.assertEquals("Заголовок не совпал с выбранным пунктом каталога", actualResult, expectedResult);
    }

    @Test
    public void footerCatalog_ClickToElectronicsSectionPhotoVideo_OpenSectionPhotoVideo()
    {
        driver.navigate().to("http://intershop5.skillbox.ru/product-category/catalog/");
        Actions action = new Actions(driver);
        var navCatalog = driver.findElement(navCatalogLocator);
        var navElectronics = driver.findElement(navCatSectElectrLocator);
        var navPhotoVideo = driver.findElement(navElectrSectPhotoVideoLocator);
        action.moveToElement(navCatalog).moveToElement(navElectronics).moveToElement(navPhotoVideo).click(navPhotoVideo).perform();
        var actualResult = driver.findElement(titleSectCatalogLocator).getText();
        var expectedResult = "ФОТО/ВИДЕО";
        Assert.assertEquals("Заголовок не совпал с выбранным пунктом каталога", actualResult, expectedResult);
    }

    @Test
    public void footerCatalog_ClickToElectronicsSectionWatch_OpenSectionPhotoWatch()
    {
        driver.navigate().to("http://intershop5.skillbox.ru/product-category/catalog/");
        Actions action = new Actions(driver);
        var navCatalog = driver.findElement(navCatalogLocator);
        var navElectronics = driver.findElement(navCatSectElectrLocator);
        var navWatch = driver.findElement(navElectrSectWatchLocator);
        action.moveToElement(navCatalog).moveToElement(navElectronics).moveToElement(navWatch).click(navWatch).perform();
        var actualResult = driver.findElement(titleSectCatalogLocator).getText();
        var expectedResult = "ЧАСЫ";
        Assert.assertEquals("Заголовок не совпал с выбранным пунктом каталога", actualResult, expectedResult);
    }

    @Test
    public void footerCatalog_ClickToBooks_OpenSectionBooks()
    {
        driver.navigate().to("http://intershop5.skillbox.ru/product-category/catalog/");
        Actions action = new Actions(driver);
        var navCatalog = driver.findElement(navCatalogLocator);
        var navBooks = driver.findElement(navCatSectBooksLocator);
        action.moveToElement(navCatalog).moveToElement(navBooks).click(navBooks).perform();
        var actualResult = driver.findElement(titleSectCatalogLocator).getText();
        var expectedResult = "КНИГИ";
        Assert.assertEquals("Заголовок не совпал с выбранным пунктом каталога", actualResult, expectedResult);
    }

    @Test
    public void footerCatalog_ClickToClothes_OpenSectionClothes() {
        driver.navigate().to("http://intershop5.skillbox.ru/product-category/catalog/");
        Actions action = new Actions(driver);
        var navCatalog = driver.findElement(navCatalogLocator);
        var navClothes = driver.findElement(navCatSectClothesLocator);
        action.moveToElement(navCatalog).moveToElement(navClothes).click(navClothes).perform();
        var actualResult = driver.findElement(titleSectCatalogLocator).getText();
        var expectedResult = "ОДЕЖДА";
        Assert.assertEquals("Заголовок не совпал с выбранным пунктом каталога", actualResult, expectedResult);
    }

    @Test
    public void footerCatalog_SearchInputField_OpenSearchTask()
    {
        driver.navigate().to("http://intershop5.skillbox.ru/product-category/catalog/");
        var testData = "Стиральная машина";
        driver.findElement(searchInputFieldLocator).sendKeys(testData);
        driver.findElement(searchInputButtonLocator).click();
        var actualTitleResult = driver.findElement(titleSectCatalogLocator).getText();
        var expectedTitleResult = "РЕЗУЛЬТАТЫ ПОИСКА: “СТИРАЛЬНАЯ МАШИНА”";
        Assert.assertEquals("Поисковый запрос не совпал с названием заголовка результата поиска", expectedTitleResult, actualTitleResult);
        List<WebElement> washMachList = driver.findElements(washMashSearchElementsLocator);
        for (int i=0; i< washMachList.toArray().length; i++)
            {
                var tempActualSectName = washMachList.get(i).getText();
                var actualSectionName = tempActualSectName.substring(0, 17);
                Assert.assertEquals("В списке результата поиска элемент не входящий в запрос поиска",
                        actualSectionName, testData);
            }
    }

}