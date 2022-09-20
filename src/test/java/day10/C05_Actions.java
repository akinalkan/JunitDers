package day10;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

import javax.swing.*;

public class C05_Actions extends TestBaseBeforeAfter {
    @Test
    public void test1() throws InterruptedException {
        /*

        1- https://demoqa.com/droppable adresine gidelim
        2- “Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim
        3- “Drop here” yazisi yerine “Dropped!” oldugunu test edin
         */
        //1- https://demoqa.com/droppable adresine gidelim
        driver.get("https://demoqa.com/droppable");
        // 2- “Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim
         WebElement dragMe=driver.findElement(By.xpath("//*[@id='draggable']"));
         WebElement dropHere=driver.findElement(By.xpath("(//*[@id='droppable'])[1]"));
         Thread.sleep(3000);
        Actions action= new Actions(driver);
        action.dragAndDrop(dragMe,dropHere).perform();
        // 3- “Drop here” yazisi yerine “Dropped!” oldugunu test edin
       WebElement dropped=driver.findElement(By.xpath("//*[text()='Dropped!']"));
        WebElement dropHere1=driver.findElement(By.xpath("(//*[text()='Drop here'])[1]"));
        Assert.assertTrue(dropped.isDisplayed());
        Assert.assertFalse(dropHere1.isDisplayed());




    }
}
