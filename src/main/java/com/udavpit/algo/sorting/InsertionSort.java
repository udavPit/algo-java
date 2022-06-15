package com.udavpit.algo.sorting;

public class InsertionSort<T extends Comparable<T>> implements Sorter<T> {

    @Override
    public void sort(T[] array) {
        int len = array.length;

        for (int i = 0; i < len; i++) {
            for (int j = i; j > 0 && less(array, j, j - 1); j--) {
                exch(array, j, j - 1);
            }
        }
    }
}
