package mkr.task8;

public class Main {
    private static volatile char state = 's';

    public static void main(String[] args) {
        Thread threadA = createThreadA();
        Thread threadB = createThreadB();

        threadA.start();
        threadB.start();
    }

    private static Thread createThreadA() {
        return new Thread(() -> {
            char currentState;
            while (true) {
                try {
                    Thread.sleep(100);
                    currentState = (state == 's') ? 'z' : 's';
                    state = currentState;
                    System.out.println("State changed to " + state);
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
                    while (state != 's') {
                        Thread.sleep(1);
                    }
                    for (int i = 100; 0 < i; i--) {
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