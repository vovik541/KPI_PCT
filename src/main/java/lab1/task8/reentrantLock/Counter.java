package lab1.task8.reentrantLock;

import java.util.concurrent.locks.ReentrantLock;

public class Counter {
    private final ReentrantLock lock = new ReentrantLock();
    private int value = 0;

    public void increment() {
        lock.lock();
        try {
            this.value++;
        } finally {
            lock.unlock();
        }
    }

    public void decrement() {
        lock.lock();
        try {
            this.value--;
        } finally {
            lock.unlock();
        }
    }

    @Override
    public String toString() {
        return "Counter{" +
                "value=" + value +
                '}';
    }
}
