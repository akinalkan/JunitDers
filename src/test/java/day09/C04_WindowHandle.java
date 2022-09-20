package day09;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.lang.reflect.Array;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class C04_WindowHandle {
    /*
    Tests package’inda yeni bir class olusturun: WindowHandle2
    https://the-internet.herokuapp.com/windows adresine gidin.
    Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
    Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
    Click Here butonuna basın.
    Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
    Sayfadaki textin “New Window” olduğunu doğrulayın.
    Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu  doğrulayın.
     */
    WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void teardown() {
        //driver.quit();
    }

    @Test
    public void test01() {
        //https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");

        //Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        String expectedWord = "Opening a new window";
        String actualWord = driver.findElement(By.xpath("//*[text()='Opening a new window']")).getText();
        Assert.assertTrue(actualWord.contains(expectedWord));

        //Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        String acctualTitle = driver.getTitle();
        String expectedTitle = "The Internet";
        Assert.assertTrue(acctualTitle.contains(expectedTitle));

        //Click Here butonuna basın.
        driver.findElement(By.xpath("//*[text()='Click Here']")).click();
        List<String > windowList= new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(windowList.get(1));
        /*
        Bir web sitesine gittigimizde bir webelementi tikladigimizda
        yeni bir sekme ya da pencere acilirsa
        bu yeni acilan sekmenin handle degerini bulabilmek
        icin driver.getWindowHandles() methodunu bir ArrayList'e
        atip butun sayfalarin listesine ulasabiliriz.
        Ilk actigim pencerenin index'i 0'dır,ikinci acilan sekmenin index'i 1'dir
        ve ikinci acilan pencere veya sekmede islem yapabilmek icin
        driver.switchTo().window(ListAdi.get(1)) methodu kullaniriz
        */

        // Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
        String actualTitleNew = driver.getTitle();
        String expectedTitleNew = "New Window";
        Assert.assertTrue(actualTitleNew.contains(expectedTitleNew));

        // Sayfadaki textin "New Window" olduğunu doğrulayın.
        WebElement text = driver.findElement(By.className("example"));
        String actualText = "New Window";
        Assert.assertTrue(text.getText().contains(actualText));

        //Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu  doğrulayın.
        driver.switchTo().window(windowList.get(0));
        Assert.assertTrue(driver.getTitle().contains("The Internet"));
    }
    /*
        Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
        List<String> windowList = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(windowList.get(1));

        NOT: String'lerden oluşan bir list oluşturup getWindowHandles() method'u ile
        açık bulunan tüm sayfaların / pencerelerin WindowHandle değerlerini o list'e atıyoruz.

        Daha sonra driver.switchTo().window() method'unun içine oluşturduğumuz list'ten
        hangi web sayfasını istiyorsak onun indeksini yazarak sayfalar arasında geçiş yapabiliyoruz.

        Yapı şu şekilde: driver.switchTo().window(listAdı.get(window'un indeks numarası))

        Örneğimizde windowList adındaki list'imizden 1. elementi getirdik.
        0 ilk sayfanın WindowHandle değerini, 1 ise ikinci sayfanın WindowHandle değerini verir.
        */

}
