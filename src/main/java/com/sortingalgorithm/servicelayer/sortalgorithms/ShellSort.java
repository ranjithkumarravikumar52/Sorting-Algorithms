/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sortingalgorithm.servicelayer.sortalgorithms;
import org.springframework.stereotype.Component;

@Component
public class ShellSort<T extends Comparable<T>> implements SortAlgorithm<T> {


    private T[] shellSort(T[] localArray) {
        for (int gap = localArray.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < localArray.length; i++) {
                T newElement = localArray[i];
                int j = i;
                // while (j >= gap && localArray[j - gap] > newElement) {
                while (j >= gap && localArray[j - gap].compareTo(newElement) > 0) {
                    localArray[j] = localArray[j - gap];
                    j = j - gap;
                }
                localArray[j] = newElement;
            }
        }
        return localArray;
    }

    @Override
    public T[] sort(T[] inputArray) {
        if(inputArray == null || inputArray.length == 0) return inputArray;
        return shellSort(inputArray);
    }
}
