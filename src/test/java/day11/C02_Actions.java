package day11;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

public class C02_Actions extends TestBaseBeforeAfter {
     /*
     Yeni bir class olusturalim: D15_MouseActions4
     1- https://www.facebook.com adresine gidelim
     2- Yeni hesap olustur butonuna basalim
     3- Ad, soyad, mail ve sifre kutularina deger yazalim ve kaydol tusuna basalim
     4- Kaydol tusuna basalim
      */

    @Test
    public void test1() {
        //1- https://www.facebook.com adresine gidelim
        driver.get("https://www.facebook.com");
        //2- Yeni hesap olustur butonuna basalim
        WebElement button=driver.findElement(By.xpath("(//*[@role='button'])[2]"));
        Actions actions=new Actions(driver);
        actions.click(button).perform();
        // 3- Ad, soyad, mail ve sifre kutularina deger yazalim ve kaydol tusuna basalim
        WebElement isim = driver.findElement(By.xpath("//input[@name='firstname']"));
        isim.sendKeys("Akin");
        actions.sendKeys(Keys.TAB)
                .sendKeys("Alkan").sendKeys(Keys.TAB).
                sendKeys("zoomzoomcu@gmail.com").sendKeys(Keys.TAB).
                sendKeys("zoomzoomcu@gmail.com").sendKeys(Keys.TAB).
                sendKeys("zoomzoomcu7876").sendKeys(Keys.TAB).sendKeys(Keys.TAB).
                sendKeys("1").sendKeys(Keys.TAB).
                sendKeys("Jan").sendKeys(Keys.TAB).
                sendKeys("2001").sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys(Keys.RIGHT).
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys(Keys.ENTER).perform();


    }
}
