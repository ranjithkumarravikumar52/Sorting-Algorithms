package Util;

import java.util.Random;

public class ArrayGenerator {

    private static int[] randomArray;
    private static int[] fixedArray;
    public static int SIZE;

    public static int[] getRandomDataRangeArray() {
        Random rand = new Random();
        randomArray = new int[SIZE];
        for (int i = 0; i < SIZE; i++) {
            randomArray[i] = rand.nextInt(SIZE);
        }
        System.out.println("Given random - unsorted Array of size: "+SIZE+" integers");
        System.out.println();
        return randomArray;
    }

    public static int[] getFixedDataRangeArray(int min, int max) {
        int size = max - min + 1;
        Random rand = new Random();
        fixedArray = new int[SIZE];
        for (int i = 0; i < fixedArray.length; i++) {
            fixedArray[i] = rand.nextInt(max - min) + min;
        }
        return fixedArray;
    }

}
