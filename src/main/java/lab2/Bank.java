package lab2;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

class Bank {

    public static final int NTEST = 10000;
    private volatile AtomicInteger[] accounts;
    private long ntransacts = 0;
//    private final ReentrantLock lock = new ReentrantLock();

    public Bank(int n, int initialBalance) {
        accounts = new AtomicInteger[n];
        int i;
        for (i = 0; i < accounts.length; i++)
            accounts[i] = new AtomicInteger(initialBalance);
        ntransacts = 0;
    }

//    public synchronized void transfer(int from, int to, int amount)
//            throws InterruptedException {
//        if (accounts[from] < amount) {
//            System.out.println("Account: " + from
//                    + " Has not enough money. Has " + accounts[from] + " and needs " + amount);
//            return;
//        }
//        accounts[from] -= amount;
//        accounts[to] += amount;
//        ntransacts++;
//        if (ntransacts % NTEST == 0)
//            test();
//    }

//    public void transfer(int from, int to, int amount)
//            throws InterruptedException {
//        synchronized (this) {
//            if (accounts[from] < amount) {
//                System.out.println("Account: " + from
//                        + " Has not enough money. Has " + accounts[from] + " and needs " + amount);
//                return;
//            }
//            accounts[from] -= amount;
//            accounts[to] += amount;
//            ntransacts++;
//            if (ntransacts % NTEST == 0)
//                test();
//        }
//    }

//    public void transfer(int from, int to, int amount)
//            throws InterruptedException {
//        lock.lock();
//        if (accounts[from] < amount) {
//            System.out.println("Account: " + from
//                    + " Has not enough money. Has " + accounts[from] + " and needs " + amount);
//            return;
//        }
//        accounts[from] -= amount;
//        accounts[to] += amount;
//        ntransacts++;
//        if (ntransacts % NTEST == 0)
//            test();
//        lock.unlock();
//    }

    public void transfer(int from, int to, int amount)
            throws InterruptedException {

        if (accounts[from].get() < amount) {
            System.out.println("Account: " + from
                    + " Has not enough money. Has " + accounts[from] + " and needs " + amount);
            return;
        }
        accounts[from].getAndAdd(-amount);
        accounts[to].getAndAdd(amount);
        ntransacts++;
        if (ntransacts % NTEST == 0)
            test();
    }
    public void test() {
        int sum = 0;
        for (int i = 0; i < accounts.length; i++)
            sum += accounts[i].get();
        System.out.println("Transactions:" + ntransacts
                + " Sum: " + sum);
    }

    public int size() {
        return accounts.length;
    }
}
