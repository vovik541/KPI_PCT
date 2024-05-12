package mkr.task8;

public class BMain {
    private static char state = 's';

    public static void main(String[] args) {
        Thread threadA = createThreadA();
        Thread threadB = createThreadB();

        threadA.start();
        threadB.start();
    }

    private static Thread createThreadA() {
        return new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(100);
                    System.out.println("State changed to " + state);
                    synchronized (BMain.class) {
                        state = (state == 's') ? 'z' : 's';
                        BMain.class.notify();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private static Thread createThreadB() {
        return new Thread(() -> {
            while (true) {
                try {
                    synchronized (BMain.class) {
                        while (state != 's') {
                            BMain.class.wait();
                        }
                    }
                    for (int i = 100; i > 0; i--) {
                        if (state == 'z') {
                            break;
                        }
                        System.out.println("B: " + i);
                        Thread.sleep(1);
                    }
                    System.out.println("B sleeping ___________________________________________");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}