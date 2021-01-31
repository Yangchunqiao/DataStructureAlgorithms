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
public class SimpleInsert {

    public static void sort(int[] array, int length) {
        int temp;
        for(int i = 1; i < length; i++) {
            temp = array[i];
            for(int j = i; j > 0; j--) {
                if(temp < array[j - 1]) {
                    SortUtils.swap(array, j, j - 1);
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
        SimpleInsert.sort(array, length);
        long end = System.currentTimeMillis();

        System.out.println("simple insertion sort time:" + (end - start));
        SortUtils.printArray(array, length);
    }




}
