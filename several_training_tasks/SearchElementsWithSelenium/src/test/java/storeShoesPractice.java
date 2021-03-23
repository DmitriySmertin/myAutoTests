import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class storeShoesPractice {
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
    public void testPositive()
    {
        driver.navigate().to("https://lm.skillbox.ru/qa_tester/module03/practice1/");
        driver.findElement(By.tagName("input")).sendKeys("34");
        driver.findElement(By.id("check-size-button"));
    }
}
