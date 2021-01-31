package com.yangchunqiao.algorithm.sort.noncomparative.radix;

import com.yangchunqiao.algorithm.sort.utils.SortUtils;

public class RadixSort {

    public static void radixsort(int[] array, int length) //d表示最大的数有多少位
    {
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
        int maxDigitWidth = 1;
        for(int temp = 10; temp <= width; temp = temp * 10) {
            maxDigitWidth++;
        }

        int resultIndex = 0;
        int k = 1;
        int[][]temp = new int[10][length];
        int[]lastDigitCount = new int[10];
        for(int digitIndex = 0; digitIndex < maxDigitWidth; digitIndex++) {
            for(int i = 0; i < length; i++) {
                int lastDigit = (((array[i] - min) / k) % 10);
                temp[lastDigit][lastDigitCount[lastDigit]++] = array[i];
            }
            for(int i = 0; i < 10; i++) {
                for(int j = 0; j < lastDigitCount[i]; j++) {
                    array[resultIndex] = temp[i][j];
                    resultIndex++;
                }
                lastDigitCount[i] = 0;
            }
            k *= 10;
            resultIndex = 0;
        }
    }



    public static void testSort(int length, int min, int max) {
        int[] array = SortUtils.getRandomArray(min, max, length);
        SortUtils.printArray(array, length);
        long start = System.currentTimeMillis();
        RadixSort.radixsort(array, length);
        long end = System.currentTimeMillis();

        System.out.println("counting sort time:" + (end - start));
        SortUtils.printArray(array, length);
    }



}
