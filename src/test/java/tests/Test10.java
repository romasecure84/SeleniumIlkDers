package tests;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import utilities.ConfigReader;

import java.time.Duration;

public class Test10 {
    public static void main(String[] args) throws InterruptedException {
        Faker faker = new Faker();
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1382, 744));
        driver.manage().window().setPosition(new Point(1912, 303));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get(ConfigReader.getProperty("demoDDURL"));
        Thread.sleep(1000);
        WebElement angular= driver.findElement(By.id("angular"));
        WebElement mongo= driver.findElement(By.id("mongo"));
        WebElement node= driver.findElement(By.id("node"));

        Actions actions=new Actions(driver);
        Thread.sleep(1000);
        actions.dragAndDrop(angular, driver.findElement(By.id("droparea"))).build().perform();
        actions.dragAndDrop(node, driver.findElement(By.id("droparea"))).build().perform();
        actions.dragAndDrop(mongo, driver.findElement(By.id("droparea"))).build().perform();




    }
}
