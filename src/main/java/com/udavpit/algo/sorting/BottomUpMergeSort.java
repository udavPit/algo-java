package com.udavpit.algo.sorting;

import java.util.Arrays;

public class BottomUpMergeSort<T extends Comparable<T>> implements MergeSorter<T> {

    @Override
    public void sort(T[] array) {
        int len = array.length;
        T[] aux = Arrays.copyOf(array, len);

        for (int sz = 1; sz < len; sz += sz) {
            for (int i = 0; i < len - sz; i += sz + sz) {
                merge(array, aux, i, i + sz - 1, Math.min(i + sz + sz - 1, len - 1));
            }
        }
    }
}
