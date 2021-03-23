import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class dz3Ex3 {
    private WebDriver driver;

    @Before
    public void SetUp()
    {
        System.setProperty("webdriver.chrome.driver", "drivers//chromedriver.exe");
        driver = new ChromeDriver();
    }
    @After
    public void TearDown()
    {
        driver.close();
    }

    @Test
    public void testCountElements()
    {
        driver.navigate().to("http://qajava.skillbox.ru/");
        var countElement = driver.findElements(By.className("book-info"));
        var actualResult = countElement.size();
        Assert.assertEquals("Кол-во элементов не 15 шт.", 15, actualResult);
    }
}
