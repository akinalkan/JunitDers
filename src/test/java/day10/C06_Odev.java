package day10;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

public class C06_Odev extends TestBaseBeforeAfter {
    /*
       1- https://www.amazon.com/ adresine gidelim
       2- Sag ust bolumde bulunan “Account & Lists” menusunun
       acilmasi icin mouse’u bu menunun ustune getirelim
       3- “Create a list” butonuna basalim
       4- Acilan sayfada “Your Lists” yazisi oldugunu test edelim
        */
    @Test
    public void test01() {

        //1- https://www.amazon.com/ adresine gidelim
        driver.get("https://www.amazon.com/");

        //2- Sag ust bolumde bulunan “Account & Lists” menusunun
        //       acilmasi icin mouse’u bu menunun ustune getirelim

        WebElement accountList=driver.findElement(By.xpath("//*[@id='nav-link-accountList']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(accountList).perform();
        // 3- “Create a list” butonuna basalim
        driver.findElement(By.xpath("//*[text()='Create a List']")).click();
        //4- Acilan sayfada “Your Lists” yazisi oldugunu test edelim
        WebElement word=driver.findElement(By.xpath("//*[@role='heading']"));
        String actualWord= word.getText();
        String expectedWord="Your Lists";
        Assert.assertTrue("Istenen yazi yok",actualWord.contains(expectedWord));


    }

}
