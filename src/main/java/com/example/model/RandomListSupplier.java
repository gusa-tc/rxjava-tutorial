package com.example.model;

import lombok.NonNull;

import java.util.List;
import java.util.Random;
import java.util.function.Supplier;

public class RandomListSupplier<T> implements Supplier<T> {

    final List<T> source;
    final int size;
    final Random grnd;

    public RandomListSupplier(@NonNull List<T> source) {
        this.source = source;
        this.size = source.size();
        this.grnd = new Random();
    }

    @Override
    public T get() {
        return size == 0 ? null : source.get(grnd.nextInt(size));
    }
}
