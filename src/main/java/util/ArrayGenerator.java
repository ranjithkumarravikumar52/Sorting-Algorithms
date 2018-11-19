package util;

import java.util.Random;

public class ArrayGenerator {

    private int size;
    private int[] randomArray;
    private int[] fixedArray;

    ArrayGenerator(int size) {
        this.size = size;
    }

    int[] generateRandomRangeArray() {
        Random rand = new Random();
        randomArray = new int[size];
        for (int i = 0; i < size; i++) {
            randomArray[i] = rand.nextInt(size);
        }
        return randomArray;
    }

    public int[] generateFixedDataRangeArray(int min, int max) {
        Random rand = new Random();
        fixedArray = new int[max - min + 1];
        for (int i = 0; i < fixedArray.length; i++) {
            fixedArray[i] = rand.nextInt(max - min) + min;
        }
        return fixedArray;
    }


    public int[] getRandomArray() {
        return randomArray;
    }


    public int[] getFixedArray() {
        return fixedArray;
    }

}
