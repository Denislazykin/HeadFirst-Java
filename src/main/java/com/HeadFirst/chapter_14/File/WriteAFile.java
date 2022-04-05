package main.java.com.HeadFirst.chapter_14.File;

import java.io.FileWriter;
import java.io.IOException;

public class WriteAFile {
    public static void main(String[] args) {
        try {
            /*
             * Создаем объект в который будем, что то записывать
             */
            FileWriter writer = new FileWriter("Foo.txt");
            /*
             * Что то записываем
             */
            writer.write("Hello Foo");
            /*
             * Останавливаем запись
             */
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
