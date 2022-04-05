package main.java.com.HeadFirst.chapter_14.GameSaver;

import java.io.*;

public class GameSaverTest {
    public static void main(String[] args) {
        GameCharacter one = new GameCharacter(50, "Elf", new String[]{"лук","меч","кастет"});
        GameCharacter two = new GameCharacter(210, "Troll", new String[]{"голые руки","большой топор"});
        GameCharacter three = new GameCharacter(120, "Mag", new String[]{"заклинания","невидимость"});
        /*
         * Сериализация
         */
        try {
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("Game.scr"));
            os.writeObject(one);
            os.writeObject(two);
            os.writeObject(three);
            os.close();
        } catch (IOException ex){
            ex.printStackTrace();
        }
        one = null;
        two = null;
        three = null;
        /*
         * Десериализация
         */
        try {
            ObjectInputStream is = new ObjectInputStream(new FileInputStream("Game.scr"));
            GameCharacter oneRestore = (GameCharacter) is.readObject();
            GameCharacter twoRestore = (GameCharacter) is.readObject();
            GameCharacter threeRestore = (GameCharacter) is.readObject();
            System.out.println("Тип первого " + oneRestore.getType());
            System.out.println("Тип второго " + twoRestore.getType());
            System.out.println("Тип третьго " + threeRestore.getType());
            is.close();
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
