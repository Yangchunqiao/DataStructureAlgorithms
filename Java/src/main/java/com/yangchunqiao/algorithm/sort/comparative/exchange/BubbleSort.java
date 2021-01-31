/*
 * Copyright (c) 2018 George Yang. All rights reserved.
 * Name:George Yang
 * email: ycq__ycq@live.com
 */
package com.yangchunqiao.algorithm.sort.comparative.exchange;

import com.yangchunqiao.algorithm.sort.comparative.insert.ShellSort;
import com.yangchunqiao.algorithm.sort.utils.SortUtils;

/**
 * @author George
 */
public class BubbleSort {

    public static void bubbleSort(int[] array, int length) {
        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    SortUtils.swap(array, j, j + 1);
                }
            }
        }
    }



    public static void testSort(int length, int min, int max) {
        int[] array = SortUtils.getRandomArray(min, max, length);
        SortUtils.printArray(array, length);
        long start = System.currentTimeMillis();
        BubbleSort.bubbleSort(array, length);
        long end = System.currentTimeMillis();

        System.out.println("bubble sort time:" + (end - start));
        SortUtils.printArray(array, length);
    }




}
