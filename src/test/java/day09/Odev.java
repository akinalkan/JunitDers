package day09;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Odev {
    /*
      Ödev:
    ●Bir class olusturun:IframeTest02
    1)http://demo.guru99.com/test/guru99home/sitesinegidiniz
    2)sayfadaki iframe sayısınıbulunuz.
    3)ilk iframe’deki (Youtube) play butonuna tıklayınız.
    4)ilk iframe’den çıkıp ana sayfaya dönünüz
    5)ikinci iframe’deki (Jmeter Made Easy) linke(https://www.guru99.com/live-selenium-project.html)
    tıklayınız
     */
    WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void teardown() {
        //driver.quit();
    }
    @Test
    public void test01() throws InterruptedException {
        // 1) http://demo.guru99.com/test/guru99home/ sitesine gidiniz
        driver.get("http://demo.guru99.com/test/guru99home/");
        // 2)sayfadaki iframe sayısınıbulunuz.
        List<WebElement>frameList=new ArrayList<>(driver.findElements(By.xpath("//iframe")));
        Thread.sleep(3000);
        System.out.println(frameList.size());
        // 3)ilk iframe’deki (Youtube) play butonuna tıklayınız.
        driver.switchTo().frame(frameList.get(0));
        driver.findElement(By.xpath("//*[@aria-label='Play']")).click();
        //4)ilk iframe’den çıkıp ana sayfaya dönünüz
        driver.switchTo().defaultContent();
        //5)ikinci iframe’deki (Jmeter Made Easy) linke(https://www.guru99.com/live-selenium-project.html)  tıklayınız
        WebElement ikinciFrame= driver.findElement(By.className("a077aa5e"));
        driver.switchTo().frame(ikinciFrame);
        driver.findElement(By.className("a077aa5e")).click();


    }

}
