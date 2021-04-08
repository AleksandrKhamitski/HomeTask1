import jdk.internal.org.objectweb.asm.tree.analysis.Value;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Example {

        @Test
    public void checkjunit() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\mts\\IdeaProjects\\HomeTask2\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.calc.ru/kalkulyator-kalorii.html");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        WebElement age = driver.findElement(By.id("age"));
        age.sendKeys("26");
        //write age

        WebElement getAge = driver.findElement(By.xpath("//input[@id=\"age\"]"));
        //find answer

        String Age26 = getAge.getText().toString();
        //get text from answer
        System.out.println(Age26);
        //print age26
        Assert.assertEquals("26", Age26);
        //is age26 true

    }
}
