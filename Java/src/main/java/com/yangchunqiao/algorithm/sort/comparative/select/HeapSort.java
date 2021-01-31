package com.yangchunqiao.algorithm.sort.comparative.select;

import com.yangchunqiao.algorithm.sort.utils.SortUtils;

public class HeapSort {

    public static int[] heapSort(int[] array, int length) {
        // create heap: a[i] >= a[2 * i + 1]  a[i] >= a[2 * i + 2]
        for (int i = length / 2 - 1; i >= 0; i--) {
            adjustHeap(array, i, length);
        }

        for (int j = length - 1; j > 0; j--) {
            SortUtils.swap(array, 0, j);
            // After swap, a[j] >= a[0,1,2,.. j-1]
            adjustHeap(array, 0, j);
        }
        return array;
    }


    private static void adjustHeap(int[] array, int i, int length) {
        int temp = array[i];
        for (int k = 2 * i + 1; k < length; k = 2 * k + 1) {
            if (k + 1 < length && array[k] < array[k + 1]) {
                k++;
            }

            if (array[k] > temp) {
                SortUtils.swap(array, i, k);
                i  =  k;
            } else {
                break;
            }
        }
    }




    public static void testSort(int length, int min, int max) {
        int[] array = SortUtils.getRandomArray(min, max, length);
        SortUtils.printArray(array, length);
        long start = System.currentTimeMillis();
        HeapSort.heapSort(array, length);
        long end = System.currentTimeMillis();

        System.out.println("simple insertion sort time:" + (end - start));
        SortUtils.printArray(array, length);
    }



}
