package day0415;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * @hurusea
 * @create2020-04-15 15:49
 */
public class Solution {
    /**
     * 0,1,,n-1这n个数字排成一个圆圈，从数字0开始，每次从这个圆圈里删除第m个数字。
     * 求出这个圆圈里剩下的最后一个数字。例如，0、1、2、3、4这5个数字组成一个圆圈，
     * 从数字0开始每次删除第3个数字，则删除的前4个数字依次是2、0、4、1，因此最后剩下的数字是3。
     *
     * @param n
     * @param m
     * @return
     */
    public int lastRemaining(int n, int m) {
        /*ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int index = m - 1;
        while (list.size() > 1) {
            list.remove(index);
            index = (index + m -1) % list.size();
        }
        return list.get(0);*/
        int ans = 0;
        // 最后一轮剩下2个人，所以从2开始反推
        for (int i = 2; i <= n; i++) {
            ans = (ans + m) % i;
        }
        return ans;
    }

    @Test
    public void testlastRemaining() {
        int res = lastRemaining(5, 3);
        System.out.println(res);
    }

    /**
     * 假设把某股票的价格按照时间先后顺序存储在数组中，请问买卖该股票一次可能获得的最大利润是多少？
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
//        int cost = Integer.MAX_VALUE, profit = 0;
//        for(int price : prices) {
//            cost = Math.min(cost, price);
//            profit = Math.max(profit, price - cost);
//        }
//        return profit;
        int min = Integer.MAX_VALUE;
        int money = 0;
        for (int i = 0; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            money = Math.max(prices[i] - min, money);
        }
        return money;
    }

    /**
     * 求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
     *
     * @param n
     * @return
     */
    public int sumNums(int n) {
        return -1;
    }

    /**
     * 写一个函数，求两个整数之和，要求在函数体内不得使用 “+”、“-”、“*”、“/” 四则运算符号。
     *
     * @param a
     * @param b
     * @return
     */
    public int add(int a, int b) {
        if (b == 0) return a;
        if (a == 0) return b;
        int plus1 = (a ^ b); // 求和（不计进位）. 相同位置0，相反位置1
        int plus2 = ((a & b) << 1); // 计算进位. 先保留同为1的位，都为1的位要向左进位，因此左移1位
        return add(plus1, plus2);
    }

    /**
     * 给定一个数组 A[0,1,…,n-1]，请构建一个数组 B[0,1,…,n-1]，
     * 其中 B 中的元素 B[i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]。不能使用除法。
     *
     * @param a
     * @return
     */
    public int[] constructArr(int[] a) {
        if (0 == a.length) {
            return new int[0];
        }
        int length = a.length;
        int[] b = new int[length];
        b[0] = 1;
        for (int i = 1; i < length; i++) {
            b[i] = b[i - 1] * a[i - 1];
        }
        int temp = 1;
        for (int j = length - 2; j >= 0; j--) {
            temp *= a[j + 1];
            b[j] *= temp;
        }
        return b;
    }
}
