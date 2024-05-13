package lab2.task2;

public class Drop {
    private String message;
    private int number;
    private boolean empty = true;

    public Drop(int size) {
        this.number = size;
    }

    public synchronized String take() {
        while (empty) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        empty = true;
        notifyAll();
        return message;
    }

    public synchronized void put(String message) {
        while (!empty) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        empty = false;
        this.message = message;
        notifyAll();
    }
    public int getSize() {
        return number;
    }
}
