package com.yangchunqiao.algorithm.sort.noncomparative.counting;

import com.yangchunqiao.algorithm.sort.noncomparative.bucket.BucketSort;
import com.yangchunqiao.algorithm.sort.utils.SortUtils;

public class CountingSort {

    public static void countingSort(int[] array, int length) {
        int min = array[0];
        int max = array[0];
        for(int i = 1; i < length; i++) {
            int temp = array[i];
            if(temp < min) {
                min = temp;
            }
            if(temp > max) {
                max = temp;
            }
        }


        int width = max - min + 1;
        // for java: middleArray[0] ~ middleArray[length - 1] is 0 after the following line code.
        int[] middleArray = new int[width];
        for(int i = 0; i < length; i++) {
            middleArray[array[i] - min]++;
        }

        int resultIndex = 0;
        for(int i = 0; i < width && resultIndex < length; i++) {
            int count = middleArray[i];
            for(int j = 0; j < count; j++) {
                array[resultIndex++] = i + min;
            }
        }
    }



    public static void testSort(int length, int min, int max) {
        int[] array = SortUtils.getRandomArray(min, max, length);
        SortUtils.printArray(array, length);
        long start = System.currentTimeMillis();
        CountingSort.countingSort(array, length);
        long end = System.currentTimeMillis();

        System.out.println("counting sort time:" + (end - start));
        SortUtils.printArray(array, length);
    }






}
