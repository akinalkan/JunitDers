package day05;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_BeforeClassAfterClass {
    /*
    BeforeClass ve AfterClass notasyonlari kullaniyorsak
    olusturacagimiz method'u static yapmammiz gerekiyor
    */
    static WebDriver driver;

    @BeforeClass
    public static void beforeClass(){
        /*
    BeforeClass ve AfterClass notasyonları kullanıyorsak oluşturacağımız method'u static yapmamız gerekiyor
     */
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    @AfterClass
    public static void teardown(){
        driver.close();
    }
    @Test
    public void method1(){
        driver.get("https://www.amazon.com");
    }
    /*
    Çalışmasını istemediğimiz test için @Ignore notasyonu kullanılır
     */
    @Test
    @Ignore("Arkadasimin testi'sin")
    public void method2(){
        driver.get("https://www.facebook.com");
    }
    @Test
    public void method3(){
        driver.get("https://www.hepsiburada.com");
    }


}
