package lab1.task2;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.util.Random;

import static lab1.task2.Ball.XSIZE;
import static lab1.task2.Ball.YSIZE;

class Hole {
    private Component canvas;
    private int x = 0;
    private int y = 0;

    public Hole(Component c) {
        this.canvas = c;

        x = new Random().nextInt(this.canvas.getWidth());
        y = new Random().nextInt(this.canvas.getHeight());
    }

    public void draw(Graphics2D g2) {
        g2.setColor(Color.red);
        g2.fill(new Ellipse2D.Double(x, y, XSIZE, YSIZE));
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }


}