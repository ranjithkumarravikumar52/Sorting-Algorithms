package sortalgorithms;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class BubbleSortTest {

    private int[] inputArray;
    private SortAlgorithm sortAlgorithm;

    @Test
    public void checkSort(){
        sortAlgorithm = new BubbleSort();
        inputArray = new int[]{3,2,1,4};
        assertArrayEquals(new int[]{1,2,3,4}, sortAlgorithm.sort(inputArray));
    }
}