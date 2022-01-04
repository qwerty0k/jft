package ru.stqa.jft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PrimeTests {

    @Test
    public void testPrime () {
        Assert.assertTrue(Primes.isPrime(5));
    }
    @Test(enabled = false)
    public void testNonPrime () {
        Assert.assertFalse(Primes.isPrimeWhile(4));
    }
}
