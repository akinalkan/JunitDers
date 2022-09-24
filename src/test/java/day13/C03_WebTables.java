package day13;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

public class C03_WebTables extends TestBaseBeforeAfter {
    /*
Bir onceki class'taki adrese gidelim
login() methodunu kullanarak sayfaya giris yapalim
input olarak verilen satir ve sutun sayisina sahip
cell'deki texti yazdiralim.

int satir = 3;
int sutun = 4;

 */

    @Test
    public void name() {
        driver.get("https://www.hotelmycamp.com/admin/HotelRoomAdmin");
        //driver.findElement(By.xpath("//*[@id='UserName']")).click();
        Actions actions = new Actions(driver);
        WebElement userName = driver.findElement(By.xpath("//*[@id='UserName']"));
        actions.click(userName).sendKeys("manager").
                sendKeys(Keys.TAB).sendKeys("Manager1!").sendKeys(Keys.ENTER).perform();


        WebElement tekilHucre = driver.findElement(By.xpath("//tbody//tr[6]//td[4]"));
        System.out.println(tekilHucre.getText());
    }
    /*
    Bir class oluşturun : D18_WebTables
login( ) metodun oluşturun ve oturum açın.
https://qa-environment.concorthotel.com/admin/HotelRoomAdmin adresine gidin
Username : manager  ○ Password : Manager2!
table( ) metodu oluşturun
Tüm table body’sinin boyutunu(sutun sayisi) bulun. /tbody
Table’daki tum body’i ve başlıkları(headers) konsolda yazdırın.
printRows( ) metodu oluşturun //tr
table body’sinde bulunan toplam satir(row) sayısını bulun.
Table body’sinde bulunan satirlari(rows) konsolda yazdırın.
4.satirdaki(row) elementleri konsolda yazdırın.
printCells( ) metodu oluşturun //td
table body’sinde bulunan toplam hücre(cell) sayısını bulun.
Table body’sinde bulunan hücreleri(cells) konsolda yazdırın.
printColumns( ) metodu oluşturun
table body’sinde bulunan toplam sutun(column) sayısını bulun.
Table body’sinde bulunan sutunlari(column) konsolda yazdırın.
5.column daki elementleri konsolda yazdırın.
     */
    /*
    Bir metod oluşturun : printData(int row, int column);
Satır(row) ve sütun(column) numarasını girdiğinizde, printData metodu bu
hücredeki(cell) veriyi yazdırmalıdır.
Baska bir Test metodu oluşturun: printDataTest( );
Ve bu metodu printData( ) methodunu cagirmak icin kullanin.
Örnek: printData (3,5); => 3. satır, 5. Sütundaki veriyi yazdırmalıdır
yazdirilan datanin olmasi gereken dataya esit oldugunu test edin
     */
    /*
    Bir Class olusturun D19_WebtablesHomework
“https://demoqa.com/webtables” sayfasina gidin
Headers da bulunan department isimlerini yazdirin
sutunun basligini yazdirin
Tablodaki tum datalari yazdirin
Tabloda kac cell (data) oldugunu yazdirin
Tablodaki satir sayisini yazdirin
Tablodaki sutun sayisini yazdirin
Tablodaki 3.kolonu yazdirin
Tabloda "First Name" i Kierra olan kisinin Salary'sini yazdirin
Page sayfasinda bir method olusturun, Test sayfasindan satir ve sutun sayisini  girdigimde bana datayi yazdirsin

     */
}
