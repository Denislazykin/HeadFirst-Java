package main.java.com.HeadFirst.chapter_15.TestSync;

class TestSync implements Runnable {
    private int balance;

    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            increment();
            System.out.println("Баланс равен " + balance + ". Поток - " + Thread.currentThread().getName());

        }
    }

    public synchronized void increment() {
        int i = balance;
        balance = i + 1;
    }
}

class TestSyncTest {
    public static void main(String[] args) {
        TestSync job = new TestSync();
        Thread a = new Thread(job);
        Thread b = new Thread(job);
        a.setName("A");
        b.setName("B");
        a.start();
        b.start();
    }
}
