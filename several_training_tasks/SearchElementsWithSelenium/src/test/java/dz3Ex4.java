import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

public class dz3Ex4 {
private  WebDriver driver;
    @Before
    public void SetUp()
    {
        System.setProperty("webdriver.chrome.driver", "drivers//chromedriver.exe");
         driver = new ChromeDriver();
    }
    @After
    public  void TearDown()
    {

        driver.quit();
    }

    @Test
    public void testScenario1()
    {
        var film = ("Testfilms");
        var serials =("TestSerils");

        driver.navigate().to("https://lm.skillbox.ru/qa_tester/module07/practice3/");
        driver.findElement(By.name("films")).sendKeys(film);
        driver.findElement(By.id("serials")).sendKeys(serials);
        driver.findElement(By.id("save")).click();
        driver.findElement(By.id("two")).click();
        driver.findElement(By.className("section__button")).click();
        driver.findElement(By.id("ok")).click();
        var actualResultFilm = driver.findElement(By.id("best_films")).getText();
        var actualResultSerial = driver.findElement(By.id("best_serials")).getText();
        Assert.assertEquals(
                "Фильмы введённые не совпали с сообшением вывода на экран",
                film,
                actualResultFilm);
        Assert.assertEquals("Сериалы введённые не совпали с сообшением вывода на экран",
                serials, actualResultSerial);
    }

    @Test
    public void testEmptyData()
    {
            driver.navigate().to("https://lm.skillbox.ru/qa_tester/module07/practice3/");
            driver.findElement(By.id("save")).click();
            driver.findElement(By.id("two")).click();
            driver.findElement(By.className("section__button")).click();
            driver.findElement(By.id("ok")).click();
            var elementFinish = driver.findElement(By.xpath("/html/body/main/div[2]/div"));
            Assert.assertEquals("Сообщение о результатах, не появилось на странице",
                    true, elementFinish.isDisplayed());
        }

    @Test
    public void testCheckBox()
        {
            driver.navigate().to("https://lm.skillbox.cc/qa_tester/module07/practice3/");
            driver.findElement(By.id("save")).click();
            driver.findElement(By.id("two")).click();
            List<WebElement> elementList = driver.findElements(By.className("fake-checkbox"));
            for (int i =0; i<4; i++)
            {
            elementList.get(i).click();
            }
            driver.findElement(By.className("section__button")).click();
            driver.findElement(By.id("ok")).click();
            var actualResult = driver.findElement(By.id("language")).getText();
            var extendedResult = ("С русскими субтитрами, С английскими субтитрами, В оригинале, В дубляже");
            Assert.assertEquals("Чекбоксы не сработали", extendedResult, actualResult);
        }
}
