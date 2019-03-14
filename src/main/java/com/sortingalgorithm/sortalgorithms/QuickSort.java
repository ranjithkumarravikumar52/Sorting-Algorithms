package com.sortingalgorithm.sortalgorithms;

import org.springframework.stereotype.Component;

@Component
public class QuickSort<T extends Comparable<T>> implements SortAlgorithm<T> {

    private T[] quickSort(T[] inputArray) {
        doQuickSort(inputArray, 0, inputArray.length - 1);
        return inputArray;
    }


    private int partition(T[] a, int p, int r) {

        T x = a[p];
        int i = p - 1;
        int j = r + 1;

        while (true) {
            // while (++i < r && a[i] < x) ;
            while (++i < r && a[i].compareTo(x) < 0) ;

            // while (--j > p && a[j] > x) ;
            while (--j > p && a[j].compareTo(x) > 0) ;

            if (i < j) {
                T tmp = a[i];
                a[i] = a[j];
                a[j] = tmp;
            } else {
                return j;
            }
        }
    }

    public void doQuickSort(T[] a, int p, int r) {
        if (p < r) {
            int q = partition(a, p, r);
            doQuickSort(a, p, q);
            doQuickSort(a, q + 1, r);
        }
    }

    @Override
    public T[] sort(T[] inputArray) {
        return quickSort(inputArray);
    }
}
