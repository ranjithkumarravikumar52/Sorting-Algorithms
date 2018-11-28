package client;

import org.junit.Test;
import sortalgorithms.*;
import util.dao.DataAnalysis;
import util.dao.IntegerDataAnalysis;
import util.datapersistence.DataPersistence;
import util.debugcolor.DebugColor;
import util.formattype.ExcelFormat;
import util.formattype.FormatType;
import util.generator.IntegerArrayGenerator;
import util.metric.TimeMetric;

import java.util.ArrayList;
import java.util.List;

public class SequenceSimulationAppTest {

    private final int SIMULATION_COUNT = 10;
    //    private int[] SIZE = {10, 100, 1000, 10_000, 100_000, 1_000_000, 10_000_000};
    //    private int[] SIZE = {25_000};
    private int[] SIZE = {100, 200, 300, 400, 500, 600, 700, 800, 900, 1000, 2000, 3000, 4000, 5000, 6000, 7000, 8000, 9000, 10_000, 20_000, 30_000, 40_000, 50_000, 60_000, 70_000, 80_000, 90_000, 100_000};
    private Integer[] inputArray;
    private TimeMetric metric = new TimeMetric();
    private DataAnalysis<Integer> integerDataAnalysis;
    private String[] userInputHeaders = {"sortAlgorithmName", "dataSize", "metricMeasure"};
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

        for (int i : SIZE) {
            for (int count = 1; count <= SIMULATION_COUNT; count++) {
                inputArray = new IntegerArrayGenerator().generateArray(i, 1, 11);
                long sum = doOneRoundOfSimulation(sortAlgorithms, i);

                System.out.println(new StringBuilder()
                        .append(count != SIMULATION_COUNT ? DebugColor.ANSI_RED + count : DebugColor.ANSI_GREEN + count)
                        .append(DebugColor.ANSI_RESET)
                        .append("/")
                        .append(SIMULATION_COUNT)
                        .append(" completed for ")
                        .append(DebugColor.ANSI_PURPLE)
                        .append(i)
                        .append(DebugColor.ANSI_RESET)
                        .append(" size in ")
                        .append(DebugColor.ANSI_RED)
                        .append(sum)
                        .append(DebugColor.ANSI_RESET)
                        .append(" ms")
                        .toString());
                System.out.println();
            }
        }

    }

    private long doOneRoundOfSimulation(List<SortAlgorithm<Integer>> sortAlgorithms, int SIZE) {
        long sum = 0;
        for (SortAlgorithm<Integer> algorithm : sortAlgorithms) {
            Integer[] localCopy = arraysCopy(inputArray);

            metric.startTime();
            algorithm.sort(localCopy);
            metric.endTime();

            integerDataAnalysis = new IntegerDataAnalysis(algorithm.getClass().getSimpleName(), SIZE, metric);

            dataPersistence = new DataPersistence(integerDataAnalysis, excel);
            dataPersistence.saveData();

            sum += metric.getTotalMetric();
            System.out.println(new StringBuilder()
                    .append(algorithm.getClass().getSimpleName())
                    .append(": Sorted ")
                    .append(SIZE)
                    .append(" elements in ")
                    .append(DebugColor.ANSI_BLUE)
                    .append(metric.getTotalMetric())
                    .append(DebugColor.ANSI_RESET)
                    .append(" ms")
                    .toString());
        }
        return sum;
    }

    private Integer[] arraysCopy(Integer[] inputArray) {
        Integer[] localCopy = new Integer[inputArray.length];
        System.arraycopy(inputArray, 0, localCopy, 0, inputArray.length);
        return localCopy;
    }

}