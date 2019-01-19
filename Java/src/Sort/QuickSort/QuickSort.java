package com.tina.sort;

/**
 * Created by tina on 2019/1/19.
 */
public class QuickSort {
    private enum SortType{
        ASCEND,
        DESCEND
    }

    private static int partitionAscend(int[] array, int start, int end) {
        // i indicate the next position for the element which is smaller than array[end]
        int i = start;
        for (int j = start; j < end; j++) {
            if (array[j] < array[end]) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
            }
        }
        int temp = array[end];
        array[end] = array[i];
        array[i] = temp;

        return i;
    }

    private static int partitionDescend(int[] array, int start, int end) {
        // i indicate the next position for the element which is larger than array[end]
        int i = start;
        for (int j = start; j < end; j++) {
            if (array[j] > array[end]) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
            }
        }
        int temp = array[end];
        array[end] = array[i];
        array[i] = temp;

        return i;
    }

    private static void dissolve(int[] array, int start, int end, SortType sortType) {
        if (start >= end) {
            return;
        }
        int pivot = 0;
        if (sortType == SortType.ASCEND) {
            pivot = partitionAscend(array, start, end);
        } else {
            pivot = partitionDescend(array, start, end);
        }

        dissolve(array, start, pivot - 1, sortType);
        dissolve(array, pivot + 1, end, sortType);
    }

    public static void quickSortAscend(int[] array) {
        dissolve(array, 0, array.length - 1, SortType.ASCEND);
    }

    public static void quickSortDescend(int[] array) {
        dissolve(array, 0, array.length - 1, SortType.DESCEND);
    }
}
