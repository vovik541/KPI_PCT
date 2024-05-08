package lab1.task3;

import java.awt.*;

public class RedBallThread extends BallThread{
    public RedBallThread(Ball ball) {
        super(ball);
        ball.setColor(Color.RED);
        setPriority(Thread.MAX_PRIORITY);
    }
}
