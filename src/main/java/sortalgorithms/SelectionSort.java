/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortalgorithms;

import util.swapelements.IntSwappable;

public class SelectionSort extends SortAlgorithm implements IntSwappable {


    private int[] selectionSort(int[] inputArray) {
        int[] localArray = new int[inputArray.length];
        System.arraycopy(inputArray, 0, localArray, 0, localArray.length);
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
    public int[] sort(int[] inputArray) {
        return selectionSort(inputArray);
    }

    @Override
    public boolean swap(int[] array, int firstIndex, int secondIndex) {
        if (firstIndex == secondIndex) {
            return false;
        }

        Integer temp = array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = temp;
        return true;
    }
}
