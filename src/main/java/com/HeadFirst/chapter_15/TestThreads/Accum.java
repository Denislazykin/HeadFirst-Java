package main.java.com.HeadFirst.chapter_15.TestThreads;

public class Accum {
    private static Accum a = new Accum(); // так как экземпляр статический, он один на весь класс
    private int counter = 0;

    /*
     * Что бы никто не смог создать экземпляр класса
     * сделаем конструктор приватным
     */
    private Accum() {
    }

    /*
     * Статический геттер + приватный конструктор = Singleton
     */
    public static Accum getAccum() {
        return a;
    }

    public int getCount() {
        return counter;
    }

    public void updateCounter(int add) {
        counter += add;
    }
}
