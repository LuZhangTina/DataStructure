package com.tina.sort;

/**
 * Created by tina on 2019/1/18.
 */
public class BubbleSort {
    public static void bubbleSortAscend(int[] array) {
        if (null == array) {
            return;
        }

        for (int i = 0; i < array.length - 1; i++) {
            boolean switchFlag = false;
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    switchFlag = true;
                }
            }
            if (false == switchFlag) {
                return;
            }
        }
    }

    public static void bubbleSortDescend(int[] array) {
        if (null == array) {
            return;
        }

        for (int i = 0; i < array.length - 1; i++) {
            boolean switchFlag = false;
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] < array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    switchFlag = true;
                }
            }
            if (false == switchFlag) {
                return;
            }
        }
    }
}
