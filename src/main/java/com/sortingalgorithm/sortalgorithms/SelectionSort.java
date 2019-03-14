/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sortingalgorithm.sortalgorithms;

import org.springframework.stereotype.Component;

@Component
public class SelectionSort extends SortAlgorithm<Integer> {


    private Integer[] selectionSort(Integer[] localArray) {
        for (int lastUnsortedIndex = localArray.length - 1; lastUnsortedIndex > 0; lastUnsortedIndex--) {
            int maxIndex = 0;
            for (int arrayIndex = 1; arrayIndex <= lastUnsortedIndex; arrayIndex++) {
                if (localArray[arrayIndex] > localArray[maxIndex]) {
                    maxIndex = arrayIndex;
                }
            }
            swap(localArray, lastUnsortedIndex, maxIndex);
        }
        return localArray;
    }

    @Override
    public Integer[] sort(Integer[] inputArray) {
        return selectionSort(inputArray);
    }


    private boolean swap(Integer[] array, int firstIndex, int secondIndex) {
        if (firstIndex == secondIndex) {
            return false;
        }

        Integer temp = array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = temp;
        return true;
    }
}
