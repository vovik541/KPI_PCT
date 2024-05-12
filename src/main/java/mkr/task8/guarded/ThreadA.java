package mkr.task8.guarded;

public class ThreadA extends Thread {
    private volatile char state = 's';
    private final Object lock;

    public ThreadA(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(10);

                if (state == 'z') {
                    state = 's';
                    System.out.println("State changed to " + state);
                    synchronized (lock) {
                        lock.notify();
                    }
                } else {
                    state = 'z';
                    System.out.println("State changed to " + state);
                }

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public char getCharState() {
        return state;
    }
}
