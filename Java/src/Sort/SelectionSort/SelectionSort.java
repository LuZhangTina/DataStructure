package com.tina.sort;

/**
 * Created by tina on 2019/1/18.
 */
public class SelectionSort {
    public static void selectionSortAscend(int[] array) {
        if (array == null) {
            return;
        }

        for (int i = 0; i < array.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j <array.length; j++) {
                if (array[minIndex] > array[j]) {
                    minIndex = j;
                }
            }
            int temp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = temp;
        }
    }
    public static void selectionSortDescend(int[] array) {
        if (array == null) {
            return;
        }

        for (int i = 0; i < array.length - 1; i++) {
            int maxIndex = i;
            for (int j = i + 1; j <array.length; j++) {
                if (array[maxIndex] < array[j]) {
                    maxIndex = j;
                }
            }
            int temp = array[i];
            array[i] = array[maxIndex];
            array[maxIndex] = temp;
        }
    }
}
