package com.sortingalgorithm.util.randomization;

public interface Randomization<T> {
    T getRandomElement();
    T getRandomElement(T minRange, T maxRange);
}
