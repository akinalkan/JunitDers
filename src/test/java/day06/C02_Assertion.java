package day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_Assertion {
    /*
    -Amazon sayfasina gidelim
    -3 farkli test method'u olusturalim
      a-Url'in amazon icerdigini test edelim
      b-Title 'in facebook icermedigini test edelim
      c-Sol ust kosede amazon logosunun gorundugunu test edelim
     */
    /*
    Her 3 test de amazon sayfasına gitmeyi gerektirdiğinden bu kodu BeforeClass'a yazıyoruz.
    Not : BeforeAfter methodunda testleri farklı sayfalarda açıp kapatıyor,
     BeforeAfterCLass methodlarında aynı sayfada açıp sonra kapatıyor.
    BeforeAfter methodunda methodların static yapmaya gerek yok
     ama BeforeAfterCLass'da static yapmak zorunlu.
     */
    static WebDriver driver;
    @BeforeClass
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //Amazon sayfasina gidelim
        driver.get("https://www.amazon.com");
    }
    @AfterClass
    public static void tearDown() {
        driver.close();
    }
    @Test
    public void test1(){
        //Url'in amazon icerdigini test edelim
        String expectedUrl = "amazon";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(expectedUrl));



    }
    @Test
    public void test2() {
        //Title 'in facebook icermedigini test edelim
        String expectedTitle = "facebook";
        String actualTitle = driver.getTitle();
        Assert.assertFalse(actualTitle.contains(expectedTitle));
    }
    @Test
    public void test3(){
        //Sol ust kosede amazon logosunun gorundugunu test edelim
        WebElement logo=driver.findElement(By.id("nav-logo-sprites"));
        Assert.assertTrue(logo.isDisplayed());
    }
    /*
1. assertEquals
assertEquals , beklenen sonucu gerçek sonuç ile karşılaştırmak için kullanılır.
Beklenen sonuç ile gerçek sonuç eşit değil ise gerçekleştirilen test senaryosu sonucunda assertionError hatası fırlatır.
2. assertTrue
assertTrue, beklenen bir sonucun true olduğunun kabul edilmesi gerektiği zaman kullanılır.
Parametre olarak iki değer alır.
 İlk parametre de bir mesaj gönderilir ikinci parametrede ise gönderilen mesajın doğruluğu için koşul belirlenir.
3. assertFalse
assertFalse, beklenen bir sonucun false olması durumunda kullanılır.
 İki parametre alır. Parametrelerden biri mesajdır diğeri ise koşuldur.
  assertFalse ile koşul yerine getirilmez ise assertionError hatası fırlatır.
4.assertNull
assertNull, beklenen bir sonucun null olup olmadığı kontrol edilmesi için kullanılır.
Bir nesneyi parametre olarak alır ve nesne null değil ise assertionError hatası fırlatır.
5.assertNotNull
assertNotNull, beklenen bir sonucun null olmadığını doğrulamak için kullanılır.
 Bir nesneyi parametre olarak alır ve nesne null ise assertionError hatası fırlatır.
6.assertSame
assertSame, parametre olarak verilen iki nesnenin aynı nesneye karşılık gelip gelmediğini kontrol eder.
 Eğer nesneler aynı nesneyi karşılamıyor ise assertionError hatası fırlatır.
7.assertNotSame
assertNotSame, parametre olarak verilen iki nesnenin birbirine eşit olmadığı kontrolünü eder.
Eğer aynı nesneye karşılık geliyor ise assertionError hatası fırlatır.
8.assertArrayEquals
assertArrayEquals, parametre olarak verilen iki dizinin eşit olup olmadığını kontrol eder.
 Her iki dizi içinde null değeri var ise bunlar eşit olarak kabul edilir. Eğer eşit değil ise assertionError hatası fırlatır.
*/

}
