package lab2.task2;

class Consumer implements Runnable {
    private Drop drop;
    private int[] data;

    public Consumer(Drop drop, int[] data) {
        this.drop = drop;
        this.data = data;
    }

    public void run() {
        for (int i = 0; i < data.length; i++) {
            try {
                int number = drop.take();
                System.out.println("Consumed: " + number);
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}