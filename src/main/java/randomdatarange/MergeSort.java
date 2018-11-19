package randomdatarange;

import util.TimeCalculator;

public class MergeSort extends RandomDataRangeSortAlgorithm {

    /**
     * No new arrays is created during splitting phase - logical splitting
     * Not an inplace algorithm
     * O(n*logn)
     * Stable Algorithm
     */
    private int[] mergeSort(int[] inputArray) {
        int start = 0;
        int end = inputArray.length;
        splitForMergeSort(inputArray, start, end);
        return inputArray;
    }


    /**
     * end index is always one greater than the last element's index
     *
     */
    private void splitForMergeSort(int[] array, int start, int end) {
        int mid = (start + end) / 2;

        if (end - start > 1) {
            splitForMergeSort(array, start, mid);
            splitForMergeSort(array, mid, end);
            mergeForMergeSort(array, start, mid, end);

        } else {
            return;
        }

    }

    private void mergeForMergeSort(int[] array, int start, int mid, int end) {
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


        System.arraycopy(tempArray, 0, array, 0 + start, end - start);

    }

    @Override
    public int[] sort(int[] inputArray) {
        this.setInputArray(inputArray);
        this.setSortAlgorithmName(this.getClass().getSimpleName());

        TimeCalculator timeCalculator = new TimeCalculator();
        timeCalculator.startTime();

        int[] resultArray = mergeSort(inputArray);

        timeCalculator.endTime();

        this.setTotalTime(timeCalculator.getTotalTime());

        return resultArray;
    }
}
