package day10;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class C04_Actions extends TestBaseBeforeAfter {
    /*
    1- Yeni bir class olusturalim: MouseActions1
    2- https://the-internet.herokuapp.com/context_menu sitesine gidelim
    3- Cizili alan uzerinde sag click yapalim
    4- Alert’te cikan yazinin “You selected a context menu” oldugunu
    test edelim.
    5- Tamam diyerek alert’i kapatalim
    6- Elemental Selenium linkine tiklayalim
    7- Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim
     */
    @Test
    public void test1() {
        // 2- https://the-internet.herokuapp.com/context_menu sitesine gidelim
        driver.get("https://the-internet.herokuapp.com/context_menu");

        // 3- Cizili alan uzerinde sag click yapalim
        WebElement cizgiliAlan = driver.findElement(By.id("hot-spot"));
        Actions actions = new Actions(driver);
        actions.contextClick(cizgiliAlan).perform();
        driver.switchTo().alert().accept();
        //4- Alert’te cikan yazinin “You selected a context menu” oldugunu test edelim.
        actions.contextClick(cizgiliAlan).perform();
        String expectedAlert = "You selected a context menu";
        String alertStr = driver.switchTo().alert().getText();
        Assert.assertTrue(alertStr.contains(expectedAlert));
        // 5- Tamam diyerek alert’i kapatalim
        driver.switchTo().alert().accept();
        //6- Elemental Selenium linkine tiklayalim
        driver.switchTo().defaultContent();
        driver.findElement(By.xpath("//*[text()='Elemental Selenium']")).click();

        List<String> windowList = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(windowList.get(1));

        //7- Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim
        String actualWord = driver.findElement(By.xpath("//*[text()='Elemental Selenium']")).getText();
        String expectedWord = "Elemental Selenium";
        Assert.assertEquals(actualWord, expectedWord);
        driver.quit();

    }

}
