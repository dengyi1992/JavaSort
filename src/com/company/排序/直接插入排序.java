package com.company.排序;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by dg on 2016/7/19.
 * 1、空间复杂度O(1)。最好时间复杂度O(n)，最坏时间复杂度O(n^2)，平均时间复杂度为O(n^2)。最好情况下（已有序），比较次数n-1，移动次数0，最坏情况，比较次数O(n^2)，移动次数O(n^2)。
 * 2、直接插入排序是稳定的。
 */
public class 直接插入排序 {
    public static void main(String[] args) {
        int[] ints = {
                12, 14312, 312, 31, 3214, 324, 324, 32, 4, 324, 32
        };
        insertSort(ints);
        System.out.println(Arrays.toString(ints));
    }

    public static void insertSort(int[] arr) {
        if (arr == null || arr.length <= 1) return;
        for (int i = 1; i < arr.length; i++) {
            int p = i;
            int temp = arr[p];
            while (p > 0 && arr[p - 1] > temp) {
                arr[p] = arr[p - 1];
                p--;
            }
            arr[p] = temp;
        }
    }
}
