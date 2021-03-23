import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class dz3Ex1 {

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
    public void testNegative()
    {
        driver.navigate().to("https://lm.skillbox.cc/qa_tester/module03/practice1/");
        driver.findElement(By.name("check")).sendKeys("Test");
        driver.findElement(By.id("check-size-button")).click();
        var actualResult = driver.findElement(By.id("size-error")).getText();
        var extendedResult = ("Введите размер обуви!");
        Assert.assertEquals("Текст ошибки не совпадает с ТЗ", extendedResult, actualResult);
    }

    @Test
    public void testPositive()
    {
        driver.navigate().to("https://lm.skillbox.ru/qa_tester/module03/practice1/");
        driver.findElement(By.tagName("input")).sendKeys("34");
        driver.findElement(By.id("check-size-button"));
    }
}
