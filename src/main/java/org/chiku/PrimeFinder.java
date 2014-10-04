package org.chiku;

public class PrimeFinder {
    public Boolean isPrime(long number) {
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                return false;
            }
        }

        if (number == 1) {
            return false;
        }

        return true;
    }
}
