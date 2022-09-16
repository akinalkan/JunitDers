package day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_Soru1_BestBuyAssertions {
    /*
        1) Bir class oluşturun: BestBuyAssertions

        2) https://www.bestbuy.com/ Adresine gidin farkli test method’lari olusturarak asagidaki testleri yapin

            ○ Sayfa URL’inin https://www.bestbuy.com/ ‘a esit oldugunu test edin
            ○ titleTest => Sayfa başlığının “Rest” içermediğini(contains) test edin
            ○ logoTest => BestBuy logosunun görüntülendigini test edin
            ○ FrancaisLinkTest => Fransizca Linkin görüntülendiğini test edin
     */
    WebDriver driver;
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.bestbuy.com/");
    }
    @After
    public void tearDown(){
        driver.close();
    }
    @Test
    public void test1(){
        //Sayfa URL’inin https://www.bestbuy.com/ ‘a esit oldugunu test edin
        String exceptedUrl="https://www.bestbuy.com/";
        String actualUrl=driver.getCurrentUrl();
        Assert.assertEquals(actualUrl,exceptedUrl);
    }
    @Test
    public void test2(){
        //titleTest => Sayfa başlığının “Rest” içermediğini(contains) test edin
        String expectedTitle="Rest";
        String actualTitle=driver.getTitle();
        Assert.assertFalse(actualTitle.contains(expectedTitle));
    }
    @Test
    public void test3(){
        //logoTest => BestBuy logosunun görüntülendigini test edin
       /*
       <img src="https://www.bestbuy.com/~assets/bby/_com/header-footer/images/bby_logo-a7e90594729ed2e119331378def6c97e.png"
        class="logo" width="80" alt="Best Buy Logo">
        */
        Assert.assertTrue(driver.findElement(By.className("logo")).isDisplayed());
    }
    @Test
    public void test4(){
        //FrancaisLinkTest => Fransizca Linkin görüntülendiğini test edin
       Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Français']")).isDisplayed());

    }

}
