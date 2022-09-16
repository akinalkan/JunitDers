package day05;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_BeforeAfter {
    WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @Test
    public void method1() throws InterruptedException {
        driver.get("https://www.amazon.com");
        WebElement aramakutusu = driver.findElement(By.id("twotabsearchtextbox"));
        aramakutusu.sendKeys("nutella" + Keys.ENTER);
        driver.findElement(By.xpath("//*[text()='Nutella Chocolate Hazelnut Spread, Perfect Topping for Pancakes, 35.2 oz Jar']")).click();
        Thread.sleep(3000);
        //driver.findElement(By.className("(//*[@class='a-icon a-icon-section-expand'])[1]")).click();
        // WebElement icindekiler= driver.findElement(By.className("(//*[text()='SUGAR,PALM OIL,HAZELNUTS,COCOA,SKIM MILK,WHEY (MILK),LECITHIN AS EMULSIFIER (SOY),VANILLIN: AN ARTIFICIAL FLAVOR.'])[1]"));
        //System.out.println("icindekiler = " + icindekiler.getText());


    }

    @After
    public void teardown() {
        driver.close();
    }
}
