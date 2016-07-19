package com.company.排序;

import java.util.Arrays;

/**
 * Created by dg on 2016/7/19.
 * 1、基数排序法是属于稳定性的排序。
 * 2、时间复杂度为O (nlog(k)d)，其中d为所采取的基数，而k为堆数，在某些时候，基数排序法的效率高于其它的稳定性排序法。
 */
public class 基数排序 {
    public static void main(String[] args) {
        int[] ints = {
                12, 14312, 312, 31, 3214, 324, 324, 32, 4, 324, 32
        };
        radixSorting(ints, ints.length);
        System.out.println(Arrays.toString(ints));
    }

    // d为数据长度
    private static void radixSorting(int[] arr, int d) {
        for (int i = 1; i <= d; i++) {
            int[] res = countingSort(arr, i); // 依次对各位数字排序（直接用计数排序的变体）
            for (int j = 0; j < arr.length; j++) {
                arr[j] = res[j];
            }
        }
    }

    // 利用计数排序对元素的每一位进行排序
    private static int[] countingSort(int[] arr, int expIndex) {
        int k = 9;
        int[] b = new int[arr.length];
        int[] c = new int[k + 1]; // 这里比较特殊：数的每一位最大数为9
        for (int i = 0; i < k; i++) {
            c[i] = 0;
        }
        for (int i = 0; i < arr.length; i++) {
            int d = getBitData(arr[i], expIndex);
            c[d]++;
        }
        for (int i = 1; i <= k; i++) {
            c[i] += c[i - 1];
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            int d = getBitData(arr[i], expIndex);
            b[c[d] - 1] = arr[i];// C[d]-1 就代表小于等于元素d的元素个数，就是d在B的位置
            c[d]--;
        }
        return b;
    }

    // 获取data指定位的数
    private static int getBitData(int data, int expIndex) {
        while (data != 0 && expIndex > 0) {
            data /= 10;
            expIndex--;
        }
        return data % 10;
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
