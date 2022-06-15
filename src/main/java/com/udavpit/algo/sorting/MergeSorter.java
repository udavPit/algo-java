package com.udavpit.algo.sorting;

public interface MergeSorter<T extends Comparable<T>> extends Sorter<T> {

    default void merge(T[] array, T[] aux, int lo, int mid, int hi) {
        int i = lo;
        int j = mid + 1;

        System.arraycopy(array, lo, aux, lo, hi - lo + 1);

        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                array[k] = aux[j++];
            } else if (j > hi) {
                array[k] = aux[i++];
            } else if (less(aux, j, i)) {
                array[k] = aux[j++];
            } else {
                array[k] = aux[i++];
            }
        }
    }
}
