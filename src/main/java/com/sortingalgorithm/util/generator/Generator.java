package com.sortingalgorithm.util.generator;

/**
 * To generate an array of elements of type T
 */
public interface Generator<T> {
    T[] generateArray(int size);
}
