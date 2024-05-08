package lab1.task2;

import javax.swing.*;
import java.awt.*;

import static lab1.task2.BallAndHoleCanvas.balls;
import static lab1.task2.BallAndHoleCanvas.holes;
import static lab1.task2.BallsInHoleCounter.setBallsInHoleJLabel;

public class BounceFrame extends JFrame {

    private BallAndHoleCanvas canvas;
    public static final int WIDTH = 800;
    public static final int HEIGHT = 400;

    public BounceFrame() {
        this.setSize(WIDTH, HEIGHT);
        this.setTitle("Bounce programm");

        this.canvas = new BallAndHoleCanvas();
        System.out.println("In Frame Thread name = "
                + Thread.currentThread().getName());
        Container content = this.getContentPane();
        content.add(this.canvas, BorderLayout.CENTER);

        JPanel counterPanel = new JPanel();
        JLabel counterLabel = new JLabel("Balls scored: 0");
        setBallsInHoleJLabel(counterLabel);
        counterPanel.add(counterLabel);
        counterPanel.setBackground(Color.lightGray);
        content.add(counterPanel, BorderLayout.EAST);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.lightGray);

        JButton createBall = new JButton("Create Ball");
        JButton createHole = new JButton("Create Hole");
        JButton buttonStop = new JButton("Stop");

        createBall.addActionListener(e -> {
            Ball ball = new Ball(canvas);
            balls.add(ball);

            BallThread thread = new BallThread(ball);
            thread.start();
            System.out.println("Thread name = " + thread.getName());
        });

        createHole.addActionListener(e -> {
            Hole hole = new Hole(canvas);
            holes.add(hole);
            canvas.repaint();
        });

        buttonStop.addActionListener(e -> System.exit(0));

        buttonPanel.add(createBall);
        buttonPanel.add(createHole);
        buttonPanel.add(buttonStop);

        content.add(buttonPanel, BorderLayout.SOUTH);
    }
}
