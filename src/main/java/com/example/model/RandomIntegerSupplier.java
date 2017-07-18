package com.example.model;

import java.security.SecureRandom;
import java.util.function.Supplier;

public class RandomIntegerSupplier implements Supplier<Integer> {

    private final int min;
    private final int max;
    private final SecureRandom srnd;

    public RandomIntegerSupplier(int max) {
        this(0, max);
    }

    public RandomIntegerSupplier(int min, int max) {
        this.min = min;
        this.max = max - min;
        this.srnd = new SecureRandom();
    }

    @Override
    public Integer get() {
        return srnd.nextInt(max) + min;
    }
}
