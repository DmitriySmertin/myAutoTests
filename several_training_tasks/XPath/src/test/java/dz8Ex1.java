import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class dz8Ex1 {

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
    public void findLocator_ByXpath_Finded()
    {
        driver.navigate().to("http://qa.skillbox.ru/module19/");
        var firstElement = By.xpath("//span[@class='da-arrows-prev']");
        var secondElement=By.xpath("(//a[@class='da-link button'])[3]");
        var thirdElement=By.xpath("//a[@href='#noAction']/parent::li");
        var fourElement=By.xpath("//*[starts-with(@class,'button')]");
        var fivesElement= By.xpath("//a[.='Подписаться сейчас']");
        var sixElement=By.xpath("//ul[@id='clint-slider']//img");
        var sevenElement=By.xpath("//*[.='Любительский']//parent::div/following-sibling::*");
        var eightElement =By.xpath("//*[@id='comment']//ancestor::div//input");
    }



}
