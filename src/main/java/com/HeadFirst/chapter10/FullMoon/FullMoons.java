package main.java.com.HeadFirst.chapter10.FullMoon;

import java.util.Calendar;

public class FullMoons {
    static int DAY_IM = 1000 * 60 *60 * 24; //количество милисекунд в сутках

    public static void main(String[] args) {
        Calendar c = Calendar.getInstance(); //получим экземпляр календаря
        c.set(2020,0,1,15,40); // установим значение
        long day1 = c.getTimeInMillis(); // получим его в милисекундах
        for (int x = 0; x < 60; x++) {
            day1 += (DAY_IM * 29.52);
            c.setTimeInMillis(day1);
            System.out.println(String.format("Полнолуние было в %tc", c));
        }
    }
}
