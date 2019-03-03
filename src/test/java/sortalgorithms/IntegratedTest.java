package sortalgorithms;

import com.sortingalgorithm.sortalgorithms.*;
import com.sortingalgorithm.util.generator.Generator;
import com.sortingalgorithm.util.generator.IntegerArrayGenerator;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class IntegratedTest {

    private int SIZE = 1000;
    private Integer[] inputArray = new Integer[SIZE];
    private Integer[] localArray = new Integer[SIZE];
    private List<SortAlgorithm<Integer>> sortAlgorithm = new ArrayList<>();
    private Generator<Integer> integerGenerator = new IntegerArrayGenerator();

    @Before
    public void setup() {
        sortAlgorithm.add(new BubbleSort());
        sortAlgorithm.add(new InsertionSort());
        sortAlgorithm.add(new MergeSort());
        sortAlgorithm.add(new QuickSort());
        sortAlgorithm.add(new SelectionSort());
        sortAlgorithm.add(new ShellSort());
    }

    @Test
    public void checkAllSortsForSIZEElements() {
        try {
            localArray = integerGenerator.generateArray(SIZE, 1, 11);
            for (SortAlgorithm<Integer> sortAlgorithm : sortAlgorithm) {
                //get a copy of inputArray so that we can give use the same array to test across all different kinds of sort
                inputArray = getACopyOfInputArray(localArray);
                sortAlgorithm.sort(inputArray);
                System.out.println(sortAlgorithm.getClass().getSimpleName() + ": Tested for " + SIZE + " elements");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Integer[] getACopyOfInputArray(Integer[] inputArray) {
        Integer[] copyArray = new Integer[inputArray.length];
        for (int i = 0; i < inputArray.length; i++) {
            copyArray[i] = inputArray[i];
        }
        return copyArray;
    }

}
