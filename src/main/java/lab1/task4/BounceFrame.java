package lab1.task4;

import javax.swing.*;
import java.awt.*;

import static java.awt.Color.*;

public class BounceFrame extends JFrame {

    private BallCanvas canvas;
    public static final int WIDTH = 800;
    public static final int HEIGHT = 400;

    public BounceFrame() {
        this.setSize(WIDTH, HEIGHT);
        this.setTitle("Bounce programm");

        this.canvas = new BallCanvas();
        System.out.println("In Frame Thread name = "
                + Thread.currentThread().getName());
        Container content = this.getContentPane();
        content.add(this.canvas, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.lightGray);

        JButton buttonStart = new JButton("Start");
        JButton buttonStop = new JButton("Stop");

        buttonStart.addActionListener(e -> {
            createBalls(canvas);
        });

        buttonStop.addActionListener(e -> System.exit(0));


        buttonPanel.add(buttonStart);
        buttonPanel.add(buttonStop);

        content.add(buttonPanel, BorderLayout.SOUTH);
    }

    private void createBalls(BallCanvas canvas){
        Ball ball = new Ball(canvas, blue);
        canvas.add(ball);
        BallThread ballThread = new BallThread(ball);
        ballThread.start();
        BallThread joined = ballThread;

        ball = new Ball(canvas, red);
        canvas.add(ball);
        ballThread = new JoinBallThread(ball, joined);
        ballThread.start();
        joined = ballThread;

        ball = new Ball(canvas, yellow);
        canvas.add(ball);
        ballThread = new JoinBallThread(ball, joined);
        ballThread.start();
        joined = ballThread;

        ball = new Ball(canvas, gray);
        canvas.add(ball);
        ballThread = new JoinBallThread(ball, joined);
        ballThread.start();
        joined = ballThread;


        ball = new Ball(canvas, green);
        canvas.add(ball);
        ballThread = new JoinBallThread(ball, joined);
        ballThread.start();
        joined = ballThread;

        ball = new Ball(canvas, orange);
        canvas.add(ball);
        ballThread = new JoinBallThread(ball, joined);
        ballThread.start();
    }
}
