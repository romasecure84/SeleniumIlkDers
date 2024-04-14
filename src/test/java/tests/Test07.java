package tests;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.ConfigReader;

import java.time.Duration;
import java.util.List;

public class Test07 {
    public static void main(String[] args) throws InterruptedException {
        Faker faker = new Faker();
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1382, 744));
        driver.manage().window().setPosition(new Point(1912, 303));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get(ConfigReader.getProperty("guru99LinkURL"));
        List<WebElement> linkler=driver.findElements(By.partialLinkText("here"));
        linkler.get(0).click();
        driver.navigate().back();
        linkler.get(1).click();
        driver.quit();


    }
}
