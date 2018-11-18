package client;

import RandomDataRange.*;
import Util.ArrayGenerator;
import Util.SortAlgorithm;
import Util.WriteDataToExcel;

import java.io.IOException;

//TODO once all the sort algorithms is cleaned, provide a way to implement in JAVA EE
public class App {

    private static int SIZE = 11;
    private static int SIMULATION_COUNT = 10;

    public static void main(String[] args) {

        while(SIZE > 10){
            ArrayGenerator.SIZE = SIZE;
            System.out.println("SIZE: "+SIZE+" ...");
            doSimulation();
            SIZE = SIZE - 10;
        }

    }

    private static void doSimulation() {
        for (int i = 1; i <= SIMULATION_COUNT; i++) {
            System.out.println("SIMULATION COUNT: "+i+" ...");
            SortAlgorithm[] randomSortList = {
                    new BubbleSort(),
                    new SelectionSort(),
                    new InsertionSort(),
                    new MergeSort(),
                    new QuickSort(),
                    new ShellSort(),
//                new CountingSort(),
//                new RadixSort()
            };
            for (SortAlgorithm aRandomSortList : randomSortList) {
                sortClientModule(aRandomSortList);
            }

            try {
                WriteDataToExcel.writeData(randomSortList);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        try {
            WriteDataToExcel.closeStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void sortClientModule(SortAlgorithm sortAlgorithm) {
        int[] inputArray = sortAlgorithm.getInputArray();
        sortAlgorithm.sort(inputArray);
        System.out.println(sortAlgorithm.getSortAlgorithmName() + ": " + sortAlgorithm.getTotalTime() + "ms");
        System.out.println();
    }

}