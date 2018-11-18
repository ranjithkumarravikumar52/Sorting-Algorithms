package client;

import fixeddatarange.CountingSort;
import fixeddatarange.RadixSort;
import RandomDataRange.*;
import Util.SortAlgorithm;

import java.util.Arrays;

//TODO once all the sort algorithms is cleaned, provide a way to implement in JAVA EE
//TODO change parameter stepsToSort to TimeTaken
public class App {

    public static void main(String[] args) {

        SortAlgorithm[] randomSortList = {new BubbleSort(), new InsertionSort(), new MergeSort(), new QuickSort(), new SelectionSort(), new ShellSort()};
        for (SortAlgorithm aRandomSortList : randomSortList) {
            randomSortClientModule(aRandomSortList);
        }

        System.out.println();

        SortAlgorithm[] fixedSortList = {new CountingSort(), new RadixSort()};
        for (SortAlgorithm aFixedSortList : fixedSortList) {
            fixedSortClientModule(aFixedSortList);
        }
    }

    private static void randomSortClientModule(SortAlgorithm sortAlgorithm) {
        int[] inputArray = sortAlgorithm.getInputArray();
        sortAlgorithm.sort(inputArray);

        int[] outputArray = sortAlgorithm.getOutputArray();
        System.out.println(Arrays.toString(outputArray));
    }

    private static void fixedSortClientModule(SortAlgorithm sortAlgorithm) {
        int[] inputArray = sortAlgorithm.getInputArray();
        sortAlgorithm.sort(inputArray);

        int[] outputArray = sortAlgorithm.getOutputArray();
        System.out.println(Arrays.toString(outputArray));
    }
}