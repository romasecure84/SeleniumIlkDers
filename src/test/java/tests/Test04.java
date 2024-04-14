package tests;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.ConfigReader;

import java.time.Duration;

public class Test04 {
    public static void main(String[] args) throws InterruptedException {
        Faker faker = new Faker();
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1382, 744));
        driver.manage().window().setPosition(new Point(1912, 303));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get(ConfigReader.getProperty("guru99RadioURL"));
        driver.findElement(By.id("vfb-6-0")).click();
        Thread.sleep(2000);
        if (driver.findElement(By.id("vfb-6-1")).isSelected()){
            System.out.println("Check box2 secili");
        }else {System.out.println("Checkbox2 secili deyil");
        driver.findElement(By.id("vfb-6-2")).click();
        }
    }
}
