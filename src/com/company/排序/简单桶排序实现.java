package com.company.排序;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 基本思想：
 * 将数组分到有限数量的桶子里。每个桶子再个别排序（有可能再使用别的排序算法或是以递归方式继续使用桶排序进行排序）。
 * 桶排序利用函数的映射关系，减少了几乎所有的比较工作。实际上，桶排序的f(k)值的计算，其作用就相当于快排中划分，
 * 已经把大量数据分割成了基本有序的数据块(桶)。然后只需要对桶中的少量数据做先进的比较排序即可。
 * Created by dg on 2016/7/19.
 * <p>
 * 1、对于N个待排数据，M个桶，如果相对于同样的N，桶数量M越大，其效率越高，最好的时间复杂度达到O(N)。当然桶排序的
 * 空间复杂度为O(N+M)，如果输入数据非常庞大，而桶的数量也非常多，则空间代价无疑是昂贵的。
 * 2、桶排序是稳定的（如果桶内数据的排序算法选择的不是稳定的，桶排序就变成不稳定的）。
 * 适用场景：
 * 1、输入数据符合均匀分布。
 * 2、在面试的海量数据处理题目中，如对每天数以亿计的数据进行排序，直接排序即使采用nlgn的算法，依然是一件很恐怖的事情，
 * 内存也无法容纳如此多的数据，这时桶排序就可以有效地降低数据的数量级，再对降低了数量级的数据进行排序，可以得到比较良好的效果。
 * 面试题
 */
public class 简单桶排序实现 {
    public static void main(String[] args) {
        int[] ints = {
                1, 12, 31, 13, 23, 12, 19, 23, 45, 6, 47, 36, 56, 45
        };
        bucketSort(ints);
        System.out.println(Arrays.toString(ints));
    }

    //假如排序的数据范围为（0-100），学生成绩
    public static void bucketSort(int[] arr) {
        List<List<Integer>> buckets = new ArrayList<List<Integer>>();
        buckets.add(new ArrayList<Integer>());//成绩0-59的桶
        buckets.add(new ArrayList<Integer>());//成绩60-69
        buckets.add(new ArrayList<Integer>());//成绩70-79
        buckets.add(new ArrayList<Integer>());//成绩80-100
        for (int i : arr) {
            if (i >= 0 && i <= 59) buckets.get(0).add(i);
            if (i >= 60 && i <= 69) buckets.get(1).add(i);
            if (i >= 70 && i <= 79) buckets.get(2).add(i);
            if (i >= 80 && i <= 100) buckets.get(3).add(i);
        }
        for (List<Integer> bucket : buckets) {
            Collections.sort(bucket);
        }
        int index = 0;
        for (List<Integer> bucket : buckets) {
            for (int i : bucket) {
                arr[index++] = i;
            }
        }
    }
}
