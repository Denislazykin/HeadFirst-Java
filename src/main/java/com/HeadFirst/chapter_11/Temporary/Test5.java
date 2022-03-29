package main.java.com.HeadFirst.chapter_11.Temporary;

import java.io.*;

public class Test5 {
    public static void main(String[] args) {
        File f = new File("test.txt");
        try {
            FileInputStream fis = new FileInputStream(f);
            System.out.println("Have a good day");
        } catch (FileNotFoundException e) {
            System.out.println("We throw exception :" + e);
        } finally {
            System.out.println("This is a finaly block");
        }
        System.out.println("Etot kod ne imeet otnosheniya k isklucheniam ");
    }
}
