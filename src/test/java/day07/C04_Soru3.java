package day07;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class C04_Soru3 {
    /*
    1. http://zero.webappsecurity.com/ Adresine gidin
    2. Sign in butonuna basin
    3. Login kutusuna “username” yazin
    4. Password kutusuna “password.” yazin
    5. Sign in tusuna basin
    6. Pay Bills sayfasina gidin
    7. “Purchase Foreign Currency” tusuna basin
    8. “Currency” drop down menusunden Eurozone’u secin
    9. “amount” kutusuna bir sayi girin
    10. “US Dollars” in secilmedigini test edin
    11. “Selected currency” butonunu secin
    12. “Calculate Costs” butonuna basin sonra “purchase” butonuna basin
    13. “Foreign currency cash was successfully purchased.” yazisinin ciktigini kontrol edin.
     */

    WebDriver driver;
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //1. http://zero.webappsecurity.com/ Adresine gidin
        driver.get("http://zero.webappsecurity.com/");;
    }
    @After
    public void tearDown(){
        //driver.close();
    }
    @Test
    public void test1() throws InterruptedException {
        //2. Sign in butonuna basin
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@class='signin btn btn-info']")).click();
        //3. Login kutusuna “username” yazin
        driver.findElement(By.xpath("//*[@name='user_login']")).sendKeys("username");
        //4. Password kutusuna “password.” yazin
        driver.findElement(By.xpath("//*[@type='password']")).sendKeys("password");
        //5. Sign in tusuna basin
        driver.findElement(By.xpath("//*[@value='Sign in']")).click();
        driver.get( "http://zero.webappsecurity.com/");
        // 6. Pay Bills sayfasina gidin
        driver.findElement(By.xpath("//*[@name='searchTerm']")).sendKeys("Pay Bills"+Keys.ENTER);
        driver.findElement(By.xpath("//*[text()='Zero - Pay Bills']")).click();
        //7. “Purchase Foreign Currency” tusuna basin
        driver.findElement(By.xpath("//*[text()='Purchase Foreign Currency']")).click();
        //8. “Currency” drop down menusunden Eurozone’u secin
        WebElement menu=driver.findElement(By.xpath("//*[@id='pc_currency']"));
        Select select= new Select(menu);
        select.selectByVisibleText("Eurozone (euro)");
        //9. “amount” kutusuna bir sayi girin
        driver.findElement(By.xpath("//*[@id='pc_amount']")).sendKeys("10");
        //10. “US Dollars” in secilmedigini test edin
        WebElement dolar=driver.findElement(By.xpath("(//*[@class='radio inline'])[2]"));
        Assert.assertFalse(dolar.isSelected());
        // 11. “Selected currency” butonunu secin
        driver.findElement(By.xpath("(//*[@name='inDollars'])[2]")).click();
        //12. “Calculate Costs” butonuna basin sonra “purchase” butonuna basin
        driver.findElement(By.xpath("//*[@class='btn pull-right']")).click();
        driver.findElement(By.xpath("(//*[@type='submit'])[2]")).click();
        // 13. “Foreign currency cash was successfully purchased.” yazisinin ciktigini kontrol edin.
        WebElement yazi=driver.findElement(By.xpath("//*[text()='Foreign currency cash was successfully purchased.']"));
        Assert.assertTrue(yazi.isDisplayed());






    }


}
