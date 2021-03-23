import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class dz6Ex2 {
    private static WebDriver driver;

    private By inputLocator = By.cssSelector("input:not([id])");
    private By pLocator = By.cssSelector("p:not([class^=form],[class~=error])");
    private By formLocator =By.cssSelector("div.form-inner p.form-row:first-child");

    @BeforeClass
    public static void SetUp()
    {
        System.setProperty("webdriver.chrome.driver", "drivers//chromedriver.exe");
        driver = new ChromeDriver();
    }
    @AfterClass
    public static void TearDown()
    {
        driver.quit();
    }
    @Test
    public void test()
    {
        driver.navigate().to("https://lm.skillbox.cc/qa_tester/module04/practice1/");
        driver.findElement(inputLocator);
        driver.findElement(pLocator);
        driver.findElement(formLocator);
    }
}
