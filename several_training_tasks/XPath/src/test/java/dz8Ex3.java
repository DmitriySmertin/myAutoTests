import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class dz8Ex3 {

    private WebDriver driver;

    @Before
    public void SetUp()
    {
        System.setProperty("webdriver.chrome.driver", "//drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @After
    public void TearDown()
    {
        driver.quit();
    }

    @Test
    public void bookStore_SearchLocatorByXpath_FindedLocator()
    {
        driver.navigate().to("http://qajava.skillbox.ru/index.html");
        var firstElement = By.xpath("//a[@test-info='about-us']");
        driver.navigate().to("http://qajava.skillbox.ru/pages/bestsellers.html");
        var secondElement = By.xpath("//h1[.='Бестселлеры']");
        var thirdElement = By.xpath("//input");
        driver.navigate().to("http://qajava.skillbox.ru/checkout.html");
        var fourElement = By.xpath("//div[@id='total']");
        var fivesElement = By.xpath("//div[.='Ваш заказ: ']");
        driver.navigate().to("http://qajava.skillbox.ru/search.html");
        var sixthElement = By.xpath("//button[@class='filter-button']");

    }


}
