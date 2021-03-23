import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class dz8Ex2 {
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
    public void onlineInstitute_FindElementsByXpath_FindedElements()
    {
        driver.navigate().to("http://qa.skillbox.ru/module16/maincatalog/");
        var firstElement = By.xpath("(//*[@class='baseCard__title'])[5]");
        var secondElement=By.xpath("(//*[@class='baseCard__wrapper'])[last()]");
        var thirdElement=By.xpath("//*[@href='#']//parent::div");
        var fourElement=By.xpath("(//*[@href='#']//parent::div)[5]");
        var fivesElement=By.xpath("//div[@class='pageCreate__title']//parent::*");

    }
}