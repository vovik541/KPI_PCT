package mkr.task16;

import java.util.concurrent.ArrayBlockingQueue;

public class Producer implements Runnable {
    private  final ArrayBlockingQueue<Integer> buffer;

    public Producer(ArrayBlockingQueue<Integer> buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i <= 40; i++) {
                buffer.put(i);
                System.out.println("Producer added " + i);
                Thread.sleep(120);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
