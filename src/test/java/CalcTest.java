
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
        System.setProperty("webdriver.chrome.driver", "src/test/java/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.calc.ru/kalkulyator-kalorii.html");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void howMuchYouNeedToSaveYourWeight() {
        WebElement ageField = driver.findElement(By.id("age"));
        ageField.sendKeys("26");
        //write age
        WebElement weightField = driver.findElement(By.id("weight"));
        weightField.sendKeys("88");
        //write weight
        WebElement heightField = driver.findElement(By.id("sm"));
        heightField.sendKeys("183");
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
        String expectedResult = "2928 ккал/день";
        //expected result
        Assert.assertEquals(howMuchYouNeed, expectedResult );
        //is answer true
    }

    @AfterTest
    public void quit() {
        driver.quit();
        //quit
    }
}