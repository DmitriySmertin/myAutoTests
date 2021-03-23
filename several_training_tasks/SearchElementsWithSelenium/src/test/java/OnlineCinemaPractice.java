import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OnlineCinemaPractice {

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
    public void testPlus()
    {
        driver.navigate().to("https://lm.skillbox.cc/qa_tester/module06/register/");
        driver.findElement(By.name("name")).sendKeys("Test");
        driver.findElement(By.name("email")).sendKeys("skillbox@test.ru");
        driver.findElement(By.name("password")).sendKeys("qwerty!123");
        driver.findElement(By.className("form-submit")).click();
        var actualResult = driver.findElement(By.className("form-result")).getText();
        var expectedResult = "Вам на почту skillbox@test.ru отправлено письмо";
        Assert.assertEquals("Введённые данные не совпадают!",actualResult,expectedResult);
    }

    @Test
    public void testButtonNoData()
    {
        driver.navigate().to("https://lm.skillbox.cc/qa_tester/module06/register/");
        driver.findElement(By.className("form-submit")).click();
        var actualResult = driver.findElement(By.className("form-error")).getText();
        var extendedResult = "Введите имя";
        Assert.assertEquals(
                "Текст ошибки не совпадает с ожидаемым результатом теста",
                actualResult,
                extendedResult);
    }
}
