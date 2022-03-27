package main.java.com.HeadFirst.chapter_10.Player;

public class Player {
    static int playerCount;
    private String name;

    public Player(String name) {
        this.name = name;
        playerCount++;
    }
}
