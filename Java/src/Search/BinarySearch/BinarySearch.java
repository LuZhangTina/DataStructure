package com.tina.search;

import java.util.Comparator;

/**
 * Created by tina on 2019/1/20.
 *
 * Implement Binary Search Algorithm
 *
 * eg.
 * BinarySearch<Integer> binarySearch = new BinarySearch<Integer>();
 * Integer[] array = new Integer[]{2, 5, 8, 10, 11, 13};
 * int index = binarySearch.binarySearch(array, 10, null);
 * Assert.assertEquals(3, index);
 *
 * BinarySearch<String> binarySearchString = new BinarySearch<String>();
 * String[] arrayString = new String[]{"apple", "define", "google", "year", "zoo"};
 * index = binarySearchString.binarySearch(arrayString, "HELLO", null);
 * Assert.assertEquals(-1, index);
 */
public class BinarySearch<T> {
    public BinarySearch(){
        // do nothing
    }

    public int binarySearch(T[] array, T obj, Comparator<? super T> comparator) {
        if (array == null) {
            return -1;
        }

        return searchRecursion(array, 0, array.length - 1, obj, comparator);
    }

    private int searchRecursion(T[] array, int lowIdx, int highIdx, T obj, Comparator<? super T> comparator) {
        // can't find the  object
        if (lowIdx > highIdx) {
            return -1;
        }

        int finalIdx = -1;
        int compareResult = 0;
        int midIdx = lowIdx + ((highIdx - lowIdx) >>> 1);
        if (comparator != null) {
            compareResult = comparator.compare(obj, array[midIdx]);
        } else {
            compareResult = ((Comparable)obj).compareTo(array[midIdx]);
        }
        if (compareResult == 0) {
            finalIdx = midIdx;
        } else if (compareResult > 0) {
            finalIdx = searchRecursion(array, midIdx + 1, highIdx, obj, comparator);
        } else if (compareResult < 0) {
            finalIdx = searchRecursion(array, lowIdx, midIdx - 1, obj, comparator);
        }
        return finalIdx;
    }
}
