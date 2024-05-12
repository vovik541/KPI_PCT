package mkr.task5;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        double[] array = initArray();
        int threadsCount = 100;
        int perThread = array.length / threadsCount;

        ExecutorService executor = Executors.newFixedThreadPool(4);
        long start = System.currentTimeMillis();
        for (int i = 0; i < threadsCount; i++) {
            executor.execute(new Summer(array, i * perThread, (i + 1) * perThread));
        }

        if (threadsCount * perThread < array.length) {
            executor.execute(new Summer(array, threadsCount * perThread, array.length));
        }

        executor.shutdown();
        executor.awaitTermination(5, TimeUnit.SECONDS);
        long finish = System.currentTimeMillis();

        double totalSum = Summer.getTotalSum();
        System.out.println("Total sum from pool: " + totalSum + " took " + (finish - start) + " millis");

        start = System.currentTimeMillis();
        double count = countArrayInOneThread(array);
        finish = System.currentTimeMillis();

        System.out.println("Counted in one thread: " + count + " took " + (finish - start) + " millis");
    }

    public static double[] initArray() {
        double[] array = new double[100000000];
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextDouble();
        }
        return array;
    }

    public static double countArrayInOneThread(double[] array) {
        double sum = 0;
        for (double v : array) {
            sum += v;
        }
        return sum;
    }
}