/*
 * Copyright (c) 2018 George Yang. All rights reserved.
 * Name:George Yang
 * email: ycq__ycq@live.com
 */
package com.yangchunqiao.algorithm.sort.comparative.exchange;
/*
 * Copyright (c) 2018 George Yang. All rights reserved.
 * Name:George Yang
 * email: ycq__ycq@live.com
 */
import com.yangchunqiao.algorithm.sort.utils.SortUtils;

/**
 * @author George
 */
public class  QuickSort {

    public static void quickSort(int[] array, int length) {
        quickSort(array, 0, length - 1);
    }

    private static void quickSort(int[] array, int left, int right) {
        if(left >= right) {
            return;
        }

        int i = left;
        int j = right + 1;
        int firstData = array[left];
        do {
            do {
                i++;
            } while(i < right && array[i] < firstData);
            do {
                j--;
            } while(array[j] > firstData);
            if(i < j && array[i] != array[j]) {
                SortUtils.swap(array, i, j);
            }
        } while(i < j);

        SortUtils.swap(array, left, j);
        quickSort(array, left, j - 1);
        quickSort(array, j + 1, right);
    }


    public static void testSort(int length, int min, int max) {
        int[] array = SortUtils.getRandomArray(min, max, length);
        SortUtils.printArray(array, length);
        long start = System.currentTimeMillis();
        QuickSort.quickSort(array, length);
        long end = System.currentTimeMillis();

        System.out.println("qucik sort time:" + (end - start));
        SortUtils.printArray(array, length);
    }


}
