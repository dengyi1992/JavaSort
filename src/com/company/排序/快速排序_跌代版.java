package com.company.排序;

import java.util.Arrays;
import java.util.Stack;

/**
 * Created by dg on 2016/7/19.
 * 特征分析：
 * 1、最好空间复杂度O(log(n))，最坏空间复杂度O（n），平均空间复杂度O(log n)；最好时间复杂度O(n log n)，最坏时间复杂度O(n^2)，平均时间复杂度O(n log n)。
 * 2、快速排序时不稳定的。
 */
public class 快速排序_跌代版 {
    public static void main(String[] args) {
        int[] ints = {
                12, 14312, 312, 31, 3214, 324, 324, 32, 4, 324, 32
        };
        quickSort(ints);
        System.out.println(Arrays.toString(ints));
    }

    public static void quickSort(int[] arr) {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(0);
        stack.push(arr.length - 1);
        while (stack.empty() == false) {
            int end = stack.pop(), start = stack.pop();
            if (start >= end) continue;
            int part = arr[start];
            int locate = start;
            int pre = start, post = end;
            while (pre < post) {
                while (pre < post && arr[post] > part) post--;
                if (pre > post) break;
                arr[locate] = arr[post];
                locate = post;
                while (pre < post && arr[pre] <= part) pre++;
                if (pre > post) break;
                arr[locate] = arr[pre];
                locate = pre;
            }
            arr[locate] = part;
            stack.push(start);
            stack.push(locate - 1);
            stack.push(locate + 1);
            stack.push(end);
        }
    }
}
