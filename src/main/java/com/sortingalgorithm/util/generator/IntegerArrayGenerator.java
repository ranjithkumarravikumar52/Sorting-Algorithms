package com.sortingalgorithm.util.generator;

import com.sortingalgorithm.util.randomization.IntegerDefaultRandomization;

public class IntegerArrayGenerator<T extends Integer> implements Generator<Integer> {

    @Override
    public T[] generateArray(int size) {
        T[] elements = (T[]) new Object[size];
        for(int i = 0; i < size; i++){
            elements[i] = (T) new IntegerDefaultRandomization().getRandomElement();
        }
        return elements;
    }

}
