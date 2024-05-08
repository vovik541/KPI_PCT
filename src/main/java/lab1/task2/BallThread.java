package lab1.task2;

import static lab1.task2.BallAndHoleCanvas.holes;
import static lab1.task2.BallsInHoleCounter.incrementBallsInHolesCounter;

public class BallThread extends Thread {
    private Ball ball;

    public BallThread(Ball ball) {
        this.ball = ball;
    }

    @Override
    public void run() {
        try {
            while (!ball.isInHole(holes)) {
                ball.move();
                System.out.println("Thread name = " + Thread.currentThread().getName());
                Thread.sleep(5);
            }
            incrementBallsInHolesCounter();
            ball.deleteBall();
        } catch (InterruptedException ex) {

        }
    }
}
