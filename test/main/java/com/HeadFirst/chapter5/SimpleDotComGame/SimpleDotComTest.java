package main.java.com.HeadFirst.chapter5.SimpleDotComGame;

public class SimpleDotComTest {
    public static void main(String[] args) {
        SimpleDotCom dot = new SimpleDotCom();
        int[] locations = new int[]{2, 3, 4};
        dot.setLocationCells(locations);
        String userGuess = "1";
        String result = dot.checkYourself(userGuess);
    }
}