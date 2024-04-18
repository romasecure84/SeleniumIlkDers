package tests;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;

public class Test20 {
    public static void main(String[] args) throws InterruptedException, IOException {
        Faker faker = new Faker();
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1382, 744));
        driver.manage().window().setPosition(new Point(-8, -8));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));


        String homePage="https://www.facebook.com";
        String url="";
        HttpURLConnection huc = null;
        int respCode=200;

        driver.get(homePage);

        List<WebElement> links=driver.findElements(By.tagName("a"));
        Iterator<WebElement> it=links.iterator();

        while (it.hasNext()){
            url=it.next().getAttribute("href");
            if (url == null || url.isEmpty()){
                System.out.println("Bu baglanti bos, kecildi.");
                continue;
            }
            if (!url.startsWith(homePage)){
                System.out.println("URL bizim sehifemize aid deyil, kecildi");
                continue;
            }
            huc=(HttpURLConnection)(new URL(url).openConnection());
            huc.setRequestMethod("HEAD");
            huc.connect();
            respCode= huc.getResponseCode();
            if (respCode >= 400){
                System.out.println(url+" Islemeyen link!");
            }else {
                System.out.println(url+" Isleyen link");
            }
        }
        Thread.sleep(2000);
        driver.quit();
    }
}
