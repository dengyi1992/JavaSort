package com.company.排序;

import java.util.Arrays;

/**
 * Created by dg on 2016/7/19.
 * 特征分析：
 * 1、空间复杂度O(k+n)（k为数据范围），时间复杂度O(n+k)。
 * 2、计数排序时稳定的。
 * 变形：
 * 出来了通过统计出现次数之外，我们还可以用链表记录数值相同的元素。
 * 适用场景：
 * 1、当k=O(n)时。
 * ？？？？？？
 */
public class 计数排序 {
    public static void main(String[] args) {
        int[] ints = {
                12, 14312, 312, 31, 3214, 324, 324, 32, 4, 324, 32
        };
        countSort(ints);
        System.out.println(Arrays.toString(ints));
    }
    public static int[] countSort(int[] a) {
        int b[] = new int[a.length];
        int max = a[0], min = a[0];
        for (int i : a) {
            if (i > max) max = i;
            if (i < min) min = i;
        }//这里k的大小是要排序的数组中，元素大小的极值差+1
        int k = max - min + 1;
        int c[] = new int[k];
        for (int i = 0; i < a.length; ++i) {
            c[a[i] - min] += 1;//优化过的地方，减小了数组c的大小
        }
        for (int i = 1; i < c.length; ++i) {
            c[i] = c[i] + c[i - 1];
        }
        for (int i = a.length - 1; i >= 0; --i) {
            b[--c[a[i] - min]] = a[i];//按存取的方式取出c的元素
        }
        return b;
    }
}
