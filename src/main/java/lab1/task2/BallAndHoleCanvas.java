package lab1.task2;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class BallAndHoleCanvas extends JPanel {
    public static volatile ArrayList<Ball> balls = new ArrayList<>();
    public static volatile ArrayList<Hole> holes = new ArrayList<>();

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        for (Ball ball : balls) {
            ball.draw(g2);
        }

        for (Hole hole : holes) {
            hole.draw(g2);
        }
    }

    public static synchronized void removeBall(Ball ball) {
        balls.remove(ball);
    }
}
