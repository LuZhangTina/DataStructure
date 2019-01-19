package com.tina.sort;

/**
 * Created by tina on 2019/1/18.
 */
public class InsertSort {
    public static void insertSortAscend(int[] array){
        if (array == null) {
            return;
        }

        for (int i = 1; i < array.length; i++) {
            int temp = array[i];
            int j = i-1;
            for (; j >= 0; j--) {
                if (temp < array[j]){
                    array[j+1] = array[j];
                } else {
                    break;
                }
            }
            array[j+1] = temp;
        }
    }
    public static void insertSortDescend(int[] array){
        if (array == null) {
            return;
        }

        for (int i = 1; i < array.length; i++) {
            int temp = array[i];
            int j = i-1;
            for (; j >= 0; j--) {
                if (temp > array[j]){
                    array[j+1] = array[j];
                } else {
                    break;
                }
            }
            array[j+1] = temp;
        }
    }
}
