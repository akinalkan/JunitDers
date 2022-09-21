package day11;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

public class C03_Faker extends TestBaseBeforeAfter {
         // faker class'i kullanmak icin mvn repository.com adresinden java faker kütüphanesinin aratir
         // ve en cok kullanilani pom.xml dosyamiza ekleriz
         // ve faker class'indan bir obje olusturup email icin faker.internet methodunu kullanarak
         // emailAdress() methodunu seceriz
         // password icinde ayni internet methodunu kullaniriz
         // isim ve soyisimler icin faker.name() methodu ile firstname() ve lastname() methodunu kullaniriz
         // faker claas'ini kullanma amacimiz form dordurmamiz gereken sitelerde defalarca kendi üretecegimiz
         // veriler yerine bizim icin random veriler üretir ve isimizi kolaylastirir

        /*
        1. "https://facebook.com" Adresine gidin
        2. “create new account” butonuna basin
        3. “firstName” giris kutusuna bir isim yazin
        4. “surname” giris kutusuna bir soyisim yazin
        5. “email” giris kutusuna bir email yazin
        6. “email” onay kutusuna emaili tekrar yazin
        7.  Bir sifre girin
        8. Tarih icin gun secin
        9. Tarih icin ay secin
        10. Tarih icin yil secin
        11. Cinsiyeti secin
        12. Isaretlediginiz cinsiyetin secili, diger cinsiyet kutusunun secili olmadigini test edin.
        13. Sayfayi kapatin
         */

    @Test
    public void test1() {

        //1- https://www.facebook.com adresine gidelim
        driver.get("https://www.facebook.com");
        //2. “create new account” butonuna basin
        WebElement button=driver.findElement(By.xpath("(//*[@role='button'])[2]"));
        Actions actions=new Actions(driver);
        actions.click(button).perform();
        // 3. “firstName” giris kutusuna bir isim yazin
        Faker faker= new Faker();
        WebElement isim = driver.findElement(By.xpath("//input[@name='firstname']"));
        String email=faker.internet().emailAddress();
        actions.click(isim).sendKeys(faker.funnyName().name())
                .sendKeys(Keys.TAB).sendKeys(faker.funnyName().name()).sendKeys(Keys.TAB).
                sendKeys(email).sendKeys(Keys.TAB).
                sendKeys(email).sendKeys(Keys.TAB).
                sendKeys(faker.internet().password()).sendKeys(Keys.TAB).sendKeys(Keys.TAB).
                sendKeys("1").sendKeys(Keys.TAB).
                sendKeys("Jan").sendKeys(Keys.TAB).
                sendKeys("2001").sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys(Keys.RIGHT).
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys(Keys.ENTER).perform();
    }
}
