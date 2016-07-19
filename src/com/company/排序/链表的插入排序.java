package com.company.排序;

import com.company.bean.ListNode;

import java.util.Arrays;

/**
 * Created by dg on 2016/7/19.
 */
public class 链表的插入排序 {
    public static void main(String[] args) {

    }

    public static ListNode listInsertSort(ListNode head) {
        ListNode myHead = new ListNode(-1);
        ListNode p = head, t, pre, post;
        while (p != null) {
            t = p;
            p = p.next;
            pre = myHead;
            post = myHead.next;
            while (post != null && post.val <= t.val) {
                pre = pre.next;
                post = post.next;
            }
            t.next = post;
            pre.next = t;
        }
        return myHead.next;
    }
}
