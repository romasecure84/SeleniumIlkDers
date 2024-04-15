package tests;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilities.ConfigReader;

import javax.swing.*;
import java.time.Duration;

public class Test09 {
    public static void main(String[] args) throws InterruptedException {
        Faker faker = new Faker();
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1382, 744));
        driver.manage().window().setPosition(new Point(1912, 303));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get(ConfigReader.getProperty("amazonURL"));
        driver.findElement(By.id("sp-cc-rejectall-link")).click();
        WebElement tabBarAccount=driver.findElement(By.id("nav-link-accountList"));

        Actions actions=new Actions(driver);
        actions.moveToElement(tabBarAccount).perform();
        Thread.sleep(1000);

        driver.findElement(By.xpath("(//*[@class='nav-action-inner'])[1]")).click();
        Thread.sleep(2000);
        driver.quit();


    }
}
