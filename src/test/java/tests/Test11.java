package tests;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import utilities.ConfigReader;

import java.time.Duration;

public class Test11 {
    public static void main(String[] args) throws InterruptedException {
        Faker faker = new Faker();
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1382, 744));
        driver.manage().window().setPosition(new Point(1912, 303));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://demo.guru99.com/test/simple_context_menu.html");
        Actions actions=new Actions(driver);
        WebElement rightClickBtn= driver.findElement(By.xpath("//*[@id='authentication']/span"));
        actions.contextClick(rightClickBtn).perform();
        WebElement copyBtn= driver.findElement(By.cssSelector(".context-menu-icon-copy"));
        copyBtn.click();
        Thread.sleep(1000);

        driver.switchTo().alert().accept();

    }
}
