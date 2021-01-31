package com.yangchunqiao.algorithm.sort.comparative.select;

import com.yangchunqiao.algorithm.sort.utils.SortUtils;

public class SimpleSelection {

    public static void simpleSelection(int[] arr, int length) {
        int min, temp;
        for (int i = 0; i < length; i++) {
            min = i;
            for (int j = i + 1; j < length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }

            if (min != i) {
                temp = arr[min];
                arr[min] = arr[i];
                arr[i] = temp;
            }
        }
    }





    public static void testSort(int length, int min, int max) {
        int[] array = SortUtils.getRandomArray(min, max, length);
        SortUtils.printArray(array, length);
        long start = System.currentTimeMillis();
        SimpleSelection.simpleSelection(array, length);
        long end = System.currentTimeMillis();

        System.out.println("simple selection sort time:" + (end - start));
        SortUtils.printArray(array, length);
    }



}
