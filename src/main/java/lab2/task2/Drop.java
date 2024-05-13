package lab2.task2;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Drop {
    private int[] data;
    private int index = 0;
    private boolean empty = true;
    private Lock lock = new ReentrantLock();
    private Condition notEmpty = lock.newCondition();
    private Condition notFull = lock.newCondition();

    public Drop() {
        this.data = new int[100]; // Початковий розмір масиву
    }

    public void put(int value) throws InterruptedException {
        lock.lock();
        try {
            while (!empty) {
                notFull.await();
            }
            data[index] = value;
            empty = false;
            index++;
            notEmpty.signal();
        } finally {
            lock.unlock();
        }
    }

    public int take() throws InterruptedException {
        lock.lock();
        try {
            while (empty) {
                notEmpty.await();
            }
            int value = data[index - 1];
            empty = true;
            index--;
            notFull.signal();
            return value;
        } finally {
            lock.unlock();
        }
    }
}