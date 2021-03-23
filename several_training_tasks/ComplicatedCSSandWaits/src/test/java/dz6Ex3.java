import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class dz6Ex3 {
    private WebDriver driver;
    private WebDriverWait wait;
    private By startButton = By.cssSelector("button.articlePreview__link");
    private By rightButton = By.cssSelector("div.vb-content > div:nth-child(1) > button");
    private By rightButtonBot = By.cssSelector("div.vb-content > div:nth-child(2) > button");
    private By titleLocator = By.cssSelector("input.baseInput__field");
    private By titleRightButtonLocator = By.cssSelector("div:nth-child(1) > div.articlePreview__content > p.articlePreview__title");
    private By textLocator = By.cssSelector("textarea.baseTextarea__text");
    private By textRightButtonLocator = By.cssSelector("div:nth-child(1) > div.articlePreview__content > p.articlePreview__text");
    private By deleteLocator = By.cssSelector("div.pageArticle__buttons > button:nth-child(2) > svg");
    private By allButtonLocator = By.cssSelector("div.vb-content");
    @Before
    public void SetUp()
    {
        System.setProperty("webdriver.chrome.driver", "drivers//chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 5);

    }
    @After
    public void TearDown()
    {
        driver.quit();
    }

    @Test
    public void test()
    {
     driver.navigate().to("http://qa.skillbox.ru/module15/bignotes/#/statistic");
     driver.findElement(startButton).click();
     wait.until(ExpectedConditions.visibilityOfElementLocated(rightButton));
     var title = driver.findElement(titleLocator).getAttribute("_value");
     var titleRightButton = driver.findElement(titleRightButtonLocator).getText();
     Assert.assertEquals("текст заголовков не совпал", title, titleRightButton);
     var text = driver.findElement(textLocator).getAttribute("_value");
     var textRightButton = driver.findElement(textRightButtonLocator).getText();
     Assert.assertEquals("текст не совпал", text, textRightButton);
     driver.findElement(deleteLocator).click();
     wait.until(ExpectedConditions.numberOfElementsToBe(allButtonLocator, 1));
    }
}
