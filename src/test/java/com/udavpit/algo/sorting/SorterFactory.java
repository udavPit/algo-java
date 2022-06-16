package com.udavpit.algo.sorting;

public class SorterFactory {

    public static Sorter<Integer> createSelectionSorter() {
        return new SelectionSort<>();
    }

    public static Sorter<Integer> createInsertionSorter() {
        return new InsertionSort<>();
    }

    public static Sorter<Integer> createMergeSorter() {
        return new MergeSort<>();
    }

    public static Sorter<Integer> createBUMergeSorter() {
        return new BottomUpMergeSort<>();
    }

    public static Sorter<Integer> createQuickSort() {
        return new QuickSort<>();
    }
}
