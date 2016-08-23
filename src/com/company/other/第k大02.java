package com.company.other;


/**
 * Created by dy on 2016/8/23.
 * 分治求第k个
 *
 */
public class 第k大02 {
    public static void main(String[] args) {
        int[] ints = {
                12, 14312, 312, 31, 3214, 324, 324, 32, 4, 324, 32
        };
        System.out.println(search_k(ints,0,ints.length-1,5));
    }

    private static int search_k(int array[], int s, int e, int k) {
        int p = partion(array, s, e);
        int q = p + 1;
        if (q == k)
            return array[p];
        if (q < k)
            return search_k(array, p + 1, e, k);
        if (q > k)
            return search_k(array, s, p - 1, k);
        return 0;
    }

    private static int partion(int array[], int s, int e) {
        int temp = array[s];
        while (s < e) {
            while (array[e] >= temp && s < e)
                e--;
            if (s < e)
                array[s] = array[e];
            while (array[s] < temp && s < e)
                s++;
            if (s < e)
                array[e] = array[s];
        }
        array[s] = temp;
        return s;
    }
}
