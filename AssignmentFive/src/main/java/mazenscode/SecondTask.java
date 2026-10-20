package mazenscode;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class SecondTask {

    private static class Account {

        final String name;
        int balance = 100;
        final ReentrantLock lock = new ReentrantLock();

        Account(String name) { this.name = name; }
    }

    private static void transfer(Account from, Account to, int amount) throws InterruptedException {

        while (true) {

            from.lock.lock();
            try {
                System.out.println("Grabbed " + from.name + " lock");
                TimeUnit.SECONDS.sleep(2);

                if (to.lock.tryLock(1, TimeUnit.SECONDS)) {
                    try {
                        System.out.println("Grabbed " + to.name + " lock");
                        from.balance -= amount;
                        to.balance += amount;
                        System.out.println("Transfer amount " + amount
                                + " from " + from.name + "->" + to.name + " complete");
                        return;
                    } finally {
                        to.lock.unlock();
                    }
                }
                System.out.println("Could not grab " + to.name + " lock, backing off");
            } finally {
                from.lock.unlock();
            }

            // Random pause AFTER releasing the first lock, so the other thread can proceed.
            TimeUnit.MILLISECONDS.sleep(ThreadLocalRandom.current().nextInt(50, 500));
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Account a = new Account("A");
        Account b = new Account("B");

        Thread t1 = new Thread(
                () -> {
                    try {
                        transfer(a,b,10);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        throw new RuntimeException(e);
                    }
                }
        );


        Thread t2 = new Thread(
                () -> {
                    try {
                        transfer(b,a,3);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        throw new RuntimeException(e);
                    }
                }
        );

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Done. A = " + a.balance + " B = " + b.balance);
    }
}

