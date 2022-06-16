package com.udavpit.algo.sorting;

import java.util.Arrays;
import java.util.stream.Collectors;

public interface Sorter<T extends Comparable<T>> {

    default void show(T[] array) {
        String joined = Arrays.stream(array)
                .map(Object::toString)
                .collect(Collectors.joining(", ", "[", "]"));

        System.out.println(joined);
    }

    default void exch(T[] array, int i, int j) {
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    default boolean less(T[] array, int i, int j) {
        return array[i].compareTo(array[j]) < 0;
    }

    default boolean lessOrEq(T[] array, int i, int j) {
        return array[i].compareTo(array[j]) <= 0;
    }

    default void run(T[] array) {
        show(array);
        sort(array);
        show(array);
    }

    void sort(T[] array);
}
