package day0408;

import org.junit.Test;

import java.util.Arrays;

/**
 * @hurusea
 * @create2020-04-08 10:49
 */
public class Solution {
    /**
     * 输入一个整型数组，数组里有正数也有负数。数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
     * 要求时间复杂度为O(n)。
     *
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int res = nums[0];
        for(int i = 1; i < nums.length; i++) {
            nums[i] += Math.max(nums[i - 1], 0);
            res = Math.max(res, nums[i]);
        }
        return res;
    }

    @Test
    public void testMaxSubArray() {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        int res = maxSubArray(nums);
        System.out.println(res);
        for (int i = 0; i <nums.length; i++) {
            System.out.print(nums[i]+" ");
        }
    }

    /**
     * 输入一个整数 n ，求1～n这n个整数的十进制表示中1出现的次数。
     * 例如，输入12，1～12这些整数中包含1 的数字有1、10、11和12，1一共出现了5次。
     * @param n
     * @return
     */
    public int countDigitOne(int n) {
        return f(n);
    }
    private int f(int n ) {
        if (n <= 0)
            return 0;
        String s = String.valueOf(n);
        int high = s.charAt(0) - '0';
        int pow = (int) Math.pow(10, s.length()-1);
        int last = n - high*pow;
        if (high == 1) {
            return f(pow-1) + last + 1 + f(last);
        } else {
            return pow + high*f(pow-1) + f(last);
        }
    }

    @Test
    public void testCountDigitOne() {
        int res = countDigitOne(10240000);
        System.out.println(res);
    }

    /**
     * 数字以0123456789101112131415…的格式序列化到一个字符序列中。
     * 在这个序列中，第5位（从下标0开始计数）是5，第13位是1，第19位是4，等等。
     * 请写一个函数，求任意第n位对应的数字。
     * @param n
     * @return
     */
    public int findNthDigit(int n) {
        if(n < 10) return n;
        //计算当前范围有几位数字 如10-99 有90*power位 power = 2
        int count = 0;
        int power = 1;
        while(true){
            count = helper(power);
            //n在count这个范围内
            if(n < count) break;
            n -= count;
            power++;
        }
        //计算计数到的这个数字
        //Math.pow(10,power-1) -- 起始数字 n/power -- 剩余补充数字
        int resNum = (int)(Math.pow(10,power-1) + n/power);
        return String.valueOf(resNum).charAt(n % power) - '0';
    }
    public int helper(int power){
        if(power == 1) return 10;
        return (int)(Math.pow(10,power-1) * 9 * power);
    }

    /**
     * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，
     * 打印能拼接出的所有数字中最小的一个。
     * @param nums
     * @return
     */
    public String minNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for (int i = 0; i <strs.length; i++) {
            strs[i]=String.valueOf(nums[i]);
        }
        Arrays.sort(strs, (x,y)->(x+y).compareTo(y+x));
        StringBuilder res = new StringBuilder();
        for (String ele:strs) {
            res.append(ele);
        }
        return res.toString();
    }

    @Test
    public void testMinNumber() {
        int[] nums = new int[]{3,30,34,5,9};
        String res = minNumber(nums);
        System.out.println(res);
    }

}
