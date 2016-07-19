package com.company.排序;

import java.util.Arrays;

/**
 * Created by dg on 2016/7/19.
 * 不需要大量的辅助空间，和归并排序一样容易实现。希尔排序是基于插入排序的一种算法， 在此算法基础之上增加了一个新的特性，
 * 提高了效率。希尔排序的时间复杂度与增量序列的选取有关，希尔排序时间复杂度的下界是n*log2n。希尔排序没有快速排序算法快
 * O(n(logn))，因此中等大小规模表现良好，对规模非常大的数据排序不是最优选择。但是比O( n^2  )复杂度的算法快得多。
 * 并且希尔排序非常容易实现，算法代码短而简单。 此外，希尔算法在最坏的情况下和平均情况下执行效率相差不是很多，
 * 与此同时快速排序在最坏的情况下执行的效率会非常差。专家们提倡，几乎任何排序工作在开始时都可以用希尔排序，
 * 若在实际使用中证明它不够快，再改成快速排序这样更高级的排序算法. 本质上讲，希尔排序算法是直接插入排序算法的一种改进，
 * 减少了其复制的次数，速度要快很多。 原因是，当n值很大时数据项每一趟排序需要的个数很少，但数据项的距离很长。
 * 当n值减小时每一趟需要移动的数据增多，此时已经接近于它们排序后的最终位置。 正是这两种情况的结合才使希尔排序效率比插入排序高很多。
 * Shell算法的性能与所选取的分组长度序列有很大关系。只对特定的待排序记录序列，可以准确地估算关键词的比较次数和对象移动次数。
 * 想要弄清关键词比较次数和记录移动次数与增量选择之间的关系，并给出完整的数学分析，至今仍然是数学难题。
 */
public class 希尔排序 {
    public static void main(String[] args){
        int[] ints = {
                12, 14312, 312, 31, 3214, 324, 324, 32, 4, 324, 32
        };
        shellSort(ints);
        System.out.println(Arrays.toString(ints));
    }
    public static void shellSort(int[] arr){
        if(arr == null || arr.length <= 1) return;
        int gap=arr.length/2;
        while(gap>0){
            for(int i=1;i<arr.length ;i++){
                int temp=arr[i];
                int p=i;
                while(p>=gap&&arr[p-gap]>temp){
                    arr[p]=arr[p-gap];
                    p-=gap;
                }
                arr[p]=temp;
            }
            gap/=2;
        }
    }
}
