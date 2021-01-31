package com.yangchunqiao.algorithm.sort.noncomparative.bucket;


import com.yangchunqiao.algorithm.sort.comparative.exchange.QuickSort;
import com.yangchunqiao.algorithm.sort.noncomparative.counting.CountingSort;
import com.yangchunqiao.algorithm.sort.utils.SortUtils;

public class BucketSort {


    public static void basketSort(int array[], int length) {
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

        int bucketNumber = width / 10 + 1;
        int[][] buckets = new int[bucketNumber][length];
        int[] bucketCount = new int[bucketNumber];
        for(int i = 0; i < length; i++) {
            int bucketIndex = (array[i] - min) / 10;
            buckets[bucketIndex][bucketCount[bucketIndex]++] = array[i];
        }

        int resultIndex = 0;
        for(int i = 0; i < bucketNumber; i++) {
            if(bucketCount[i] > 1) {
                CountingSort.countingSort(buckets[i], bucketCount[i]);
            }
            if(bucketCount[i] > 0) {
                for(int j = 0; j < bucketCount[i]; j++) {
                    array[resultIndex++] = buckets[i][j];
                }
            }
        }
    }


    public static void testSort(int length, int min, int max) {
        int[] array = SortUtils.getRandomArray(min, max, length);
        SortUtils.printArray(array, length);
        long start = System.currentTimeMillis();
        BucketSort.basketSort(array, length);
        long end = System.currentTimeMillis();

        System.out.println("bucket sort time:" + (end - start));
        SortUtils.printArray(array, length);
    }





}
