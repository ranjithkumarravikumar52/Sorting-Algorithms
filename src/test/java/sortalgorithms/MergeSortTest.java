package sortalgorithms;

import org.junit.Before;
import org.junit.Test;
import util.generator.Generator;
import util.generator.IntegerArrayGenerator;

import static org.junit.Assert.*;

public class MergeSortTest {
    //    private int[] SIZE = {10, 100, 1000, 10_000, 100_000, 1_000_000, 10_000_000, 100_000_000};

    private Integer[] inputArray;
    private SortAlgorithm<Integer> sortAlgorithm;
    private Generator<Integer> integerGenerator ;

    @Before
    public void setup(){
        sortAlgorithm = new MergeSort();
        integerGenerator = new IntegerArrayGenerator();
    }

    @Test
    public void checkSort(){
        inputArray = new Integer[]{3,2,1,4};
        assertArrayEquals(new Integer[]{1,2,3,4}, sortAlgorithm.sort(inputArray));
    }



}