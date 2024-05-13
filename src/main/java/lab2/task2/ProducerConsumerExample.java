package lab2.task2;

public class ProducerConsumerExample {
    public static void main(String[] args) {
        int arraySize = 5000;

        Drop drop = new Drop(arraySize);
        (new Thread(new Producer(drop))).start();
        (new Thread(new Consumer(drop))).start();
    }
}