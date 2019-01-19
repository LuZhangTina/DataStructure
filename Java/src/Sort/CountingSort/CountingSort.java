package com.tina.sort;

/**
 * Created by tina on 2019/1/19.
 */
public class CountingSort {
    public static void countingSort(int[] array) {
        if (array == null) {
            return;
        }
//        find bucket's range
        int max = array[0];
        int min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (max < array[i]) {
                max = array[i];
            }
            if (min > array[i]) {
                min = array[i];
            }
        }

//        creat counting bucket
        int[] countingBucket = new int[max - min + 1];
        for (int i = 0; i < array.length; i++) {
            countingBucket[array[i] - min]++;
        }

//        update counting bucket to sum bucket
        for (int i = 1; i < countingBucket.length; i++) {
            countingBucket[i] = countingBucket[i] + countingBucket[i - 1];
        }
//        put array's element in a new array based on the value in counting bucket
        int[] result = new int[array.length];
        for (int i = array.length - 1; i >= 0; i--) {
            int indexInResult = countingBucket[array[i] - min] - 1;
            countingBucket[array[i] - min] = countingBucket[array[i] - min] - 1;
            result[indexInResult] = array[i];
        }
        System.arraycopy(result, 0, array, 0, array.length);
    }
}
