package day0328;

import org.junit.Test;

/**
 * @hurusea
 * @create2020-03-28 10:13
 */
public class Solution {

    @Test
    public void testMyPow() {
        System.out.println(myPow(2, 10));
    }

    /**
     *实现函数double Power(double base, int exponent)，求base的exponent次方。不得使用库函数，
     * 同时不需要考虑大数问题。
     * @param x
     * @param n
     * @return
     */
    public double myPow(double x, int n) {
        if(x == 0) return 0;
        long b = n;
        double res = 1.0;
        if(b < 0) {
            x = 1 / x;
            b = -b;
        }
        while(b > 0) {
            if((b & 1) == 1) res *= x;
            x *= x;
            b >>= 1;
        }
        return res;
    }

    @Test
    public void testPrintNumbers() {
        int[] result = printNumbers(4);
        for (int i = 0; i <result.length; i++) {
            System.out.print(result[i]+" ");
        }
    }
    /**
     * 输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3
     * 一直到最大的 3 位数 999。
     * @param n
     * @return
     */
    public int[] printNumbers(int n) {
        int max = (int) Math.pow(10, n)-1;//max=9
        int arr[] = new int[max];
        for (int i = 0; i <max; i++) {
            arr[i]=i+1;
        }
        return arr;
    }


    @Test
    public void testDeleteNode() {


    }
    /**
     * 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
     * 返回删除后的链表的头节点。
     * @param head
     * @param val
     * @return
     */

    public ListNode deleteNode(ListNode head, int val) {
        if(head.val == val) return head.next;
        ListNode pre = head, cur = head.next;
        //遍历链表
        while(cur != null && cur.val != val) {
            pre = cur;
            cur = cur.next;
        }
        pre.next = cur.next;
        return head;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
     }

}
