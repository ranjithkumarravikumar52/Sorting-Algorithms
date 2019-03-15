package com.sortingalgorithm.service.sortalgorithms;

import org.springframework.stereotype.Component;

/**
 * Inherits fields from the superclass SortAlgorithm
 * <ul>
 * <li>stepsToSort - steps to sort any given array, the measurement of steps is defined in the sorting algorithm implementation.</li>
 * <li>inputArray - input array to be sorted</li>
 * </ul>
 */
@Component
public class BubbleSort<T extends Comparable<T>> implements SortAlgorithm<T> {

    private T[] bubbleSort(T[] inputArray) {

        for (int lastUnsortedIndex = inputArray.length - 1; lastUnsortedIndex > 0; lastUnsortedIndex--) {
            for (int i = 0; i < lastUnsortedIndex; i++) {
                if (inputArray[i].compareTo(inputArray[i + 1]) > 0) {
                    swap(inputArray, i, i + 1);
                }
            }
        }
        return inputArray;
    }

    @Override
    public T[] sort(T[] inputArray) {
        return bubbleSort(inputArray);
    }


    private boolean swap(T[] array, int firstIndex, int secondIndex) {
        if (firstIndex == secondIndex) {
            return false;
        }

        T temp = array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = temp;
        return true;
    }
}
