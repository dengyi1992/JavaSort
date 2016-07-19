package com.company.排序;

import java.util.Arrays;

/**
 * Created by dg on 2016/7/19.
 * 特征分析：
 * 1、空间复杂度O(1)，平均时间复杂度O（n log n）,依次堆调整O(log n)——即堆的高度。由于建初始堆所需的比较次数较多，所以堆排序不适宜于记录数量较少的情况。
 * 2、堆排序时不稳定的。
 */
public class 堆排序 {
    public static void main(String[] args) {
        int[] ints = {
                12, 14312, 312, 31, 3214, 324, 324, 32, 4, 324, 32
        };
        heapSort(ints);
        System.out.println(Arrays.toString(ints));
    }

    //调整堆
    public static void adjustHeap(int[] arr, int size, int top) {
        while (top * 2 + 1 <= size - 1) {
            int change = 0;
            if (top * 2 + 1 == size - 1) {//只有左子节点
                change = top * 2 + 1;
                if (arr[top] >= arr[top * 2 + 1]) {
                    break;
                }
            } else {
                change = arr[top * 2 + 1] > arr[top * 2 + 2] ? top * 2 + 1 : top * 2 + 2;
                if (arr[top] >= arr[change]) {
                    break;
                }
            }
            int t = arr[top];
            arr[top] = arr[change];
            arr[change] = t;
            top = change;
        }
    }

    //建堆
    public static void buildHeap(int[] arr) {
        for (int top = (arr.length) / 2; top >= 0; top--) {
            adjustHeap(arr, arr.length, top);
        }
    }

    //堆排序
    public static void heapSort(int[] arr) {
        buildHeap(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int size = arr.length; size >= 2; size--) {
            int t = arr[0];
            arr[0] = arr[size - 1];
            arr[size - 1] = t;
            adjustHeap(arr, size - 1, 0);
        }
    }
}
