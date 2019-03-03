package com.sortingalgorithm.util.swapelements;

public interface ObjectSwappable<T> {
    /**
     * @param array input array
     * @param firstIndex element to be swapped with
     * @param secondIndex element to be swapped with
     */
    boolean swap(T[] array, int firstIndex, int secondIndex);

//    public boolean swap(T[] array, int firstIndex, int secondIndex) {
//        if (firstIndex == secondIndex) {
//            return false;
//        }
//
//        T temp = array[firstIndex];
//        array[firstIndex] = array[secondIndex];
//        array[secondIndex] = temp;
//        return true;
//    }
}
