package com.sortingalgorithm.service.sortalgorithms;

/**
 * <p>Every Sort Algorithm is imagined as a Class. This class has two fields mandatory for any SortAlgorithm.</p>
 * <ul>
 * <li>stepsToSort - steps to sort any given array, the measurement of steps is defined in the sorting algorithm implementation.</li>
 * <li>inputArray - input array to be sorted</li>
 * </ul>
 * <p>The children of this class are: </p>
 * <ul>
 * <li>Random Data Range</li>
 * <li>Fixed Data Range</li>
 * </ul>
 */

import org.springframework.stereotype.Component;

@Component
public interface SortAlgorithm<T> {
    T[] sort(T[] inputArray);
}
