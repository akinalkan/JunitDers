package day04;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class Odev01 {
    public static void main(String[] args) throws InterruptedException {
        /*
    1-https://the-internet.herokuapp.com/add_remove_elements/ adresine gidin
    2- Add Element butonuna 10 kez basinız
    3- 10 kez Add element butonuna basıldığını test ediniz
    4 - Delete butonuna görünmeyene kadar basınız
    5- Delete butonunun görünmediğini test ediniz
    6- Sayfayı kapatınız
     */
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        // 1-https://the-internet.herokuapp.com/add_remove_elements/ adresine gidin
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");
        //2- Add Element butonuna 10 kez basinız
        WebElement addButon = driver.findElement(By.xpath("//button[ @onclick='addElement()']"));
        for (int i = 1; i <= 10; i++) {
            Thread.sleep(1000);
            addButon.click();
        }
        //3- 10 kez Add element butonuna basıldığını test ediniz
        List<WebElement> list = driver.findElements(By.xpath("//button[@onclick='deleteElement()']"));
        if (list.size() == 10) {
            System.out.println("10 kez add butonuna basilmistir");
        } else {
            System.out.println(list.size() + " kez butona basildi.10 kez add butonuna basilamamistir");
        }

        // 4 - Delete butonuna görünmeyene kadar basınız
        List<WebElement> deleteButtonList = driver.findElements(By.xpath("//*[@onclick='deleteElement()']"));
        for (int i = 0; i < deleteButtonList.size(); i++) {
            Thread.sleep(1000);
            deleteButtonList.get(i).click();
        }
        // 5- Delete butonunun görünmediğini test ediniz
        WebElement expectedResult = driver.findElement(By.className("no-js"));
        String actualResult = expectedResult.getText();
        if (!actualResult.contains("Delete")) {
            System.out.println("Test PASSED");
        } else
            System.out.println("Test FAILED");
        driver.close();


    }
}
