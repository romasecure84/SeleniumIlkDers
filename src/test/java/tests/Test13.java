package tests;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class Test13 {
    public static void main(String[] args) throws InterruptedException {
        Faker faker = new Faker();
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        //driver.manage().window().setSize(new Dimension(1382, 744));
        //driver.manage().window().setPosition(new Point(1912, 303));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://demo.guru99.com/test/upload");
        Actions actions=new Actions(driver);
        WebElement uploadFile= driver.findElement(By.id("uploadfile_0"));
        WebElement terms= driver.findElement(By.xpath("//*[@id='terms']"));
        WebElement submitButton= driver.findElement(By.id("submitbutton"));

        uploadFile.sendKeys("C:/Users/Roma/Downloads/68c7a176-9747-4d0f-a7b3-ea321d0aac62.jpg");
        Thread.sleep(1000);
        terms.click();
        submitButton.click();
        Thread.sleep(3000);
        driver.quit();
    }
}
