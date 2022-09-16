package day07;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C03_DropDown {
    WebDriver driver;
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://the-internet.herokuapp.com/dropdown");;
    }
    @After
    public void tearDown(){
        driver.close();
    }
    /*
        ● Bir class oluşturun: DropDown
    ● https://the-internet.herokuapp.com/dropdown adresine gidin.
    1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
    2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
    3.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
    4.Tüm dropdown değerleri(value) yazdırın
    5. Dropdown’un boyutunu bulun, Dropdown’da 4 öğe varsa konsolda True , degilse
    False yazdırın.
     */
    @Test
    public void test1(){
    WebElement menu=driver.findElement(By.xpath("//select[@id='dropdown']"));
        Select select= new Select(menu);
        //1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
       select.selectByIndex(1);
        System.out.println(driver.findElement(By.xpath("//*[text()='Option 1']")).getText());
        //2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
        select.selectByIndex(2);
        System.out.println(driver.findElement(By.xpath("//*[text()='Option 2']")).getText());
        //3.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        select.selectByVisibleText("Option 1");
        System.out.println(driver.findElement(By.xpath("//*[text()='Option 1']")).getText());
        // 4.Tüm dropdown değerleri(value) yazdırın
       List<WebElement> liste= select.getOptions();
        for (WebElement each:liste) {
            System.out.println(each);
        }
        // 5. Dropdown’un boyutunu bulun, Dropdown’da 4 öğe varsa konsolda True , degilse
        //    False yazdırın.
        System.out.println("liste boyutu = " + liste.size());
        int listeBoyutu=liste.size();
        int expectedSayi=4;
        if(listeBoyutu==expectedSayi){
            System.out.println("True");
        }else {
            System.out.println("False");
        }


    }
}
