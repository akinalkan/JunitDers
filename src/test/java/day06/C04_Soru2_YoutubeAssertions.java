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

public class C04_Soru2_YoutubeAssertions {
          /*
        1) Bir class oluşturun: YoutubeAssertions
        2) https://www.youtube.com adresine gidin
        3) Aşağıdaki adları kullanarak 3 test metodu oluşturun ve gerekli testleri yapin

        ○ titleTest
        => Sayfa başlığının “YouTube” oldugunu test edin
        ○ imageTest
        => YouTube resminin görüntülendiğini (isDisplayed()) test edin
        ○ Search Box 'in erisilebilir oldugunu test edin (isEnabled())
        ○ wrongTitleTest => Sayfa basliginin “youtube” olmadigini dogrulayin
          */
          WebDriver driver;
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.youtube.com");
    }
    @After
    public void tearDown(){
        driver.close();
    }
    @Test
    public void titleTest(){
        //Sayfa başlığının “YouTube” oldugunu test edin
        Assert.assertTrue(driver.getTitle().contains("YouTube"));
    }
    @Test
    public void imageTest(){
        //YouTube resminin görüntülendiğini (isDisplayed()) test edin
        Assert.assertTrue(driver.findElement(By.xpath("(//*[@id='logo-icon'])[1]")).isDisplayed());
        //Search Box 'in erisilebilir oldugunu test edin (isEnabled())
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='search-input']")).isEnabled());
    }
    @Test
    public void wrongTitleTest(){
        //Sayfa basliginin “youtube” olmadigini dogrulayin
        Assert.assertFalse(driver.getTitle().equals("youtube"));
    }




}
