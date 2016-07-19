package com.company.排序;

import java.util.Arrays;

/**
 * Created by dg on 2016/7/19.
 */
public class 快速排序_递归版 {
    public static void main(String[] args) {
        int[] ints = {
                12, 14312, 312, 31, 3214, 324, 324, 32, 4, 324, 32
        };
        quickSort(ints,0,ints.length-1);
        System.out.println(Arrays.toString(ints));
    }

    public static int partition(int[] arr, int start, int end) {
        int part = arr[start];
        int locate = start;
        while (start < end) {
            while (end > start && arr[end] > part) end--;
            if (end <= start) {
                break;
            }
            arr[locate] = arr[end];
            locate = end;
            while (start < end && arr[start] <= part) start++;
            if (start >= end) {
                break;
            }
            arr[locate] = arr[start];
            locate = start;
        }
        arr[locate] = part;
        return locate;
    }

    public static void quickSort(int[] arr, int start, int end) {
        if (start >= end) return;
        int mid = partition(arr, start, end);
        quickSort(arr, start, mid - 1);
        quickSort(arr, mid + 1, end);
    }
}
