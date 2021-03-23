import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;


public class headerMainPageTests {
    private static WebDriver driver;
    private By cataloqLocator = By.xpath("//a[@href='http://intershop5.skillbox.ru/product-category/catalog/']");
    private By cataloqTextLocator = By.xpath("//div[contains(@class,'woocommerce-breadcrumb')]//span");
    private By myAccountLocator = By.xpath("//a[@href='http://intershop5.skillbox.ru/my-account/']");
    private By myAccountTextLocator = By.xpath("//span[@class='current']");
    private By cartLocator = By.xpath("//a[@href='http://intershop5.skillbox.ru/cart/']");
    private By cartFieldLocator = By.xpath("//p[contains(@class,'cart-empty')]");
    private By confirmOrderLocator = By.xpath("//a[@href='http://intershop5.skillbox.ru/checkout/']");
    private By loginLinkLocator = By.xpath("//a[@class='account']");
    private By lightBoxAuthorizationLocator = By.xpath("//div[contains(@class,'content-inner')]");
    private By searchFieldLocator = By.xpath("//input[@class='search-field']");
    private By buttonLocator = By.xpath("//button[@class='searchsubmit']");
    private By titleResultSearchLocator = By.xpath("//h1[contains(@class,'ak-container')]");



    @BeforeClass
    public static void SetUp()
    {
        System.setProperty("webdriver.chrome.driver","drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @AfterClass
    public static void TearDown()
    {
        driver.quit();
    }

    @Test
    public void headerMainPage_NavClickToCataloq_openCataloqPage()
    {
    driver.navigate().to("http://intershop5.skillbox.ru/");
    driver.findElement(cataloqLocator).click();
    var actualResult = driver.findElement(cataloqTextLocator).getText();
    var expectedResult = "Каталог";
    Assert.assertEquals("После перехода, текст заголовка не совпал", expectedResult, actualResult);
    }

    @Test
    public void headerMainPage_NavClickToMyAccount_openMyAccountPage()
    {
        driver.navigate().to("http://intershop5.skillbox.ru/");
        driver.findElement(myAccountLocator).click();
        var actualResult = driver.findElement(myAccountTextLocator).getText();
        var expectedResult = "Мой Аккаунт";
        Assert.assertEquals("После перехода, текст заголовка не совпал", expectedResult, actualResult);
    }

    @Test
    public void headerMainPage_NavClickToCart_FieldCartIsVisible()
    {
        driver.navigate().to("http://intershop5.skillbox.ru/");
        driver.findElement(cartLocator).click();
        Assert.assertTrue("Поле корзины не появилось на экране", driver.findElement(cartFieldLocator).isDisplayed());
    }

    @Test
    public void headerMainPage_NavClickToConfirmOrder_FieldCartIsVisible()
    {
        driver.navigate().to("http://intershop5.skillbox.ru/");
        driver.findElement(confirmOrderLocator).click();
        Assert.assertTrue("Поле корзины не появилось на экране", driver.findElement(cartFieldLocator).isDisplayed());
    }

    @Test
    public void headerMainPage_ClickForLogin_FormAuthorizationIsDisplayed()
    {
        driver.navigate().to("http://intershop5.skillbox.ru/");
        driver.findElement(loginLinkLocator).click();
        Assert.assertTrue("Не отобразилось окно авторизации", driver.findElement(lightBoxAuthorizationLocator).isDisplayed());
    }

    @Test
    public void searchInputField_EmptySearch_Exeption() {
        driver.navigate().to("http://intershop5.skillbox.ru/");
        driver.findElement(buttonLocator).click();
        Assert.assertFalse("Результат поиска не должен появляться, должна появляться ошибка, поле для поиска не заполнено",
                driver.findElement(titleResultSearchLocator).isDisplayed());
    }

    @Test
    public void searchInputField_InputEuroSpecCharHierogText_Exeption() {
        var testData = "äöüÄÖÜß中国的®©£¥¢¦§«»€";
        driver.navigate().to("http://intershop5.skillbox.ru/");
        driver.findElement(searchFieldLocator).sendKeys(testData);
        driver.findElement(buttonLocator).click();
        Assert.assertFalse("Результат поиска не должен появляться, должна появляться ошибка, введены некорректные данные",
                driver.findElement(titleResultSearchLocator).isDisplayed());
    }

    @Test
    public void searchInputField_InputLongText_Exeption() {
        var testData = "test123456test123456test123456test123456test123456test123456test123456test123456test123456test123456test123456test123456test123456test123456test123456test123456test123456test123456test123456test123456test123456test123456test123456test123456test123456test123456test123456test123456test123456test123456test123456test123456test123456test123456test123456test123456test123456test123456test123456test123456";
        driver.navigate().to("http://intershop5.skillbox.ru/");
        driver.findElement(searchFieldLocator).sendKeys(testData);
        driver.findElement(buttonLocator).click();
        Assert.assertFalse("Результат поиска не должен появляться, должна появляться ошибка, введены некорректные данные",
                driver.findElement(titleResultSearchLocator).isDisplayed());
    }

}
