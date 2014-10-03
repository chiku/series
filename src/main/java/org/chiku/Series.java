package org.chiku;

public class Series {

    private final int size;
    private final int middle;
    private Item[] originalSeries;
    private Item[] currentSeries;

    public Series(int size) {
        this.size = size;
        this.middle = size / 2;
        this.originalSeries = new Item[size];
        this.currentSeries = new Item[size];
        populateSeries();
    }

    private void populateSeries() {
        for (int i = 0; i < size; i++) {
            Item item = new Item(i);
            originalSeries[i] = item;
            currentSeries[i] = item;
        }
    }

    public boolean isMatchOriginal() {
        for (int i = 0; i < size; i++) {
            if (originalSeries[i] != currentSeries[i]) {
                return false;
            }
        }
        return true;
    }

    public Series shuffle() {
        Item[] nextSeries = new Item[size];

        for (int i = 0; i < size; i+=2) {
            nextSeries[middle + i/2] = currentSeries[i];
        }

        for (int i = 1; i < size; i+=2) {
            nextSeries[middle - i/2 - 1] = currentSeries[i];
        }

        currentSeries = nextSeries;
        return this;
    }

    public Series dump() {
        for(Item item : this.currentSeries) {
            System.out.print(item);
            System.out.print(" ");
        }
        System.out.println();
        return this;
    }

    public Item at(int position) {
        return currentSeries[position];
    }
}
