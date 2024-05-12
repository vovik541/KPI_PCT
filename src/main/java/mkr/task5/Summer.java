package mkr.task5;

class Summer implements Runnable {
    private static double[] array;
    private final int start;
    private final int end;
    private static volatile double totalSum = 0;

    public Summer(double[] array, int start, int end) {
        Summer.array = array;
        this.start = start;
        this.end = end;
    }

    public static double getTotalSum() {
        return totalSum;
    }

    @Override
    public void run() {
        double sum = 0;
        for (int i = start; i < end; i++) {
            sum += array[i];
        }

        totalSum += sum;
    }
}