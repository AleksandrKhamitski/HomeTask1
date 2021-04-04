import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class CalcTest {
    @Test
    public void HowMuchYouNeedToSaveYourWeightResultTest() {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\mts\\IdeaProjects\\MyFirstProject\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.calc.ru/kalkulyator-kalorii.html");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        WebElement age = driver.findElement(By.id("age"));
        age.sendKeys("26");
        //write age

        WebElement weight = driver.findElement(By.id("weight"));
        weight.sendKeys("88");
        //write weight

        WebElement height = driver.findElement(By.id("sm"));
        height.sendKeys("183");
        //write height

        WebElement clickResult = driver.findElement(By.id("submit"));
        clickResult.click();
        //click result button

        WebElement Result = driver.findElement(By.xpath("//td[contains(text(), '2928 ккал/день')]"));
        //find answer
        String Result1 = Result.getText();
        //get text from answer
        System.out.println(Result1);
        //print answer
        Assert.assertEquals(Result1, "2928 ккал/день");
        //is answer true
        driver.quit();
        //quit
    }
}
