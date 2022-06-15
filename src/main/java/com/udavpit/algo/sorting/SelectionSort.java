package com.udavpit.algo.sorting;

public class SelectionSort<T extends Comparable<T>> implements Sorter<T> {

    @Override
    public void sort(T[] array) {
        int len = array.length;
        int minIndex = 0;

        for (int i = 0; i < len; i++) {
            minIndex = i;

            for (int j = i + 1; j < len; j++) {
                if (less(array, j, minIndex)) {
                    minIndex = j;
                }
            }

            exch(array, i, minIndex);
        }
    }
}
