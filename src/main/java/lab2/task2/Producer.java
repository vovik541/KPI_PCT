package lab2.task2;

public class Producer implements Runnable {
    private Drop drop;

    public Producer(Drop drop) {
        this.drop = drop;
    }

    public void run() {
        int[] numbers = initArr();

        for (int number : numbers) {
            drop.put(String.valueOf(number));
        }
        drop.put("DONE");
    }

    public int[] initArr() {
        int[] numbers = new int[drop.getSize()];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = i + 1;
        }
        return numbers;
    }
}
