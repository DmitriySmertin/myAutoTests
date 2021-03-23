import org.openqa.selenium.By;

public class dz6Ex1 {
    private By a = By.cssSelector("section.header *:not(div,h1)");
    private By b = By.cssSelector("div.text > [href]");
    private By c = By.cssSelector("section > div:nth-child(3) > a");
}
