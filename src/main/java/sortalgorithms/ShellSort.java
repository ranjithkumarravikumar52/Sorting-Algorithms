/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortalgorithms;

public class ShellSort extends SortAlgorithm {


    private int[] shellSort(int[] inputArray) {
        int[] localArray = new int[inputArray.length];
        System.arraycopy(inputArray, 0, localArray, 0, localArray.length);
        for (int gap = localArray.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < localArray.length; i++) {
                int newElement = localArray[i];
                int j = i;
                while (j >= gap && localArray[j - gap] > newElement) {
                    localArray[j] = localArray[j - gap];
                    j = j - gap;
                }
                localArray[j] = newElement;
            }
        }
        return localArray;
    }

    @Override
    public int[] sort(int[] inputArray) {
        return shellSort(inputArray);
    }
}
