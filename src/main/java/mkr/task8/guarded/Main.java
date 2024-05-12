package mkr.task8.guarded;

public class Main {

    private static final Object lock = new Object();

    public static void main(String[] args) {
        ThreadA threadA = new ThreadA(lock);
        ThreadB threadB = new ThreadB(lock, threadA);

        threadA.start();
        threadB.start();
    }
}