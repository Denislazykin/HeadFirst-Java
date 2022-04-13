package main.java.com.HeadFirst.chapter_10.FullMoon;

import java.util.Calendar;

public class FullMoons {
    /*
     * количество милисекунд в сутках
     */
    static int DAY_IM = 1000 * 60 * 60 * 24;

    public static void main(String[] args) {
        /*
         * получим экземпляр календаря
         */
        Calendar c = Calendar.getInstance();
        /*
         * установим значение
         */
        c.set(2020, 0, 1, 15, 40);
        /*
         * получим его в милисекундах
         */
        long day1 = c.getTimeInMillis();
        for (int x = 0; x < 60; x++) {
            day1 += (DAY_IM * 29.52);
            c.setTimeInMillis(day1);
            System.out.println(String.format("Полнолуние было в %tc", c));
        }
    }
}
