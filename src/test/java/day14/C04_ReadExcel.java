package day14;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class C04_ReadExcel {
    @Test
    public void readExcelTest1() throws IOException {
        //-Dosya yolunu bir String degiskene atayalim
        String dosyaYolu="src/resources/ulkeler.xlsx";
        //-FileInputStream objesi olusturup,
        // parametre olarak dosya yolunu girelim
        FileInputStream fis= new FileInputStream(dosyaYolu);
        //-Workbook objesi olusturalim,
        // parameter olarak fileInputStream objesini girelim
        //-WorkbookFactory.create(fileInputStream)
        Workbook workbook= WorkbookFactory.create(fis);
        //-Turkce baskentler sutununu yazdiralim
        int sonSatir=workbook.getSheet("Sayfa1").getLastRowNum();
        System.out.println("sonSatir = " + sonSatir);//190
        String baskentler;
        for (int i = 1; i <= sonSatir; i++) {
            baskentler=workbook.getSheet("Sayfa1").getRow(i).getCell(3).toString();
            System.out.println(baskentler);
        }
        List<String> list=new ArrayList<>();
        for (int i = 0; i <=sonSatir ; i++) {
            list.add(workbook.getSheet("Sayfa1").getRow(i).getCell(3).toString());
        }
        list.forEach(t-> System.out.println(t));




    }
}
