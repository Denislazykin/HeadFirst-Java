package main.java.com.HeadFirst.chapter_15.RunThreads;

public class RunThreads implements Runnable {
    public static void main(String[] args) {
        RunThreads runner = new RunThreads();
        Thread alpha = new Thread(runner);
        Thread beta = new Thread(runner);
        alpha.setName("Поток Альфа");
        beta.setName("Поток Бета");
        alpha.start();
        beta.start();
    }

    @Override
    public void run() {
        for (int i = 0; i < 25; i++) {
            System.out.println("Сейчас работатет поток " + Thread.currentThread().getName());
        }
    }
}
