package day07;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C02_DropDownHandle {
        /*
              ● Bir class oluşturun: C3_DropDownAmazon
              ● https://www.amazon.com/ adresine gidin.
              - Test 1
              Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 45
              oldugunu test edin
              -Test 2
              1. Kategori menusunden Books secenegini secin
              2. Arama kutusuna Java yazin ve aratin
              3. Bulunan sonuc sayisini yazdirin
              4. Sonucun Java kelimesini icerdigini test edin
         */
        /*
        DropDown menuye ulasmak icin select class'indan bir obje olustururuz
        ve locate ettigimiz dropdown webelement'inin select class'ina tanimlariz
        ve getOption methodunu kullanarak dropdown'u bir liste atarak dropdown menunun
        butun elemanlarının sayısına ulasabiliriz
        */
        WebDriver driver;
        @Before
        public void setup(){
            WebDriverManager.chromedriver().setup();
            driver= new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
            // ● https://www.amazon.com/ adresine gidin.
            driver.get("https://www.amazon.com/");;
        }
    @After
    public void tearDown(){
        driver.close();
    }
    @Test
    public void Test1(){

        //- Test 1
        //  Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 45
        //  oldugunu test edin
        WebElement menu=driver.findElement(By.id("searchDropdownBox"));
        Select select= new Select(menu);
        List<WebElement> listMenu=select.getOptions();
         int adet=listMenu.size();
        Assert.assertFalse(adet==45);
        //1. Kategori menusunden Books secenegini secin
        select.selectByVisibleText("Books");
        //2. Arama kutusuna Java yazin ve aratin
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Java"+ Keys.ENTER);
        //3. Bulunan sonuc sayisini yazdirin
       String sonuc=driver.findElement(By.xpath("//*[text()='1-16 of over 30,000 results for']")).getText();
       String[] sonucArr=sonuc.split(" ");
        System.out.println("sonuc sayisi = " + sonucArr[3]);
        //  4. Sonucun Java kelimesini icerdigini test edin
        String sonucYazi=driver.findElement(By.xpath("//*[text()='\"Java\"']")).getText();
        Assert.assertTrue(sonucYazi.contains("Java"));

    }
}
