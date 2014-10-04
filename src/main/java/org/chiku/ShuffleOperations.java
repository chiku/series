package org.chiku;

import java.util.ArrayList;
import java.util.HashMap;

public class ShuffleOperations {

    private int size;
    private final PrimeFinder finder;
    private final ArrayList<String> primes;
    private final ArrayList<String> nonPrimes;

    public ShuffleOperations(int size) {
        this.size = size;
        this.finder = new PrimeFinder();
        this.primes = new ArrayList<String>();
        this.nonPrimes = new ArrayList<String>();
    }

    public void shuffle() {
        for (int i = 1; i <= size; i++) {
            ArrayList<String> list = finder.isPrime(i) ? primes : nonPrimes;
            list.add(addPair(i));
        }
    }

    private String addPair(int i) {
        return new StringBuilder()
                .append("[")
                .append(i)
                .append(", ")
                .append(new ShuffleOperation(i).shuffleTimes())
                .append("]")
                .toString();
    }

    public HashMap<String, String> result() {
        HashMap<String, String> scopes = new HashMap<String, String>();
        scopes.put("prime", primes.toString());
        scopes.put("nonPrime", nonPrimes.toString());
        return scopes;
    }
}
