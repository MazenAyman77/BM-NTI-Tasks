package mazenscode;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class FirstTask {

    private static final AtomicInteger NEXT_ID = new AtomicInteger();

    private static class Account {

        final int id = NEXT_ID.getAndIncrement(); // unique id
        final String name;
        int balance = 100;
        final ReentrantLock lock = new ReentrantLock();

        Account(String name) { this.name = name; }
    }

    private static void transfer(Account from, Account to, int amount) {

        // Pick the account with the smaller id as the one to lock first.
        Account first = from.id < to.id ? from : to;
        Account second = (first == from) ? to : from;

        first.lock.lock();
        try {
            System.out.println("Grabbed " + first.name + " lock");
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }

            second.lock.lock();
            try {
                System.out.println("Grabbed " + second.name + " lock");
                from.balance -= amount;
                to.balance += amount;
                System.out.println("Transfer amount " + amount
                        + " from " + from.name + "->" + to.name + " complete");
            } finally {
                second.lock.unlock();
            }
        } finally {
            first.lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {

        Account a = new Account("A");
        Account b = new Account("B");

        Thread t1 = new Thread(() -> transfer(a, b, 10));
        Thread t2 = new Thread(() -> transfer(b, a, 3));

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Done. A = " + a.balance + " B = " + b.balance);
    }
}

