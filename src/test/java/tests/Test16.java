package tests;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Test16 {
    public static void main(String[] args) throws InterruptedException {
        Faker faker = new Faker();
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1382, 744));
        driver.manage().window().setPosition(new Point(-8, -8));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://demo.guru99.com/popup.php");
        driver.findElement(By.linkText("Click Here")).click();

        List<String> tabs=new ArrayList<>(driver.getWindowHandles());

        driver.switchTo().window(tabs.get(1));
        Thread.sleep(5000);
        driver.findElement(By.name("emailid")).sendKeys(faker.internet().emailAddress());
        driver.findElement(By.name("btnLogin")).click();
        Thread.sleep(2000);
        driver.findElement(By.linkText("Click Here")).click();
        Thread.sleep(2000);

        driver.switchTo().window(tabs.get(0));
        Thread.sleep(1000);
        driver.close();
        Thread.sleep(2000);
        driver.quit();
    }
}
