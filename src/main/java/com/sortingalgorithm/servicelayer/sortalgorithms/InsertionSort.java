package com.sortingalgorithm.servicelayer.sortalgorithms;

import org.springframework.stereotype.Component;

@Component
public class InsertionSort<T extends Comparable<T>> implements SortAlgorithm<T> {

    private T[] insertionSort(T[] localArray) {

        for (int firstUnsortedIndex = 1; firstUnsortedIndex < localArray.length; firstUnsortedIndex++) {
            T newElement = localArray[firstUnsortedIndex];
            int i;
            for (i = firstUnsortedIndex; i > 0 && localArray[i - 1].compareTo(newElement) > 0; i--) {
                //shifting to right
                localArray[i] = localArray[i - 1];
            }
            localArray[i] = newElement;
        }
        return localArray;

    }

    @Override
    public T[] sort(T[] inputArray) {
        if(inputArray == null || inputArray.length == 0) return inputArray;
        return insertionSort(inputArray);
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }
}
