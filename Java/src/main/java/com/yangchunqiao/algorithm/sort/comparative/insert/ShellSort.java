/*
 * Copyright (c) 2018 George Yang. All rights reserved.
 * Name:George Yang
 * email: ycq__ycq@live.com
 */
package com.yangchunqiao.algorithm.sort.comparative.insert;

import com.yangchunqiao.algorithm.sort.utils.SortUtils;

/**
 * @author George
 */
public class ShellSort {

    public static void sort(int[] array, int length) {
        int increment = 2;

        for (int groupCount = length / increment; groupCount > 0; groupCount = groupCount / increment) {
            for(int groupIndex = 0; groupIndex < groupCount; groupIndex++) {
                ShellSort.simpleSort(array, length, groupCount, groupIndex);
            }
        }
    }


    private static void simpleSort(int[] array, int length, int groupCount, int groupIndex) {
        int temp;
        for(int i = groupCount + groupIndex; i < length; i = i + groupCount) {
            temp = array[i];
            for(int j = i; j > groupIndex; j = j - groupCount) {
                if(temp < array[j - groupCount]) {
                    SortUtils.swap(array, j, j - groupCount);
                } else {
                    break;
                }
            }
        }
    }


    public static void testSort(int length, int min, int max) {
        int[] array = SortUtils.getRandomArray(min, max, length);
        SortUtils.printArray(array, length);
        long start = System.currentTimeMillis();
        ShellSort.sort(array, length);
        long end = System.currentTimeMillis();

        System.out.println("shell sort time:" + (end - start));
        SortUtils.printArray(array, length);
    }





}
