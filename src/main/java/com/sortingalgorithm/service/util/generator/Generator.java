package com.sortingalgorithm.service.util.generator;

/**
 * To generate an array of elements of type T
 */
public interface Generator<T> {
    T[] generateArray(int size);
}
