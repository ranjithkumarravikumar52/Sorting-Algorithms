package randomdatarange;


import util.SortAlgorithm;

/**
 * This class extends SortAlgorithm.
 * This class is implemented for SortAlgorithm classes where the data to be sorted could be of random order.
 * <p>In other words, there is no requirement about the order of the input elements to be sorted.</p>
 * <p>The classes that extends this classes are as follows: </p>
 * <ul>
 *     <li>Bubble Sort</li>
 *     <li>Insertion Sort</li>
 *     <li>Merge Sort</li>
 *     <li>Quick Sort</li>
 *     <li>Selection Sort</li>
 *     <li>Shell Sort</li>
 * </ul>
 */

abstract class RandomDataRangeSortAlgorithm extends SortAlgorithm {

    //This class can be a medium to be common array that could be used by all the SortAlgorithms
//    private static int[] unSortedArray = IntegerArrayGenerator.getRandomDataRangeArray();

//    static int[] getUnSortedArray() {
//        return unSortedArray;
//    }
}
