package day08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_IFrame {
    WebDriver driver;
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @After
    public void tearDown(){
        //  driver.close();
    }
    @Test
    public void test1(){
        /*
        IFrame, bir web sayfasına icine yerlestirilmis baska
        bir web sayfasıdır veya bir HTML dokumaninin içine
        yerleştirilmiş baska bir HTML dokumanidir.
         */
        //https://html.com/tags/iframe/ adresine gidelim ve youtube videosuna tiklayalim
        driver.get("https://html.com/tags/iframe/");
        WebElement youtubeFrame=driver.findElement(By.xpath("//*[@src='https://www.youtube.com/embed/owsfdh4gxyc']"));
        driver.switchTo().frame(youtubeFrame)
                .findElement(By.xpath("//*[@class='ytp-large-play-button ytp-button ytp-large-play-button-red-bg']")).click();


    }
}
