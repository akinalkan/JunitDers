package SeleniumPractice;

import java.util.Arrays;
import java.util.Comparator;

public class KonuDisi {
    public static void main(String[] args) {
        String isim="Akin Alkan";
        Arrays.stream(isim.split("")).forEach(System.out::print);
    }
}
