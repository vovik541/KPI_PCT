package lab1.task4;

public class JoinBallThread extends BallThread{
    private  BallThread parentThread;

    private int wait = 0;
    public JoinBallThread(Ball ball, BallThread parent)
    {
        super(ball);
        parentThread = parent;
    }

    public JoinBallThread(Ball ball, BallThread parent, int wait)
    {
        this(ball, parent);
        this.wait = wait;
    }

    @Override
    public void run(){
        try{
            if (this.wait > 0){
                parentThread.join(wait);
            }
            parentThread.join();
            super.run();
        } catch(InterruptedException ignored){
            super.interrupt();
        }

    }

    public void makeDependOn(Thread thread){
        try {
            thread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
