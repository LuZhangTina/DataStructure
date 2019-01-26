package com.tina.search;

import java.util.Comparator;

/**
 * Created by tina on 2019/1/20.
 *
 * Implement Binary Search Algorithm
 *
 * Method: findEqual(T[] array, T obj, Comparator<? super T> comparator)
 *
 * @Test
   public void testFindEqual() throws Exception {
       Integer[] array = new Integer[]{1, 2, 3, 5, 7};
       int idx = BinarySearch.findEqual(array, 2, null);
       Assert.assertEquals(1, idx);
       idx = BinarySearch.findEqual(array, 8, null);
       Assert.assertEquals(-1, idx);
   }
 *
 *
 * Method: findFirstEqual(T[] array, T obj, Comparator<? super T> comparator)
 *
 * @Test
   public void testFindFirstEqual() throws Exception {
        Integer[] array = new Integer[]{1, 1, 1, 2, 3, 5, 7};
        int idx = BinarySearch.findFirstEqual(array, 1, null);
        Assert.assertEquals(0, idx);
        idx = BinarySearch.findFirstEqual(array, 8, null);
        Assert.assertEquals(-1, idx);
   }
 *
 *
 * Method: findLastEqual(T[] array, T obj, Comparator<? super T> comparator)
 *
 * @Test
   public void testFindLastEqual() throws Exception {
        Integer[] array = new Integer[]{1, 1, 1, 2, 3, 5, 7};
        int idx = BinarySearch.findLastEqual(array, 1, null);
        Assert.assertEquals(2, idx);
        idx = BinarySearch.findLastEqual(array, 8, null);
        Assert.assertEquals(-1, idx);
   }
 *
 *
 * Method: findFirstLargerOrEqual(T[] array, T obj, Comparator<? super T> comparator)
 *
 * @Test
   public void testFindFirstLargerOrEqual() throws Exception {
        Integer[] array = new Integer[]{1, 1, 1, 2, 3, 5, 7};
        int idx = BinarySearch.findFirstLargerOrEqual(array, 4, null);
        Assert.assertEquals(5, idx);
        idx = BinarySearch.findFirstLargerOrEqual(array, 5, null);
        Assert.assertEquals(5, idx);
        idx = BinarySearch.findFirstLargerOrEqual(array, 1, null);
        Assert.assertEquals(0, idx);
        idx = BinarySearch.findFirstLargerOrEqual(array, 8, null);
        Assert.assertEquals(-1, idx);
   }
 *
 *
 * Method: findLastSmallerOrEqual(T[] array, T obj, Comparator<? super T> comparator)
 *
 * @Test
   public void testFindLastSmallerOrEqual() throws Exception {
        Integer[] array = new Integer[]{1, 1, 1, 2, 3, 5, 7};
        int idx = BinarySearch.findLastSmallerOrEqual(array, 4, null);
        Assert.assertEquals(4, idx);
        idx = BinarySearch.findLastSmallerOrEqual(array, 5, null);
        Assert.assertEquals(5, idx);
        idx = BinarySearch.findLastSmallerOrEqual(array, 1, null);
        Assert.assertEquals(2, idx);
        idx = BinarySearch.findLastSmallerOrEqual(array, 8, null);
        Assert.assertEquals(6, idx);
        idx = BinarySearch.findLastSmallerOrEqual(array, -1, null);
        Assert.assertEquals(-1, idx);
   }
 *
 *
 * * Method: findEqualInCircularList(T[] array, T obj, Comparator<? super T> comparator)
 *
 * @Test
   public void testFindEqualInCircularList() throws Exception {
        Integer[] array = new Integer[]{4, 5, 6, 2, 3};
        int idx = BinarySearch.findEqualInCircularList(array, 2, null);
        Assert.assertEquals(3, idx);
        idx = BinarySearch.findEqualInCircularList(array, 3, null);
        Assert.assertEquals(4, idx);
        idx = BinarySearch.findEqualInCircularList(array, 6, null);
        Assert.assertEquals(2, idx);
        idx = BinarySearch.findEqualInCircularList(array, 4, null);
        Assert.assertEquals(0, idx);
        idx = BinarySearch.findEqualInCircularList(array, 7, null);
        Assert.assertEquals(-1, idx);
   }
 *
 */

public class BinarySearch {
    /** Find the element which is equal to the obj in an array.
     *  The array is ascending ordered and has no repeat elements */
    public static <T> int findEqual(T[] array, T obj, Comparator<? super T> comparator) {
        if (array == null) {
            return -1;
        }

        return searchRecursionEqual(array, 0, array.length - 1, obj, comparator);
    }

    /** Find the first element that equals to the obj in an array.
     *  The array is ascending ordered and may have repeat elements */
    public static <T> int findFirstEqual(T[] array, T obj, Comparator<? super T> comparator) {
        if (array == null) {
            return -1;
        }

        return searchRecursionFirstEqual(array, 0, array.length - 1, obj, comparator);
    }

    /** Find the last element equals to the obj in an array.
     *  The array is ascending ordered and may have repeat elements */
    public static <T> int findLastEqual(T[] array, T obj, Comparator<? super T> comparator) {
        if (array == null) {
            return -1;
        }

        return searchRecursionLastEqual(array, 0, array.length - 1, obj, comparator);
    }

    /** Find the first element which is equal to or larger than the obj in an array.
     *  The array is ascending ordered and may have repeat elements */
    public static <T> int findFirstLargerOrEqual(T[] array, T obj, Comparator<? super T> comparator) {
        if (array == null) {
            return -1;
        }

        return searchRecursionFirstLargerOrEqual(array, 0, array.length - 1, obj, comparator);
    }

    /** Find the last element which is equal to or smaller than the obj in an array.
     *  The array is ascending ordered and may have repeat elements */
    public static <T> int findLastSmallerOrEqual(T[] array, T obj, Comparator<? super T> comparator) {
        if (array == null) {
            return -1;
        }

        return searchRecursionLastSmallerOrEqual(array, 0, array.length - 1, obj, comparator);
    }

    /** Find the element which is equal to the obj in an array.
     *  The array is circular ascending ordered and has no repeat elements */
    public static <T> int findEqualInCircularList(T[] array, T obj, Comparator<? super T> comparator) {
        if (array == null) {
            return -1;
        }

        return searchEqualInCircularArray(array, 0, array.length - 1, obj, comparator);
    }

    private static <T> int searchRecursionEqual(T[] array, int lowIdx, int highIdx, T obj, Comparator<? super T> comparator) {
        /** can't find the object */
        if (lowIdx > highIdx) {
            return -1;
        }

        int finalIdx = 0;
        int midIdx = lowIdx + ((highIdx - lowIdx) >>> 1);
        int compareResult = getCompareResult(array, obj, comparator, midIdx);

        if (compareResult == 0) {
            finalIdx = midIdx;
        } else if (compareResult > 0) {
            finalIdx = searchRecursionEqual(array, midIdx + 1, highIdx, obj, comparator);
        } else if (compareResult < 0) {
            finalIdx = searchRecursionEqual(array, lowIdx, midIdx - 1, obj, comparator);
        }
        return finalIdx;
    }

    private static <T> int searchRecursionFirstEqual(T[] array, int lowIdx, int highIdx, T obj, Comparator<? super T> comparator) {
        /** can't find the object */
        if (lowIdx > highIdx) {
            return -1;
        }

        int finalIdx;
        int midIdx = lowIdx + ((highIdx - lowIdx) >>> 1);
        int compareResult = getCompareResult(array, obj, comparator, midIdx);

        if (compareResult > 0) {
            finalIdx = searchRecursionFirstEqual(array, midIdx + 1, highIdx, obj, comparator);
        } else if (compareResult < 0) {
            finalIdx = searchRecursionFirstEqual(array, lowIdx, midIdx - 1, obj, comparator);
        } else {
            if (0 == midIdx || getCompareResult(array, obj, comparator, midIdx - 1) > 0) {
                finalIdx = midIdx;
            } else {
                finalIdx = searchRecursionFirstEqual(array, lowIdx, midIdx - 1, obj, comparator);
            }
        }
        return finalIdx;
    }

    private static <T> int searchRecursionLastEqual(T[] array, int lowIdx, int highIdx, T obj, Comparator<? super T> comparator) {
        /** can't find the object */
        if (lowIdx > highIdx) {
            return -1;
        }

        int finalIdx;
        int midIdx = lowIdx + ((highIdx - lowIdx) >>> 1);
        int compareResult = getCompareResult(array, obj, comparator, midIdx);

        if (compareResult > 0) {
            finalIdx = searchRecursionLastEqual(array, midIdx + 1, highIdx, obj, comparator);
        } else if (compareResult < 0) {
            finalIdx = searchRecursionLastEqual(array, lowIdx, midIdx - 1, obj, comparator);
        } else {
            if (array.length - 1 == midIdx || getCompareResult(array, obj, comparator, midIdx + 1) < 0) {
                finalIdx = midIdx;
            } else {
                finalIdx = searchRecursionLastEqual(array, midIdx + 1, highIdx, obj, comparator);
            }
        }
        return finalIdx;
    }

    private static <T> int searchRecursionFirstLargerOrEqual(T[] array, int lowIdx, int highIdx, T obj, Comparator<? super T> comparator) {
        /** can't find the object */
        if (lowIdx > highIdx) {
            return -1;
        }

        int finalIdx;
        int midIdx = lowIdx + ((highIdx - lowIdx) >>> 1);
        int compareResult = getCompareResult(array, obj, comparator, midIdx);

        if (compareResult > 0) {
            finalIdx = searchRecursionFirstLargerOrEqual(array, midIdx + 1, highIdx, obj, comparator);
        } else {
            if (0 == midIdx || getCompareResult(array, obj, comparator, midIdx - 1) > 0) {
                finalIdx = midIdx;
            } else {
                finalIdx = searchRecursionFirstLargerOrEqual(array, lowIdx, midIdx - 1, obj, comparator);
            }
        }
        return finalIdx;
    }

    private static <T> int searchRecursionLastSmallerOrEqual(T[] array, int lowIdx, int highIdx, T obj, Comparator<? super T> comparator) {
        /** can't find the object */
        if (lowIdx > highIdx) {
            return -1;
        }

        int finalIdx;
        int midIdx = lowIdx + ((highIdx - lowIdx) >>> 1);
        int compareResult = getCompareResult(array, obj, comparator, midIdx);

        if (compareResult < 0) {
            finalIdx = searchRecursionLastSmallerOrEqual(array, lowIdx, midIdx - 1, obj, comparator);
        } else {
            if (array.length - 1 == midIdx || getCompareResult(array, obj, comparator, midIdx + 1) < 0) {
                finalIdx = midIdx;
            } else {
                finalIdx = searchRecursionLastSmallerOrEqual(array, midIdx + 1, highIdx, obj, comparator);
            }
        }
        return finalIdx;
    }

    private static <T> int searchEqualInCircularArray(T[] array, int lowIdx, int highIdx, T obj, Comparator<? super T> comparator) {
        if (lowIdx > highIdx) {
            return -1;
        }

        if (lowIdx == highIdx) {
            if (getCompareResult(array, obj, comparator, lowIdx) == 0) {
                return lowIdx;
            }
            else {
                return -1;
            }
        }

        int midIdx = lowIdx + ((highIdx - lowIdx) >>> 1);
        if (getCompareResult(array, obj, comparator, midIdx) == 0) {
            return midIdx;
        }

        int orderedLowIdx = 0;
        int orderedHighIdx = 0;
        int circularLowIdx = 0;
        int circularHighIdex = 0;
        if (getCompareResult(array, array[midIdx], comparator, lowIdx) > 0) {
            orderedHighIdx = midIdx;
            orderedLowIdx = lowIdx;
            circularHighIdex = highIdx;
            circularLowIdx = midIdx + 1;
        } else {
            orderedHighIdx = highIdx;
            orderedLowIdx = midIdx + 1;
            circularHighIdex = midIdx;
            circularLowIdx = lowIdx;
        }

        int finalIdx;
        int compareResultOrderLow = getCompareResult(array, obj, comparator, orderedLowIdx);
        int compareResultOrderHigh = getCompareResult(array, obj, comparator, orderedHighIdx);
        if (compareResultOrderLow >= 0 && compareResultOrderHigh <= 0) {
            finalIdx = searchRecursionEqual(array, orderedLowIdx, orderedHighIdx, obj, comparator);
        } else {
            finalIdx = searchEqualInCircularArray(array, circularLowIdx, circularHighIdex, obj, comparator);
        }

        return finalIdx;
    }

    private static <T> int getCompareResult(T[] array, T obj, Comparator<? super T> comparator, int midIdx) {
        int compareResult;
        if (comparator != null) {
            compareResult = comparator.compare(obj, array[midIdx]);
        } else {
            compareResult = ((Comparable)obj).compareTo(array[midIdx]);
        }
        return compareResult;
    }
}
