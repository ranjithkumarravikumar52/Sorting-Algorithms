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

    @Test
    public void check100Elements() {
        try {
            int SIZE = 100;
            inputArray = new Integer[SIZE];
            inputArray = integerGenerator.generateArray(SIZE, 1, 11);
            sortAlgorithm.sort(inputArray);
            System.out.println(sortAlgorithm.getClass().getSimpleName()+": Tested for "+SIZE+" elements");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void check1000Elements() {
        try {
            int SIZE = 1000;
            inputArray = new Integer[SIZE];
            inputArray = integerGenerator.generateArray(SIZE, 1, 11);
            sortAlgorithm.sort(inputArray);
            System.out.println(sortAlgorithm.getClass().getSimpleName()+": Tested for "+SIZE+" elements");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void check10_000Elements() {
        try {
            int SIZE = 10_000;
            inputArray = new Integer[SIZE];
            inputArray = integerGenerator.generateArray(SIZE, 1, 11);
            sortAlgorithm.sort(inputArray);
            System.out.println(sortAlgorithm.getClass().getSimpleName()+": Tested for "+SIZE+" elements");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void check100_000Elements() {
        try {
            int SIZE = 100_000;
            inputArray = new Integer[SIZE];
            inputArray = integerGenerator.generateArray(SIZE, 1, 11);
            sortAlgorithm.sort(inputArray);
            System.out.println(sortAlgorithm.getClass().getSimpleName()+": Tested for "+SIZE+" elements");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void check1_000_000Elements() {
        try {
            int SIZE = 1_000_000;
            inputArray = new Integer[SIZE];
            inputArray = integerGenerator.generateArray(SIZE, 1, 11);
            sortAlgorithm.sort(inputArray);
            System.out.println(sortAlgorithm.getClass().getSimpleName()+": Tested for "+SIZE+" elements");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void check10_000_000Elements() {
        try {
            int SIZE = 10_000_000;
            inputArray = new Integer[SIZE];
            inputArray = integerGenerator.generateArray(SIZE, 1, 11);
            sortAlgorithm.sort(inputArray);
            System.out.println(sortAlgorithm.getClass().getSimpleName()+": Tested for "+SIZE+" elements");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}