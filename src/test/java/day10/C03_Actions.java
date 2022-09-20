package day10;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

import javax.swing.*;

public class C03_Actions extends TestBaseBeforeAfter {
    @Test
    public void test1(){
        // 1 Amazon sayfasina gidelim
        //2 Account menusunden create a list linkine tiklayalim
        driver.get("https://www.amazon.com");
        Actions action= new Actions(driver);
       WebElement accountLink=driver.findElement(By.xpath("//*[@class='nav-line-2 ']"));
       action.moveToElement(accountLink).perform();
       driver.findElement(By.xpath("//*[text()='Create a List']")).click();
       /*
        Bir web sitesinde bir mouse ile açılan bir web elementine ulaşmak istersek
        actions.moveToElement() methodunu kullanmamız gerekir. Aksi takdirde
        html kodları arasında web elementi bulur ama ulaşamadığı için
        ElementNotInteractableException: element not interactable exception'ı fırlatır
         */
    }

}
