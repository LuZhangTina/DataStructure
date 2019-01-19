package com.tina.sort;

/**
 * Created by tina on 2019/1/19.
 */
public class MergeSort {
    private static enum SortType {
        ASCEND,
        DESCEND
    }
    private static void mergeAscend(int[] array, int firstStart, int firstEnd, int secondStart, int secondEnd) {
        if (secondEnd < firstStart) {
            return;
        }

        int[] temp = new int[secondEnd - firstStart + 1];
        int firstGroupIndex = firstStart;
        int secondGroupIndex = secondStart;
        for (int i = 0; i < secondEnd - firstStart + 1; i++) {
            if (firstGroupIndex > firstEnd && secondGroupIndex > secondEnd){
                break;
            } else if (firstGroupIndex > firstEnd) {
                temp[i] = array[secondGroupIndex];
                secondGroupIndex++;
            } else if (secondGroupIndex > secondEnd) {
                temp[i] = array[firstGroupIndex];
                firstGroupIndex++;
            } else if (array[firstGroupIndex] <= array[secondGroupIndex]) {
                temp[i] = array[firstGroupIndex];
                firstGroupIndex++;
            } else {
                temp[i] = array[secondGroupIndex];
                secondGroupIndex++;
            }
        }

        for (int i = firstStart; i <= secondEnd; i++) {
            array[i] = temp[i - firstStart];
        }
    }

    private static void mergeDescend(int[] array, int firstStart, int firstEnd, int secondStart, int secondEnd) {
        if (secondEnd < firstStart) {
            return;
        }

        int[] temp = new int[secondEnd - firstStart + 1];
        int firstGroupIndex = firstStart;
        int secondGroupIndex = secondStart;
        for (int i = 0; i < secondEnd - firstStart + 1; i++) {
            if (firstGroupIndex > firstEnd && secondGroupIndex > secondEnd){
                break;
            } else if (firstGroupIndex > firstEnd) {
                temp[i] = array[secondGroupIndex];
                secondGroupIndex++;
            } else if (secondGroupIndex > secondEnd) {
                temp[i] = array[firstGroupIndex];
                firstGroupIndex++;
            } else if (array[firstGroupIndex] >= array[secondGroupIndex]) {
                temp[i] = array[firstGroupIndex];
                firstGroupIndex++;
            } else {
                temp[i] = array[secondGroupIndex];
                secondGroupIndex++;
            }
        }

        for (int i = firstStart; i <= secondEnd; i++) {
            array[i] = temp[i - firstStart];
        }
    }

    private static void dissolve(int[] array, int start, int end, SortType sortTYPE) {
        if (start >= end) {
            return;
        }

        dissolve(array, start, (start + end) / 2, sortTYPE);
        dissolve(array, (start + end) / 2 + 1, end, sortTYPE);
        if (sortTYPE == SortType.ASCEND) {
            mergeAscend(array, start, (start + end) / 2, (start + end) / 2 + 1, end);
        } else {
            mergeDescend(array, start, (start + end) / 2, (start + end) / 2 + 1, end);
        }

    }
    public static void mergeSortAscend(int[] array) {
        dissolve(array, 0, array.length - 1, SortType.ASCEND);
    }
    public static void mergeSortDescend(int[] array) {
        dissolve(array, 0, array.length - 1, SortType.DESCEND);
    }
}
