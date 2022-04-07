package main.java.com.HeadFirst.chapter_15.BankAccount;

class BankAccount {
    private int balance = 100;

    public int getBalance() {
        return balance;
    }

    public void withdraw(int amount) {
        balance = balance - amount;
    }
}

class RyanAndMonicaJob implements Runnable {
    private BankAccount account = new BankAccount();

    public static void main(String[] args) {
        Runnable job = new RyanAndMonicaJob();
        Thread one = new Thread(job);
        Thread two = new Thread(job);
        one.setName("Райан");
        two.setName("Моника");
        one.start();
        two.start();
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            makeWithdrawal(10);
            if (account.getBalance() < 0) {
                System.out.println("Превышение лимита!");
            }
        }
    }

    private synchronized void makeWithdrawal(int amout) {
        if (account.getBalance() >= amout) {
            System.out.println(Thread.currentThread().getName() + " собирается снять деньги");
            try {
                System.out.println(Thread.currentThread().getName() + " идет подремать");
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " просыпается");
            account.withdraw(amout);
            System.out.println(Thread.currentThread().getName() + " заканчивает транзакцию");

        } else {
            System.out.println("Извините, для клиента " + Thread.currentThread().getName() + " недостаточно денег");
        }
    }
}

