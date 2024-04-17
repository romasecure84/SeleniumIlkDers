package tests;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class Test19 {
    public static void main(String[] args) throws InterruptedException, IOException {
        Faker faker = new Faker();
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1382, 744));
        driver.manage().window().setPosition(new Point(-8, -8));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://www.facebook.com");

        TakesScreenshot scrShot=((TakesScreenshot) driver);
        File scrFile=scrShot.getScreenshotAs(OutputType.FILE);
        File destFile=new File("/C:/Users/ROMA2/Desktop/ScrFile/test.png");
        FileUtils.copyFile(scrFile,destFile);

        Thread.sleep(2000);
        driver.quit();
    }
}
