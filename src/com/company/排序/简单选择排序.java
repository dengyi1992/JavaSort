package com.company.排序;

import java.util.Arrays;

/**
 * Created by dg on 2016/7/19.
 * 特征分析：
 1、空间复杂度O(1)，最好/最坏/平均时间复杂度都是O(n^2)，比较次数O(n^2)，移动次数O(n)。
 2、选择排序是不稳定的排序方法（比如序列[5， 5， 3]第一次就将第一个[5]与[3]交换，导致第一个5挪动到第二个5后面）。
 */
public class 简单选择排序 {
    public static void main(String[] args) {
        int[] ints = {
                12, 14312, 312, 31, 3214, 324, 324, 32, 4, 324, 32
        };
        simpleSelectSort(ints);
        System.out.println(Arrays.toString(ints));
    }

    public static void simpleSelectSort(int[] arr) {
        if (arr == null || arr.length <= 1)
            return;
        for (int i = 0; i < arr.length; i++) {
            int start = i, minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex])
                    minIndex = j;
            }
            int temp = arr[start];
            arr[start] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }
}
