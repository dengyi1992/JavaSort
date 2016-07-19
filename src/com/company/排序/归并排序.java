package com.company.排序;

/**
 * Created by dg on 2016/7/19.
 * 特征分析：
 * 1、空间复杂度O(n)，时间复杂度O(1)。
 * 2、归并排序时稳定的排序。
 */
public class 归并排序 {
    public static void main(String[] args) {

    }

    public static void merge(int[] arr, int start1, int start2, int end2, int[] temp) {
        int end1 = start2 - 1, index = 0;
        int p = start1, q = start2;
        while (p <= end1 || q <= end2) {
            if (q > end2 || (p <= end1 && arr[p] < arr[q])) {
                temp[index++] = arr[p++];
            } else {
                temp[index++] = arr[q++];
            }
        }
        for (int i = 0; i < index; i++) {
            arr[start1 + i] = temp[i];
        }
    }

    /**
     * 递归
     *
     * @param arr
     * @param start
     * @param end
     * @param temp
     */
    public static void mergeSort(int[] arr, int start, int end, int[] temp) {
        if (start >= end) return;
        int mid = start + (end - start) / 2;
        mergeSort(arr, start, mid, temp);
        mergeSort(arr, mid + 1, end, temp);
        merge(arr, start, mid + 1, end, temp);
    }

    /**
     * 迭代版
     * @param arr
     * @param temp
     */
    public static void mergeSort(int[] arr, int[] temp) {
        int size = 1, low, mid, high, n = arr.length;
        while (size <= n - 1) {
            low = 0;
            while (low + size <= n - 1) {
                mid = low + size - 1;
                high = mid + size;
                if (high > n - 1)//第二个序列个数不足size
                    high = n - 1;
                merge(arr, low, mid + 1, high, temp);//调用归并子函数
                System.out.println("low:" + low + " mid:" + mid + " high:" + high);
                low = high + 1;//下一次归并时第一关序列的下界
            }
            size *= 2;//范围扩大一倍
        }
    }
}
