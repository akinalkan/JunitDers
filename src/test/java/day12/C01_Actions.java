package day12;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

public class C01_Actions extends TestBaseBeforeAfter {
    @Test
    public void test1() throws InterruptedException {
        //Automationexercise.com sitesine gidelim
        driver.get("https://automationexercise.com/");
        //product bolumune gidelim
        driver.findElement(By.cssSelector("a[href=\"/products\"]")).click();
        //ilk urunu secelim
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@class='fa fa-plus-square']")).click();
    }

}
