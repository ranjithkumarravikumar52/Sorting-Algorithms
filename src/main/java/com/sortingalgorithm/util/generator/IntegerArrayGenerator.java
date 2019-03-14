package com.sortingalgorithm.util.generator;

import com.sortingalgorithm.util.randomization.IntegerDefaultRandomization;

public class IntegerArrayGenerator implements Generator<Integer> {

    @Override
    public Integer[] generateArray(int size) {
        Integer[] elements =  new Integer[size];
        for(int i = 0; i < size; i++){
            elements[i] = new IntegerDefaultRandomization().getRandomElement();
        }
        return elements;
    }

}
