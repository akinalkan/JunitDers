package day08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_BasicAuthentication {
    /*
    1- Bir class olusturun : BasicAuthentication
    2- https://the-internet.herokuapp.com/basic_auth sayfasina gidin
    3- asagidaki yontem ve test datalarini kullanarak authentication’i yapin

    Html komutu : https://username:password@URL

    Username : admin
    password : admin
    4- Basarili sekilde sayfaya girildigini dogrulayin
     */
    //driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
    WebDriver driver;
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @After
    public void tearDown(){
        //  driver.close();
    }
    @Test
    public void test1(){
        //https://the-internet.herokuapp.com/basic_auth   sayfasina gidin
        driver.get("https://the-internet.herokuapp.com/basic_auth");

        // 3- asagidaki yontem ve test datalarini kullanarak authentication’i yapin
        //
        //    Html komutu : https://username:password@URL
        //
        //    Username : admin
        //    password : admin
        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Basic Auth']")).isDisplayed());

    }
}
