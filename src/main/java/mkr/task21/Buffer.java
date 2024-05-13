package mkr.task21;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Buffer {
    private Queue<Integer> queue = new LinkedList<>();
    private int capacity = 5;
    private Lock lock = new ReentrantLock();
    private Condition notFull = lock.newCondition();
    private Condition notEmpty = lock.newCondition();

    public void produce(int item) throws InterruptedException {
        lock.lock();
        try {
            while (queue.size() == capacity) {
                System.out.println("Buffer is full. Producer is waiting...");
                notFull.await();
            }
            queue.add(item);
            System.out.println("Produced: " + item);
            notEmpty.signal();
        } finally {
            lock.unlock();
        }
    }

    public int consume() throws InterruptedException {
        lock.lock();
        try {
            while (queue.isEmpty()) {
                System.out.println("Buffer is empty. Consumer is waiting...");
                notEmpty.await();
            }
            int item = queue.poll();
            System.out.println("Consumed: " + item);
            notFull.signal();
            return item;
        } finally {
            lock.unlock();
        }
    }
}