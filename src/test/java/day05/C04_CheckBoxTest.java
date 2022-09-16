package day05;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_CheckBoxTest {
    /*
    1. Bir class oluşturun : CheckBoxTest
    2. Gerekli yapiyi olusturun ve aşağıdaki görevi tamamlayın.
    a. Verilen web sayfasına gidin.
    https://the-internet.herokuapp.com/checkboxes
    b. Checkbox1 ve checkbox2 elementlerini locate edin.
    c. Checkbox1 seçili değilse onay kutusunu tıklayın
    d. Checkbox2 seçili değilse onay kutusunu tıklayın
   */
    WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @Test
    public void method() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        WebElement chck1=driver.findElement(By.xpath("//*[@type='checkbox'][1]"));
        WebElement chck2=driver.findElement(By.xpath("//*[@type='checkbox'][2]"));
        Thread.sleep(3000);
      if(!chck1.isSelected()){
          chck1.click();
          Thread.sleep(3000);
      }
        if(!chck2.isSelected()){
            chck2.click();
            Thread.sleep(3000);
        }
    }
    @After
    public void teardown(){
        driver.close();
    }
}
