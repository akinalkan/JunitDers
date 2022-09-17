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

public class C01_Allerts {

    // https://the-internet.herokuapp.com/javascript_alerts adresine gidelim
// Click for JS Alert butonuna tıklayalım
// Tıkladıktan sonra çıkan uyarı mesajına (Alert) tamam diyelim
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
        //driver.close();
    }
    @Test
    public void test1(){
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(By.xpath("//*[@onclick='jsAlert()']")).click();

        System.out.println(driver.switchTo().alert().getText()); //Alert mesajını yazdırır

        driver.switchTo().alert().accept();   //Çıkan alert uyarısını kabul eder
        /*
bir web sitesine girdigimizde karsımıza bir uyarı mesajı yada bir buttona tıkladığımızda bir uyarı cıkabilir
eğer bu uyarıya incele(mouse sağ-tik inspect) yapabiliyorsak bu tür alert lere html alert denir.
ve istedigimiz locate'i alabiliriz. Ama gelen uyarı kutusuna müdahale (sağ tik inspect ile) edemiyorsak
bu tür alertlere  js alert denir.
js alert'lere müdahale edebilmek icin

-- tamam ya da ok icin
driver.switchTo().alert().accept();

--iptal icin
driver.switchTo().alert().dismiss();

--alert icindeki mesajı almak icin
driver.switchTo().alert().getText();

--alert bizden bir metin istiyorsa
driver.switchTo().alert().sendKeys("");

methodları kullanilir!!

 */
    }
}
