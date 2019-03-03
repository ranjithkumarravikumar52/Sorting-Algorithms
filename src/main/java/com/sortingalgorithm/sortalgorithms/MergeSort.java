package com.sortingalgorithm.sortalgorithms;

import org.springframework.stereotype.Component;

@Component
public class MergeSort extends SortAlgorithm<Integer> {

    /**
     * No new arrays is created during splitting phase - logical splitting
     * Not an inplace algorithm
     * O(n*logn)
     * Stable Algorithm
     */
    private Integer[] mergeSort(Integer[] inputArray) {
        int start = 0;
        int end = inputArray.length;
        splitForMergeSort(inputArray, start, end);
        return inputArray;
    }


    /**
     * end index is always one greater than the last element's index
     */
    private void splitForMergeSort(Integer[] array, int start, int end) {
        int mid = (start + end) / 2;

        if (end - start > 1) {
            splitForMergeSort(array, start, mid);
            splitForMergeSort(array, mid, end);
            mergeForMergeSort(array, start, mid, end);

        } else {
            return;
        }

    }

    private void mergeForMergeSort(Integer[] array, int start, int mid, int end) {
        int i = start;
        int j = mid;
        int tempIndex = 0;
        int[] tempArray = new int[end - start];
        while (i < mid && j < end) {
            tempArray[tempIndex++] = array[i] <= array[j] ? array[i++] : array[j++];
        }

        while (j < end) {
            tempArray[tempIndex++] = array[j++];
        }
        while (i < mid) {
            tempArray[tempIndex++] = array[i++];
        }
//        System.arraycopy(tempArray, 0, array, start, end - start);
        for (int sourceIndex = 0, destinationIndex = start; sourceIndex < end - start; sourceIndex++, destinationIndex++) {
            array[destinationIndex] = tempArray[sourceIndex];
        }

    }

    @Override
    public Integer[] sort(Integer[] inputArray) {
        return mergeSort(inputArray);
    }
}
