package com.tina.sort;

/**
 * Created by tina on 2019/1/19.
 *
 * O(n) 时间复杂度内求无序数组中的第 K 大元素。
 *
 * 利用了快排算法中的分区的思想：
 * 比如，4， 2， 5， 12， 3这样一组数据，第 3 大元素就是 4。
 * 我们选择数组区间A[0…n-1] 的最后一个元素 A[n-1] 作为 pivot，对数组 A[0…n-1] 原地分区，
 * 这样数组就分成了三部分，A[0…p-1]、A[p]、A[p+1…n-1]。
 * A[0…p-1]是比A[p]小的元素，A[p+1…n-1]是比A[p]大的元素。
 * 找第K大元素，意味找（降序排序后）下标为K-1的元素。
 * 如果K-1=p，那么p下标对应的元素就是第K大元素（此时A[0…p-1]并未降序排序，但是保证都比A[p]大，所以A[p]就是第K大）。
 * 如果K-1>p, 说明第 K 大元素出现在 A[p+1…n-1]区间，
 * 我们再按照上面的思路递归地在 A[p+1…n-1] 这个区间内查找。
 * 同理，如果 K-1<p，那我们就在A[0…p-1]里面找。
 */
public class FindKthLargestInArray {
    private static int partition(int[] array, int start, int end) {
        int i = start;
        for (int j = start; j < end; j++) {
            if (array[j] > array[end]) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
            }
        }
        int temp = array[i];
        array[i] = array[end];
        array[end] = temp;
        return i;
    }

    private static int dissolve(int[] array, int start, int end, int kth) {
        int result;

        if (start >= end) {
            return array[kth];
        }

        int pivot = partition(array, start, end);
        if (kth > pivot) {
            result = dissolve(array, pivot + 1, end, kth);
        } else if (kth < pivot){
            result = dissolve(array, start, pivot - 1, kth);
        } else {
            result = array[pivot];
        }

        return result;
    }

    public static int findKthLargestInArray(int[] array, int kth) {
        if (kth > array.length) {
            throw new RuntimeException("out of range!");
        }
        return dissolve(array, 0, array.length - 1, kth - 1);
    }
}
