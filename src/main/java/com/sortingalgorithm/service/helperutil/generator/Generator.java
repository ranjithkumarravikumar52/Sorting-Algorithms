package com.sortingalgorithm.service.helperutil.generator;

/**
 * To generate an array of elements of type T
 */
public interface Generator<T> {
    T[] generateArray(int size);
}
