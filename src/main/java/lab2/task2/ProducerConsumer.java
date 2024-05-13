package lab2.task2;

public class ProducerConsumer {
    public static void main(String[] args) {
        Drop drop = new Drop();
        int[] data = new int[100]; // Масив чисел розміром 100

        Thread producer = new Thread(new Producer(drop, data));
        Thread consumer = new Thread(new Consumer(drop, data));

        producer.start();
        consumer.start();
    }
}