/*
 * Copyright (c) 2018 George Yang. All rights reserved.
 * Name:George Yang
 * Chinese name: Yangchunqiao
 * email: ycq__ycq@live.com
 */
package com.yangchunqiao.algorithm.sort.utils;


import java.util.Random;

public class SortUtils {
    /**
     * get a array
     * @param min min < max
     * @param max max > min
     * @param length length > 0
     * @return array
     */
    public static int[] getRandomArray(int min, int max, int length) {
        if(min >= max || length < 1) {
            return null;
        }
        int bound = max - min + 1;

        Random random = new Random();
        int[] resultArray = new int[length];
        for(int i = 0; i < length; i++) {
            resultArray[i] = random.nextInt(bound) + min;
        }

        return resultArray;
    }


    public static int[] deepCopyArray(int[] array, int length) {
        int[] arrayResult = new int[length];
        for(int i = 0; i < length; i++) {
            arrayResult[i] = array[i];
        }
        return arrayResult;
    }


    public static void printArray(int[] array, int length) {
        for(int i = 0; i < length; i++) {
            System.out.print(" " + array[i]);
        }
        System.out.println();
    }



    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }


}
