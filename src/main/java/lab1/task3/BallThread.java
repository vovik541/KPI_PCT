package lab1.task3;

public class BallThread extends Thread {
    private Ball b;

    public BallThread(Ball ball) {
        b = ball;
        setPriority(Thread.MIN_PRIORITY);
    }

    @Override
    public void run() {
        try {
            while (true){
                b.move();
                System.out.println("Thread name = "
                        + Thread.currentThread().getName());
                Thread.sleep(5);
            }
        } catch (InterruptedException ex) {

        }
    }
}
