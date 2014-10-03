package org.chiku;

import java.util.Random;

public class Item {

    private final int identity;
    private final double randomFactor;

    public Item(int identity) {
        this.identity = identity;
        this.randomFactor = new Random().nextDouble();
    }

    public String toString() {
        return new Integer(identity).toString();
    }

    public Boolean has(int identity) {
        return this.identity == identity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Item item = (Item) o;

        if (identity != item.identity) return false;
        if (Double.compare(item.randomFactor, randomFactor) != 0) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = identity;
        temp = Double.doubleToLongBits(randomFactor);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
