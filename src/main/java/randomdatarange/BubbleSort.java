package randomdatarange;

import util.SwapElements;
import util.metric.TimeMetric;

/**
 * Inherits fields from the superclass SortAlgorithm
 * <ul>
 * <li>stepsToSort - steps to sort any given array, the measurement of steps is defined in the sorting algorithm implementation.</li>
 * <li>inputArray - input array to be sorted</li>
 * </ul>
 */
public class BubbleSort extends RandomDataRangeSortAlgorithm {

    private int[] bubbleSort(int[] inputArray) {
        int[] localArray = new int[inputArray.length];
        System.arraycopy(inputArray, 0, localArray, 0, localArray.length);
        for (int lastUnsortedIndex = localArray.length - 1; lastUnsortedIndex > 0; lastUnsortedIndex--) {
            for (int i = 0; i < lastUnsortedIndex; i++) {
                if (localArray[i] > localArray[i + 1]) {
                    SwapElements.swap(localArray, i, i + 1);
                }
            }
        }

        return localArray;
    }

    @Override
    public int[] sort(int[] inputArray) {
        this.setInputArray(inputArray);

        TimeMetric timeMetric = new TimeMetric();
        timeMetric.startTime();

        int[] resultArray = bubbleSort(inputArray);

        timeMetric.endTime();
        this.setTotalTime(timeMetric.getTotalMetric());

        this.setSortAlgorithmName(this.getClass().getSimpleName());

        return resultArray;
    }
}
