package sortalgorithms;

import org.junit.Test;

import static org.junit.Assert.*;

public class MergeSortTest {
    private int[] inputArray;
    private SortAlgorithm sortAlgorithm;

    @Test
    public void checkSort(){
        sortAlgorithm = new MergeSort();
        inputArray = new int[]{3,2,1,4};
        assertArrayEquals(new int[]{1,2,3,4}, sortAlgorithm.sort(inputArray));
    }
}