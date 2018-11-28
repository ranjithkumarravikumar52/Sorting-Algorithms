package client;

import org.junit.Test;
import sortalgorithms.*;
import util.dao.DataAnalysis;
import util.dao.IntegerDataAnalysis;
import util.datapersistence.DataPersistence;
import util.formattype.ExcelFormat;
import util.formattype.FormatType;
import util.generator.IntegerArrayGenerator;
import util.metric.TimeMetric;

import java.util.ArrayList;
import java.util.List;

public class SequenceSimulationAppTest {

    private final int SIMULATION_COUNT = 5;
    private int[] SIZE = {10, 100, 1000, 10_000, 100_000, 1_000_000, 10_000_000};
//    private int[] SIZE = {100, 1000, 10_000, 20_000, 30_000, 40_000, 50_000, 60_000, 70_000, 80_000, 90_000, 100_000};
    private Integer[] inputArray;
    private TimeMetric metric = new TimeMetric();
    private DataAnalysis<Integer> integerDataAnalysis;
    private String[] userInputHeaders = {"sortAlgorithmName", "dataSize", "metricMeasure", "inputArray", "outputArray"};
    private FormatType excel = new ExcelFormat(userInputHeaders);
    private DataPersistence dataPersistence;

    @Test
    public void checkSequentialSimulation() throws Exception {
        //TODO factory pattern here
        List<SortAlgorithm<Integer>> sortAlgorithms = new ArrayList<>();
        sortAlgorithms.add(new BubbleSort());
        sortAlgorithms.add(new InsertionSort());
        sortAlgorithms.add(new MergeSort());
        sortAlgorithms.add(new QuickSort());
        sortAlgorithms.add(new SelectionSort());
        sortAlgorithms.add(new ShellSort());

        for (int count = 1; count <= SIMULATION_COUNT; count++) {
            for (int i : SIZE) {
                inputArray = new IntegerArrayGenerator().generateArray(i, 1, 11);
                doOneRoundOfSimulation(sortAlgorithms, i);
                System.out.println("Simulation: " + count + " completed for " + i + " size");
                System.out.println();
            }
        }

    }

    private void doOneRoundOfSimulation(List<SortAlgorithm<Integer>> sortAlgorithms, int SIZE) {
        for (SortAlgorithm<Integer> algorithm : sortAlgorithms) {
            Integer[] localCopy = arraysCopy(inputArray);

            metric.startTime();
            Integer[] outputArray = algorithm.sort(localCopy);
            metric.endTime();

            integerDataAnalysis = new IntegerDataAnalysis(algorithm.getClass().getSimpleName(), SIZE, metric, inputArray, outputArray);

            dataPersistence = new DataPersistence(integerDataAnalysis, excel);
            dataPersistence.saveData();

            System.out.println(algorithm.getClass().getSimpleName() + ": " + SIZE + " elements");
        }
    }

    private Integer[] arraysCopy(Integer[] inputArray) {
        Integer[] localCopy = new Integer[inputArray.length];
        System.arraycopy(inputArray, 0, localCopy, 0, inputArray.length);
        return localCopy;
    }

}