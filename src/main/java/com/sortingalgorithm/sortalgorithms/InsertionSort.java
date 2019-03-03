package com.sortingalgorithm.sortalgorithms;

import org.springframework.stereotype.Component;

@Component
public class InsertionSort extends SortAlgorithm<Integer> {

    private Integer[] insertionSort(Integer[] localArray) {

        for (int firstUnsortedIndex = 1; firstUnsortedIndex < localArray.length; firstUnsortedIndex++) {
            int newElement = localArray[firstUnsortedIndex];
            int i;
            for (i = firstUnsortedIndex; i > 0 && localArray[i - 1] > newElement; i--) {
                //shifting to right
                localArray[i] = localArray[i - 1];
            }
            localArray[i] = newElement;
        }
        return localArray;

    }

    @Override
    public Integer[] sort(Integer[] inputArray) {
        return insertionSort(inputArray);
    }
}
