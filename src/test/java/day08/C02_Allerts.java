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

public class C02_Allerts {
    //    Bir class olusturun: Alerts
//    https://the-internet.herokuapp.com/javascript_alerts adresine gidin.
//    Bir metod olusturun: acceptAlert
//1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının  "You successfully clicked an alert" oldugunu test edin.
//    Bir metod olusturun: dismissAlert
//2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının
//"successfuly" icermedigini test edin.
//    Bir metod olusturun: sendKeysAlert
//3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna
//    tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.
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
        //    https://the-internet.herokuapp.com/javascript_alerts adresine gidin.
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        //1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının
        // "You successfully clicked an alert" oldugunu test edin.
        driver.findElement(By.xpath("//*[@onclick='jsAlert()']")).click();
        driver.switchTo().alert().accept();
        Assert.assertTrue(driver.getPageSource().contains("You successfully clicked an alert"));

    }

    @Test
    public void test2(){
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        //2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve
        // result mesajının "successfuly" icermedigini test edin.
        driver.findElement(By.xpath("//*[@onclick='jsConfirm()']")).click();
        driver.switchTo().alert().dismiss();
        String actualMesaj=driver.findElement(By.xpath("//*[@id='result']")).getText();
        String expectedMesaj="successfuly";
        Assert.assertFalse(actualMesaj.contains(expectedMesaj));
    }
    @Test
    public void test3(){
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        //○ 3. butona tıklayın,
        driver.findElement(By.xpath("//*[text()='Click for JS Prompt']")).click();
        // uyarıdaki metin kutusuna isminizi yazin,
        driver.switchTo().alert().sendKeys("Akin");
        // OK butonuna tıklayın ve
        driver.switchTo().alert().accept();
        // result mesajında isminizin görüntülendiğini doğrulayın.
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='You entered: Akin']")).isDisplayed());
    }
}
