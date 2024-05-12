package mkr.task8.guarded;

public class ThreadB extends Thread {
    private final Object lock;
    private final ThreadA threadA;

    public ThreadB(Object lock, ThreadA threadA) {
        this.lock = lock;
        this.threadA = threadA;
    }

    @Override
    public void run() {
        int count = 100;

        try {
            while (count >= 0) {
                synchronized (lock) {
                    while (threadA.getCharState() != 's') {
                        System.out.println("B sleeping ___________________________________________");
                        lock.wait();
                    }

                    while (threadA.getCharState() == 's' && count >= 0) {
                        System.out.println("B: " + count);
                        count--;
                        Thread.sleep(1);
                    }
                }
            }
            threadA.interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


