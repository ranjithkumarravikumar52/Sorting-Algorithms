package sortalgorithms;

public class QuickSort extends SortAlgorithm {

    private int[] quickSort(int[] inputArray) {
        doQuickSort(inputArray, 0, inputArray.length);
        return inputArray;
    }


    private void doQuickSort(int[] localArray, int start, int end) {

        if (end - start < 2) {
            return;
        }

        int pivot = localArray[start];
        int i = start;
        int j = end;

        while (i < j) {
            j = traverseFromEnd(localArray, pivot, i, j);
            i = traverseFromStart(localArray, pivot, i, j);
        }

        //if code reaches here then i == j
        localArray[i] = pivot;
        doQuickSort(localArray, start, i);
        doQuickSort(localArray, i + 1, end);

    }

    /**
     * traverse from the start of the array
     * look for position where element > pivot
     */
    private int traverseFromStart(int[] localArray, int pivot, int i, int j) {
        while (i < j && localArray[++i] <= pivot) ;
        if (i < j) {
            localArray[j] = localArray[i];
        }
        return i;
    }

    /**
     * traverse from the end of the array
     * look for position element < pivot
     */
    private int traverseFromEnd(int[] localArray, int pivot, int i, int j) {
        while (i < j && localArray[--j] >= pivot) ;
        if (i < j) {
            localArray[i] = localArray[j];
        }
        return j;
    }

    @Override
    public int[] sort(int[] inputArray) {
        return quickSort(inputArray);
    }
}
