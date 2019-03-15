package com.sortingalgorithm.service.generator;

/**
 * To generate an array of elements of type T
 */
public interface Generator<T> {
    T[] generateArray(int size);
}
