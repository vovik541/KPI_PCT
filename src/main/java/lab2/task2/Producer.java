package lab2.task2;

class Producer implements Runnable {
    private Drop drop;
    private int[] data;

    public Producer(Drop drop, int[] data) {
        this.drop = drop;
        this.data = data;
    }

    public void run() {
        for (int number : data) {
            try {
                drop.put(number);
                System.out.println("Produced: " + number);
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}