package day11;

import org.junit.Assert;
import org.junit.Test;
import utilities.TestBaseBeforeAfter;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C04_FileExists  {
    // bir web sitesinden indirdiğimiz yada windows içinde oluşturduğumuz dosyanın indiğini yada
    // orda olduğunu test edebilmem için o dosyanın üzerine shift tuşuna basılı olarak sağ click
    // yapıp dosyanın yolunu kopyalayıp bir String değişkene atarız ve dosyayı doğrulamak için
    // Assert.assertTrue(Files.exists(Paths.get(dosyaYolu))); bu methodu kullanirim
    @Test
    public void test1() {
      String dosyaYolu="C:\\Users\\allam\\Desktop\\test.txt";
        System.out.println(Files.exists(Paths.get(dosyaYolu)));//true
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));

    }
}
