package main.java.com.HeadFirst.chapter_5.SimpleDotComGame;

public class SimpleDotCom {
    int[] locationCells;
    int numOfHits = 0;

    public void setLocationCells(int[] locs) {
        locationCells = locs;
    }

    public String checkYourself(String stringGuess) {
        int guess = Integer.parseInt(stringGuess);
        String result = "МИМО";
        for (int cell : locationCells) {
            if (guess == cell) {
                result = "ПОПАЛ";
                numOfHits++;
                break;
            }
        }
        if (numOfHits == locationCells.length) {
            result = "УБИЛ";
        }
        System.out.println(result);
        return result;
    }
}
