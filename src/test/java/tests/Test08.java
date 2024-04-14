package tests;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import utilities.ConfigReader;

import java.time.Duration;
import java.util.List;

public class Test08 {
    public static void main(String[] args) throws InterruptedException {
        Faker faker = new Faker();
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1382, 744));
        driver.manage().window().setPosition(new Point(1912, 303));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get(ConfigReader.getProperty("guru99RegisterURL"));
        driver.findElement(By.name("firstName")).sendKeys(faker.name().firstName());
        driver.findElement(By.name("lastName")).sendKeys(faker.name().lastName());
        driver.findElement(By.name("phone")).sendKeys(faker.phoneNumber().cellPhone());
        driver.findElement(By.name("userName")).sendKeys(faker.internet().emailAddress());
        driver.findElement(By.name("address1")).sendKeys(faker.address().streetAddressNumber());
        driver.findElement(By.name("city")).sendKeys(faker.address().city());
        driver.findElement(By.name("state")).sendKeys(faker.address().state());
        driver.findElement(By.name("postalCode")).sendKeys(faker.address().zipCode());
        WebElement country=driver.findElement(By.name("country"));
        Select dropCountry=new Select(country);
        dropCountry.selectByVisibleText("UNITED STATES");
        driver.findElement(By.xpath("//*[@id='email']")).sendKeys(faker.internet().emailAddress());
        String password=faker.internet().password();
        driver.findElement(By.xpath("(//*[@type='password'])[1]")).sendKeys(password);
        driver.findElement(By.xpath("(//*[@type='password'])[2]")).sendKeys(password);
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@type='submit']")).click();

    }
}
