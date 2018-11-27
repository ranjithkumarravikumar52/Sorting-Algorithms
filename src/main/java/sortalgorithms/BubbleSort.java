package sortalgorithms;

import util.swapelements.ObjectSwappable;

/**
 * Inherits fields from the superclass SortAlgorithm
 * <ul>
 * <li>stepsToSort - steps to sort any given array, the measurement of steps is defined in the sorting algorithm implementation.</li>
 * <li>inputArray - input array to be sorted</li>
 * </ul>
 */
public class BubbleSort extends SortAlgorithm<Integer> implements ObjectSwappable<Integer> {

    private Integer[] bubbleSort(Integer[] inputArray) {

        for (int lastUnsortedIndex = inputArray.length - 1; lastUnsortedIndex > 0; lastUnsortedIndex--) {
            for (int i = 0; i < lastUnsortedIndex; i++) {
                if (inputArray[i] > inputArray[i + 1]) {
                    swap(inputArray, i, i + 1);
                }
            }
        }
        return inputArray;
    }

    @Override
    public Integer[] sort(Integer[] inputArray) {
        return bubbleSort(inputArray);
    }

    @Override
    public boolean swap(Integer[] array, int firstIndex, int secondIndex) {
        if (firstIndex == secondIndex) {
            return false;
        }

        Integer temp = array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = temp;
        return true;
    }
}
