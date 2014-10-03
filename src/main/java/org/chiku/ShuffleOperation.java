package org.chiku;

public class ShuffleOperation {
    private final Series series;

    public ShuffleOperation(int size) {
        series = new Series(size);
    }

    public int shuffleTimes() {
        int count = 0;
        do {
            series.shuffle();
            count++;
        } while (!series.isMatchOriginal());

        return count;
    }
}
