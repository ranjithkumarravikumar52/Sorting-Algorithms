package util;

public class SwapElements {
    /**
     * Every time there is a swap operation between two variables the stepsToSort count increases
     * @param array input array
     * @param i element to be swapped with
     * @param j element to be swapped with
     */
    public static void swap(int[] array, int i, int j) {
        if (i == j) {
            return;
        }

        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
