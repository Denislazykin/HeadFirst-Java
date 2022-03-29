package main.java.com.HeadFirst.chapter_11.File;

import java.io.*;

public class Test {
    public static void main(String[] args) throws Exception{
        File  f = new File("test.txt");
        FileInputStream fis = new FileInputStream(f);
        fis.read();
        FileOutputStream fos = new FileOutputStream(f);
        fos.write(100);

    }
}
