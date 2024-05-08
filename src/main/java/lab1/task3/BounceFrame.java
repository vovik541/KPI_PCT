package lab1.task3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import static java.awt.Color.blue;
import static java.awt.Color.red;

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

        JButton create100Button = new JButton("Create 100 balls");
        JButton create500Button = new JButton("Create 500 balls");
        JButton buttonStop = new JButton("Stop");

        create100Button.addActionListener(e -> createBalls(100));
        create500Button.addActionListener(e -> createBalls(500));

        buttonStop.addActionListener(e -> System.exit(0));

        buttonPanel.add(create100Button);
        buttonPanel.add(create500Button);
        buttonPanel.add(buttonStop);

        content.add(buttonPanel, BorderLayout.SOUTH);
    }

    void createBalls(int number) {
        int x;
        int y;

        x = new Random().nextInt(this.canvas.getWidth());
        y = new Random().nextInt(this.canvas.getHeight());

        for (int i = 1; i < number; i++) {
            Ball b = new Ball(canvas, x, y);
            canvas.add(b);
            BallThread thread = new BallThread(b);
            thread.setPriority(Thread.MIN_PRIORITY);
            thread.start();
            System.out.println("Thread name = " + thread.getName());
        }

        Ball b = new Ball(canvas, x, y);
        canvas.add(b);
        RedBallThread thread = new RedBallThread(b);
        thread.start();
        System.out.println("Thread name = " + thread.getName());
    }
}
