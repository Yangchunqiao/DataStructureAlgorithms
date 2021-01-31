package com.yangchunqiao.algorithm.sort.utils;

import com.yangchunqiao.algorithm.sort.comparative.exchange.BubbleSort;
import com.yangchunqiao.algorithm.sort.comparative.exchange.QuickSort;
import com.yangchunqiao.algorithm.sort.comparative.insert.ShellSort;
import com.yangchunqiao.algorithm.sort.comparative.insert.SimpleInsert;
import com.yangchunqiao.algorithm.sort.comparative.merge.TwoWayMerge;
import com.yangchunqiao.algorithm.sort.comparative.select.HeapSort;
import com.yangchunqiao.algorithm.sort.comparative.select.SimpleSelection;

public class SortTest {


    public static void sortTest() {
        BubbleSort.testSort(100, -10, 30);
        QuickSort.testSort(100, -10, 30);

        SimpleInsert.testSort(100, -10, 30);
        ShellSort.testSort(100, -10, 30);

        TwoWayMerge.testSort(100, -10, 30);
        HeapSort.testSort(100, -10, 30);
        SimpleSelection.testSort(100, -10, 30);
    }





}
