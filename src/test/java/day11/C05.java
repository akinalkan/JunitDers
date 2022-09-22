package day11;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBaseBeforeAfter;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class C05 extends TestBaseBeforeAfter {
    /*
    1. Tests packagenin altina bir class oluşturalim : C04_FileDownload
    2. https://the-internet.herokuapp.com/download adresine gidelim.
    3. code.txt dosyasını indirelim
    4. Dosyanın başarıyla indirilip indirilmediğini test edelim
     */

    @Test
    public void test1() throws InterruptedException {
        //2. https://the-internet.herokuapp.com/download adresine gidelim.
        driver.get("https://the-internet.herokuapp.com/download");
        //3. code.txt dosyasını indirelim
        driver.findElement(By.xpath("//*[text()='Test.txt']")).click();
        String dosyaYolu="E:\\Belgelerim\\İndirilenler\\Test.txt";
        Thread.sleep(5000);
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));

    }
}
