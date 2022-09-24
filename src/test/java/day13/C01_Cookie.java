package day13;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;

import java.util.List;
import java.util.Set;

public class C01_Cookie extends TestBaseBeforeAfter {
    /*
    1-Amazon anasayfaya gidin
    2-tum cookie’leri listeleyin
    3-Sayfadaki cookies sayisinin 5’den buyuk oldugunu test edin
    4-ismi i18n-prefs olan cookie degerinin USD oldugunu test edin
    5-ismi “en sevdigim cookie” ve degeri “cikolatali” olan bir cookie  olusturun ve sayfaya ekleyin
    6-eklediginiz cookie’nin sayfaya eklendigini test edin
    7-ismi skin olan cookie’yi silin ve silindigini test edin
    8-tum cookie’leri silin ve silindigini test edin
     */

    @Test
    public void test1() {
        //1-Amazon anasayfaya gidin
        driver.get("https://www.amazon.com");
        //2-tum cookie’leri listeleyin
        Set<Cookie> cookiesSet=driver.manage().getCookies();
        int sayac=1;
        for (Cookie each:cookiesSet) {
            System.out.println(sayac+". cookie : "+each.getName()+"-->"+each.getValue());
            sayac++;
        }
        //3-Sayfadaki cookies sayisinin 5’den buyuk oldugunu test edin
        Assert.assertTrue(cookiesSet.size()>5);
        System.out.println(cookiesSet.size());
        //4-ismi i18n-prefs olan cookie degerinin USD oldugunu test edin
        for (Cookie each:cookiesSet) {
            if (each.getName().equals("i18n-prefs")){
                Assert.assertTrue(each.getValue().equals("USD"));
            }
        }
        // 5-ismi “en sevdigim cookie” ve degeri “cikolatali” olan bir cookie  olusturun ve sayfaya ekleyin
        Cookie Cookie= new Cookie("en sevdigim cookie","cikolatali");
        cookiesSet.add(Cookie );
        for (Cookie each:cookiesSet) {
            System.out.println(each.getName()+"-->"+each.getValue());
            if (each.getName().equals("en sevdigim cookie")){
                Assert.assertTrue(each.getValue().equals("cikolatali"));
            }
        }
        //7-ismi skin olan cookie’yi silin ve silindigini test edin
        driver.manage().deleteCookieNamed("skin");
        cookiesSet = driver.manage().getCookies();
        sayac = 1;
        for (Cookie w:cookiesSet) {
            System.out.println(sayac+". cookie : "+w);
            System.out.println(sayac+". name : "+w.getName());
            System.out.println(sayac+". value : "+w.getValue());
            sayac++;
        }
        Assert.assertFalse(cookiesSet.contains("skin"));
        //8-tum cookie’leri silin ve silindigini test edin
        driver.manage().deleteAllCookies();
        cookiesSet = driver.manage().getCookies();
        Assert.assertTrue(cookiesSet.isEmpty());
        System.out.println("cookiesSet = " + cookiesSet);
    }
}
