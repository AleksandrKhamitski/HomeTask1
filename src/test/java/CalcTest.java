
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

public class CalcTest {
    private WebDriver driver = null;

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\mts\\IdeaProjects\\MyFirstProject\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.calc.ru/kalkulyator-kalorii.html");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void howMuchYouNeedToSaveYourWeight() {
        WebElement writeAge = driver.findElement(By.id("age"));
        writeAge.sendKeys("26");
        //write age
        WebElement writeWeight = driver.findElement(By.id("weight"));
        writeWeight.sendKeys("88");
        //write weight
        WebElement writeHeight = driver.findElement(By.id("sm"));
        writeHeight.sendKeys("183");
        //write height
        WebElement clickResult = driver.findElement(By.id("submit"));
        clickResult.click();
        //click result button
        WebElement resultOfCalculation = driver.findElement(By.xpath("//td[contains(text(), '2928 ккал/день')]"));
        //find answer
        String howMuchYouNeed = resultOfCalculation.getText();
        //get text from answer
        System.out.println(howMuchYouNeed);
        //print answer
        Assert.assertEquals(howMuchYouNeed, "2928 ккал/день");
        //is answer true
    }

    @AfterTest
    public void quit() {
        driver.quit();
        //quit
    }
}