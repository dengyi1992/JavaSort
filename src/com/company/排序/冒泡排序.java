package com.company.排序;

import java.util.Arrays;

/**
 * Created by dg on 2016/7/19.
 * 1、空间复杂度O(1)，最好时间复杂度O(n)，最坏时间复杂度O(n^2)，平均时间复杂度O(n^2)。
 * 2、冒泡排序时稳定的。
 */
public class 冒泡排序 {
    public static void main(String[] args) {
        int[] ints = {
                12, 14312, 312, 31, 3214, 324, 324, 32, 4, 324, 32
        };
        bubbleSort(ints);
        System.out.println(Arrays.toString(ints));
    }

    public static void bubbleSort(int[] arr) {
        for (int end = arr.length - 1; end > 0; end--) {
            boolean changed = false;
            for (int index = 0; index < end; index++) {
                if (arr[index] > arr[index + 1]) {
                    int t = arr[index + 1];
                    arr[index + 1] = arr[index];
                    arr[index] = t;
                    changed = true;
                }
            }
            if (changed == false) return;
        }
    }
}
