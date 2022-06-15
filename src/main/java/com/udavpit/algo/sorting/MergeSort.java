package com.udavpit.algo.sorting;

import java.util.Arrays;

public class MergeSort<T extends Comparable<T>> implements MergeSorter<T> {

    private T[] aux;

    private void sort(T[] array, int lo, int hi) {
        if (hi <= lo) return;

        int mid = lo + (hi - lo) / 2;

        sort(array, lo, mid);
        sort(array, mid + 1, hi);
        merge(array, aux, lo, mid, hi);
    }

    @Override
    public void sort(T[] array) {
        aux = Arrays.copyOf(array, array.length);
        sort(array, 0, array.length - 1);
    }
}
