package main.java.com.HeadFirst.chapter10.Formats;

import java.util.Date;

public class TestFormats {
    public static void main(String[] args) {
        String s = String.format("%,d", 1000000000);
        String a = String.format("%,d", 1000000000);
        String b = String.format("Мне нужно исправить %,.2f, ошибки", 476578.09876);
        System.out.println(s);
        System.out.println();
        System.out.println(a);
        System.out.println();
        System.out.println(b);
        System.out.println();

        int one = 20456654;
        double two = 100567890.248907;
        String q = String.format("Уровень %,d из %,.2f", one, two);
        System.out.println(q);
        System.out.println();

        System.out.println(String.format("%tc" , new Date()));
        System.out.println();
        System.out.println(String.format("%tr" , new Date()));
        System.out.println();
        Date toDay = new Date();
        System.out.println(String.format("%tA, %tB %td", toDay, toDay, toDay));
        System.out.println();
        System.out.println(String.format("%tA, %<tB %<td", toDay));

    }
}
