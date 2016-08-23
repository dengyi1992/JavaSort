package com.company.other;

import java.util.Arrays;

/**
 * Created by dy on 2016/8/23.
 */
public class 第k大01 {
    public static void main(String[] args) {
        int[] ints = {
                12, 14312, 312, 31, 3214, 324, 324, 32, 4, 324, 32
        };
        Arrays.sort(ints);
        System.out.println(ints[4]);

    }

}
