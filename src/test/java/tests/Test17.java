package tests;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Test17 {
    public static void main(String[] args) throws InterruptedException {
        Faker faker = new Faker();
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1382, 744));
        driver.manage().window().setPosition(new Point(-8, -8));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://demo.guru99.com/test/social-icon.html");
        String expectedData="Github";
        WebElement mailButton=driver.findElement(By.xpath("//*[@id=\"page\"]/div[2]/div/a[4]"));
        Thread.sleep(2000);
        String actualData=mailButton.getAttribute("title");



        if (expectedData.equals(actualData)){
            System.out.println("tooltip is valid");
        }else {
            System.out.println("tooltip not valid");
        }
    }
}
