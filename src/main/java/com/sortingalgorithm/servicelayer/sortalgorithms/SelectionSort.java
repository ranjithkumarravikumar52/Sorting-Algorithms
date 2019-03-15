/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sortingalgorithm.servicelayer.sortalgorithms;

import org.springframework.stereotype.Component;

@Component
public class SelectionSort<T extends Comparable<T>> implements SortAlgorithm<T> {

    private T[] selectionSort(T[] localArray) {
        for (int lastUnsortedIndex = localArray.length - 1; lastUnsortedIndex > 0; lastUnsortedIndex--) {
            int maxIndex = 0;
            for (int arrayIndex = 1; arrayIndex <= lastUnsortedIndex; arrayIndex++) {
                // if (localArray[arrayIndex] > localArray[maxIndex]) {
                if (localArray[arrayIndex].compareTo(localArray[maxIndex]) > 0) {
                    maxIndex = arrayIndex;
                }
            }
            swap(localArray, lastUnsortedIndex, maxIndex);
        }
        return localArray;
    }

    @Override
    public T[] sort(T[] inputArray) {
        if(inputArray == null || inputArray.length == 0) return inputArray;
        return selectionSort(inputArray);
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
