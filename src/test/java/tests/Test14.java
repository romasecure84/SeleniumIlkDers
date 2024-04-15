package tests;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.nio.file.Files;
import java.time.Duration;

public class Test14 {
    public static void main(String[] args) throws InterruptedException {
        Faker faker = new Faker();
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1382, 744));
        driver.manage().window().setPosition(new Point(1912, 303));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://demoqa.com/upload-download");
        Thread.sleep(2000);
        driver.findElement(By.id("downloadButton")).click();

        String downloadPath="C:/Users/Roma/Downloads";
        String fileName="sampleFile.jpeg";
        Thread.sleep(3000);

        System.out.println(isDownloaded(downloadPath, fileName));

    }
    public static boolean isDownloaded(String downloadPath, String fileName){
        File file=new File(downloadPath);
        File[] files=file.listFiles();

        for(int i=0; i< files.length; i++){
            if (files[i].getName().equals(fileName)){
                return true;
            }
        }
        return false;
    }
}
