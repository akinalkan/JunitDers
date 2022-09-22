package day12;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBaseBeforeAfter;

import java.time.Duration;

public class C03_SenkronizasyonWait extends TestBaseBeforeAfter {
    // 1. Bir class olusturun : WaitTest
    // 2. Iki tane metod olusturun : implicitWait() , explicitWait()
    //    Iki metod icin de asagidaki adimlari test edin.
    // 3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
    // 4. Remove butonuna basin.
    // 5. "It's gone!" mesajinin goruntulendigini dogrulayin.
    // 6. Add buttonuna basin
    // 7. It's back mesajinin gorundugunu test edin

    @Test
    public void implicitlyWaitTest1() {
        //https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        //Remove butonuna basin.
        driver.findElement(By.xpath("//*[text()='Remove']")).click();
        //“It’s gone!” mesajinin goruntulendigini dogrulayin.
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()=\"It's gone!\"]")).isDisplayed());
        //Add buttonuna basin
        driver.findElement(By.xpath("//*[text()='Add']")).click();
        //It’s back mesajinin gorundugunu test edin
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='message']")).isDisplayed());
    }

    @Test
    public void explicitlyWaitTest2() {
        //https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        //Remove butonuna basin.
        driver.findElement(By.xpath("//*[text()='Remove']")).click();
        //“It’s gone!” mesajinin goruntulendigini dogrulayin.
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement mesaj=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='message']")));
        Assert.assertTrue(mesaj.isDisplayed());
        //Add buttonuna basin
        driver.findElement(By.xpath("//*[text()='Add']")).click();
        //It’s back mesajinin gorundugunu test edin
        WebElement backMesaj=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()=\"It's back!\"]")));
        Assert.assertTrue(backMesaj.isDisplayed());
    }
    //implicitly wait testten once calsitirilir ve calistirilan testin tamamina etki eder
    //explicitly wait ise once obje olarak olusturulur sonra
    // sadece kullanildigi yerde ve belirlenen sarta gore calisir class yada test in tamamina uygulanmaz
        /*
            explicitWait itsgoneWE görünür olmasını beklerken o web elementinin locatini kullanarak assert yapmak
        sorun olur ve exeption fırlatır. Henüz görülmeyen bir Webelementin locate edilmeside otamasyon için
        mümkün olmaz. Bu durumda bekleme işlemi için explicitWait'i locate ile birlikte kullanırız
         */

}
