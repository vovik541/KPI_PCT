package mkr.task16;

import java.util.concurrent.ArrayBlockingQueue;

public class Main {
    private static final ArrayBlockingQueue<Integer> buffer = new ArrayBlockingQueue<>(10);

    public static void main(String[] args) {
        Thread producerThread = new Thread(new Producer(buffer));
        Thread consumerAThread = new Thread(new Consumer(buffer, "A"));
        Thread consumerBThread = new Thread(new Consumer(buffer, "B"));

        producerThread.start();
        consumerAThread.start();
        consumerBThread.start();
    }

}