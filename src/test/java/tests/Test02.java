package tests;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.ConfigReader;
import utilities.Driver;

import java.time.Duration;

public class Test02{

    public static void main(String[] args) throws InterruptedException {
        Faker faker=new Faker();
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1382, 744));
        driver.manage().window().setPosition(new Point(1912, 303));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get(ConfigReader.getProperty("guru99URL"));
        driver.findElement(By.id("email")).sendKeys(faker.internet().emailAddress());
        driver.findElement(By.id("passwd")).sendKeys(faker.internet().password());
        driver.findElement(By.id("SubmitLogin")).click();
        //driver.findElement(By.xpath("//*[@id='email']")).sendKeys(faker.internet().emailAddress());
        //driver.findElement(By.xpath("//*[@id='passwd']")).sendKeys(faker.internet().password());
        //driver.findElement(By.xpath("//*[@id='SubmitLogin']")).click();

    }
}
