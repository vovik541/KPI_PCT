package mkr.task16;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

public class Consumer implements Runnable {
    private final ArrayBlockingQueue<Integer> buffer;
    private final String name;

    public Consumer(ArrayBlockingQueue<Integer> buffer, String name) {
        this.buffer = buffer;
        this.name = name;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Integer value = buffer.poll(1000, TimeUnit.MILLISECONDS);
                if (value == null){
                    break;
                }
                System.out.println("Consumer " + name + " deleted " + value);
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
