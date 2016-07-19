package com.company.排序;

import java.util.Arrays;

/**
 * Created by dg on 2016/7/19.
 * 1、折半插入排序仅减少了关键字间的比较次数，而记录的移动次数不变。
 * 使用场景：
 * 1、如果元素的比较的操作比较耗时，可以对直接插入排序的性能进行提升。
 */
public class 二分插入排序 {
    public static void main(String[] args) {
        int[] ints = {
                12, 14312, 312, 31, 3214, 324, 324, 32, 4, 324, 32
        };
        binaryInsertSort(ints);
        System.out.println(Arrays.toString(ints));
    }

    public static void binaryInsertSort(int[] arr) {
        if (arr == null || arr.length <= 1) return;
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int start = 0, end = i;
            while (start < end) {
                int mid = start + (end - start) / 2;
                if (arr[mid] <= temp) {
                    start = mid + 1;
                } else {
                    end = mid;
                }
            }
            int p = i;
            while (p > end) {
                arr[p] = arr[p - 1];
                p--;
            }
            arr[p] = temp;
        }
    }
}
