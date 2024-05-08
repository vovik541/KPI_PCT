package lab1.task2;

import javax.swing.*;

public final class BallsInHoleCounter {
    public static volatile int count = 0;
    public static JLabel ballsInHoleJLabel;

    private BallsInHoleCounter() {
    }

    public static void setBallsInHoleJLabel(JLabel ballsInHoleJLabel) {
        BallsInHoleCounter.ballsInHoleJLabel = ballsInHoleJLabel;
    }

    public static synchronized void incrementBallsInHolesCounter() {
        ++count;
        ballsInHoleJLabel.setText("Balls in hole: " + count);
    }
}
