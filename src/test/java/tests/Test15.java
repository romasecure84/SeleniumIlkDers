package tests;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Test15 {
    public static void main(String[] args) throws InterruptedException {
        Faker faker = new Faker();
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1382, 744));
        driver.manage().window().setPosition(new Point(-8, -8));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://demo.guru99.com/test/delete_customer.php");
        WebElement idInput=driver.findElement(By.name("cusid"));
        WebElement submit= driver.findElement(By.name("submit"));

        idInput.sendKeys(faker.idNumber().valid());
        submit.click();

        Alert alert=driver.switchTo().alert();

        String alertMessage=driver.switchTo().alert().getText();
        System.out.println(alertMessage);
        Thread.sleep(2000);
        alert.accept();
        Thread.sleep(2000);
        driver.switchTo().alert().accept();
        Thread.sleep(1000);
        driver.quit();
    }
}
