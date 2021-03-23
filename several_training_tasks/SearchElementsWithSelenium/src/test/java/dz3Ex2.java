import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class dz3Ex2 {
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
    public void testFindElements()
    {
        driver.navigate().to("http://qajava.skillbox.ru/");
        driver.findElement(By.linkText("Обратная связь"));
        driver.findElement(By.linkText("Предзаказы"));
        driver.findElement(By.xpath("/html/body/div/div[1]/div[1]/div[2]/button"));
        driver.findElement(By.id("cart_count"));
        driver.findElement(By.linkText("Книги"));
        driver.findElement(By.name("search-input-form"));
    }
}
