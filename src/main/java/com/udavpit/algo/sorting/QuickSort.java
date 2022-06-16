package com.udavpit.algo.sorting;

import java.util.Random;

public class QuickSort<T extends Comparable<T>> implements Sorter<T> {

    private void shuffle(T[] array) {
        Random random = new Random();

        for (int i = array.length; i > 1; i--) {
            int idx = random.nextInt(i);
            exch(array, idx, i - 1);
        }
    }

    private int partition(T[] array, int lo, int hi) {
        T p = array[lo];
        int j = lo;

        for (int i = lo + 1; i <= hi; i++) {
            if (array[i].compareTo(p) <= 0) {
                exch(array, ++j, i);
            }
        }

        exch(array, lo, j);

        return j;
    }

    private void sort(T[] array, int lo, int hi) {
        if (hi <= lo) return;

        int j = partition(array, lo, hi);

        sort(array, lo, j - 1);
        sort(array, j + 1, hi);
    }

    @Override
    public void sort(T[] array) {
        shuffle(array);
        sort(array, 0, array.length - 1);
    }
}
