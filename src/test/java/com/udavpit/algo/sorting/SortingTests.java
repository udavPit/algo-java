package com.udavpit.algo.sorting;

import net.jqwik.api.ForAll;
import net.jqwik.api.Property;
import net.jqwik.api.constraints.Size;
import net.jqwik.api.lifecycle.BeforeContainer;

import java.util.Arrays;

public class SortingTests {

    private static Sorter<Integer> selectionSorter;
    private static Sorter<Integer> insertionSorter;
    private static Sorter<Integer> mergeSorter;
    private static Sorter<Integer> buMergeSorter;
    private static Sorter<Integer> quickSorter;

    @BeforeContainer
    static void init() {
        selectionSorter = SorterFactory.createSelectionSorter();
        insertionSorter = SorterFactory.createInsertionSorter();
        mergeSorter = SorterFactory.createMergeSorter();
        buMergeSorter = SorterFactory.createBUMergeSorter();
        quickSorter = SorterFactory.createQuickSort();
    }

    @Property
    boolean selectionSortIntArray(@ForAll @Size(max = 1000) Integer[] array) {
        return sortIntArrayProperty(array, selectionSorter);
    }

    @Property
    boolean insertionSortIntArray(@ForAll @Size(max = 1000) Integer[] array) {
        return sortIntArrayProperty(array, insertionSorter);
    }

    @Property
    boolean mergeSortIntArray(@ForAll @Size(max = 1000) Integer[] array) {
        return sortIntArrayProperty(array, mergeSorter);
    }

    @Property
    boolean bottomUpMergeSortIntArray(@ForAll @Size(max = 1000) Integer[] array) {
        return sortIntArrayProperty(array, buMergeSorter);
    }

    @Property
    boolean quickSortIntArray(@ForAll @Size(max = 1000) Integer[] array) {
        return sortIntArrayProperty(array, quickSorter);
    }

    private <T extends Comparable<T>> boolean sortIntArrayProperty(T[] array, Sorter<T> sorter) {
        T[] copy = Arrays.copyOf(array, array.length);
        T[] aux = Arrays.copyOf(array, array.length);

        Arrays.sort(aux);
        sorter.sort(copy);

        return Arrays.equals(copy, aux);
    }
}
