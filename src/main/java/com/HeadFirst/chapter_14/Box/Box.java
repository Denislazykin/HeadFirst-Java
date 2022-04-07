package main.java.com.HeadFirst.chapter_14.Box;

import java.io.*;

public class Box implements Serializable {
    private int weight;
    private int height;

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public static void main(String[] args) {
        Box myBox = new Box();
        myBox.setWeight(50);
        myBox.setHeight(20);
        try {
            /*
             * Cоздаём объект FileOutputStream
             */
            FileOutputStream fileOutputStream = new FileOutputStream("foo.ser");
            /*
             * Cоздаём объект ObjectOutputStream
             */
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            /*
             * Записываем объект
             */
            objectOutputStream.writeObject(myBox);
            /*
             * Записываем objectOutputStream
             */
            objectOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
