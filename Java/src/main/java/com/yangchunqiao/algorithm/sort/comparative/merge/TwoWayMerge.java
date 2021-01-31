package com.yangchunqiao.algorithm.sort.comparative.merge;

import com.yangchunqiao.algorithm.sort.comparative.select.HeapSort;
import com.yangchunqiao.algorithm.sort.utils.SortUtils;

public class TwoWayMerge {

    public static void mergeSort(int[] array, int length) {
        int[] temp = new int[length];
        mergeSort(array, 0, length - 1, temp);
    }


    private static void mergeSort(int array[], int first, int last, int temp[]) {
        if (first < last) {
            int mid = (first + last) / 2;
            mergeSort(array, first, mid, temp);
            mergeSort(array, mid + 1, last, temp);
            mergeArray(array, first, mid, last, temp);
        }
    }

    private static void mergeArray(int array[], int first, int mid, int last, int temp[]) {
        int i = first, j = mid + 1;
        int m = mid, n = last;
        int k = 0;
        while (i <= m && j <= n) {
            if (array[i] <= array[j])
                temp[k++] = array[i++];
            else
                temp[k++] = array[j++];
        }
        while (i <= m) {
            temp[k++] = array[i++];
        }
        while (j <= n) {
            temp[k++] = array[j++];
        }
        for (i = 0; i < k; i++) {
            array[first + i] = temp[i];
        }
    }


    public static void testSort(int length, int min, int max) {
        int[] array = SortUtils.getRandomArray(min, max, length);
        SortUtils.printArray(array, length);
        long start = System.currentTimeMillis();
        TwoWayMerge.mergeSort(array, length);
        long end = System.currentTimeMillis();

        System.out.println("merge sort time:" + (end - start));
        SortUtils.printArray(array, length);
    }





}
