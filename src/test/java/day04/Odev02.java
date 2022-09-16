package day04;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Odev02 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        // 1-C01_TekrarTesti isimli bir class olusturun
        // 2- https://www.amazon.com/ adresine gidin
        driver.get("https://www.amazon.com/");

        // 3- Browseri tam sayfa yapin
        driver.manage().window().maximize();

        // Sayfayi “refresh” yapin
        driver.navigate().refresh();

        // Sayfa basliginin “Spend less” ifadesi icerdigini test edin
        String sayfaBasligi = driver.getTitle();
        String arananKelime = "Spend less";
        if(sayfaBasligi.contains("Spend less")){
            System.out.println("Test PASSED");
        }else
            System.out.println("Test FAILED");

        // Gift Cards sekmesine basin
        driver.findElement(By.xpath("//*[@class='nav-a  '][4]")).click();

        // Birthday butonuna basin
        driver.findElement(By.xpath("//*[@alt= 'Birthday gift cards']")).click();

        // Best Seller bolumunden ilk urunu tiklayin
        driver.findElement(By.xpath("//*[@alt='Amazon.com eGift Card']")).click();

        // 9- Gift card details’den 25 $’i secin
        driver.findElement(By.id("a-autoid-28")).click();

        // 10-Urun ucretinin 25$ oldugunu test edin
        WebElement expectedUcret = driver.findElement(By.xpath("//*[@id='gc-live-preview-amount']"));
        String actualUcret = expectedUcret.getText();
        System.out.println(expectedUcret.getText());
        if (actualUcret.contains("$25.00")){
            System.out.println("Urun ucreti 25$");
        }else
            System.out.println("Test FAILED");

        // 10-Sayfayi kapatin
        driver.close();

    }
}
