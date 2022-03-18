package main.java.com.HeadFirst.chapter_2.GuessGame;

public class Player {
    int number;
/*
Медод для извлечения ответов игроков
 */
    public void guess() {
        number = (int) (Math.random() * 10);
        System.out.println("Думаю, это число " + number);
    }
}
