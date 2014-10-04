package org.chiku;

import org.junit.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PrimeFinderTest {

    @Test
    public void testPrimeNumbersAreIdentified() {
        PrimeFinder finder = new PrimeFinder();
        List<Integer> primes = asList(2, 3, 5);
        for (Integer prime : primes) {
            assertTrue(prime + " should have been a prime but wasn't", finder.isPrime(prime));
        }
    }

    @Test
    public void testNonPrimeNumbersAreIdentified() {
        PrimeFinder finder = new PrimeFinder();
        List<Integer> primes = asList(1, 4);
        for (Integer prime : primes) {
            assertFalse(prime + " should not have been a prime but was", finder.isPrime(prime));
        }
    }

}
