package main.java.com.HeadFirst.chapter_14.DangeonGame;

import java.io.*;

public class DungeonGame implements Serializable {
    public int x = 3;
    transient long y = 4;
    private short z = 5;

    public int getX() {
        return x;
    }

    public long getY() {
        return y;
    }

    public short getZ() {
        return z;
    }
}

class DungeonGameTest {
    public static void main(String[] args) {
        DungeonGame d = new DungeonGame(); // создали объект
        System.out.println(d.getX() + d.getY() + d.getZ()); // вывод значений (3 + 4 + 5 = 12), но 4 не записывается
        try {
            FileOutputStream fos = new FileOutputStream("dg.ser"); // соединились с файлом вывода
            ObjectOutputStream oos = new ObjectOutputStream(fos); // создали цепочку потока вывода
            oos.writeObject(d); // записали объект в поток
            oos.close(); // закрыли поток
            FileInputStream fis = new FileInputStream("dg.ser"); // соединились с файлом ввода
            ObjectInputStream ois = new ObjectInputStream(fis); // создали цепочку потока ввода
            d = (DungeonGame) ois.readObject(); // прочитали обект из потока ввода и привели его к виду класса
            ois.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(d.getX() + d.getY() + d.getZ()); // вывод значениq (3 + 5 = 8). 4 не (де)сериализуется
    }
}


