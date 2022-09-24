package day13;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

import java.util.List;

public class C03_WebTables extends TestBaseBeforeAfter {


    //Price basligindaki tum numaralari yazdiriniz


    @Test
    public void test1() throws InterruptedException {
        //Bir önceki class'daki adrese gidelim
        //Login() methodunu kullanarak sayfaya giriş yapalım
        login();
        int satir = 3;
        int sutun = 4;
        //input olarak verilen satır sayısı ve sutun sayısına sahip cell'deki text'i yazdıralım
        Thread.sleep(3000);
        WebElement cell = driver.findElement(By.xpath("//tbody//tr["+satir+"]//td["+sutun+"]"));
        System.out.println("Satir ve sutundaki text : "+cell.getText());
        //Price basligindaki tum numaralari yazdiriniz
        List<WebElement> price = driver.findElements(By.xpath("//tbody//tr//td[6]"));
        price.forEach(t-> System.out.println(t.getText()));
        /*
        Thead de satır için tr, sutun için th
        Tbody de satır için tr, sütun için td
         */

    }

    private void login() {

        driver.get("https://www.hotelmycamp.com/admin/HotelRoomAdmin");
        //driver.findElement(By.xpath("//*[@id='UserName']")).click();
        Actions actions = new Actions(driver);
        WebElement userName = driver.findElement(By.xpath("//*[@id='UserName']"));
        actions.click(userName).sendKeys("manager").
                sendKeys(Keys.TAB).sendKeys("Manager1!").sendKeys(Keys.ENTER).perform();
    }
     /*
    Tabloda<table> tagı altinda tablonun basligini gösteren <thead> tag'i bulunur.
    Eger baslikta satir(row) varsa <thead> tag'i altinda <tr> (satir-row) tagi vardir.
    Ve basliktaki sutunlara yani hucrelere(cell) de <th> tag' ile ulasilir.
    Basligin altindaki verilere <tbody> tag'i ile altindaki satirlara(row) <tr> tag'i ile
    sutunlara yani hucrelere<td> tag'i ile ulasilir.
     */
}
