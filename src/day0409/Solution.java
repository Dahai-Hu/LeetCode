package day0409;

import org.junit.Test;

import java.time.temporal.Temporal;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @hurusea
 * @create2020-04-09 12:19
 */
public class Solution {
    /**
     * 给定一个数字，我们按照如下规则把它翻译为字符串：
     * 0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。
     * 一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
     * @param num
     * @return
     * num转成string，
     */
    public int translateNum(int num) {
        if (num<=9) {return 1;}
        //xyzcba
        int ba = num%100;
        if (ba<=9||ba>=26) {return translateNum(num/10);}
        else  {return translateNum(num/10)+translateNum(num/100);}
    }

    @Test
    public void testtranslateNum() {
        int res = translateNum(12258);
        System.out.println(res);
    }

    /**
     * 在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。
     * 你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、直到到达棋盘的右下角。
     * 给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？
     * @param grid
     * @return
     */
    public int maxValue(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(i == 0 && j == 0) continue;
                if(i == 0) grid[i][j] += grid[i][j - 1] ;
                else if(j == 0) grid[i][j] += grid[i - 1][j];
                else grid[i][j] += Math.max(grid[i][j - 1], grid[i - 1][j]);
            }
        }
        return grid[m - 1][n - 1];
    }
    @Test
    public void testmaxValue() {
        int[][] grid = {{1,3,1},{1,5,1},{4,2,1}};
        int value = maxValue(grid);
        System.out.println(value);
    }

    /**
     * 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>();//key出现的字符，value对应的最新的位置
        // try to extend the range [i, j]
        for (int end = 0, start = 0; end < n; end++) {
            if (map.containsKey(s.charAt(end))) {
                start = Math.max(map.get(s.charAt(end)) + 1, start);//由于重复的坐标不知道在start的前方还是后方，所以要取个最大值
            }
            ans = Math.max(ans, end - start + 1);
            map.put(s.charAt(end), end);
        }
        return ans;
    }

    /**
     * 我们把只包含因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。
     * @param n
     * @return
     */
    public int nthUglyNumber(int n) {
        int a = 0, b = 0, c = 0;
        int[] dp = new int[n];
        dp[0] = 1;
        for(int i = 1; i < n; i++) {
            int n2 = dp[a] * 2, n3 = dp[b] * 3, n5 = dp[c] * 5;
            dp[i] = Math.min(Math.min(n2, n3), n5);
            if(dp[i] == n2) a++;
            if(dp[i] == n3) b++;
            if(dp[i] == n5) c++;
        }
        return dp[n - 1];
    }

    /**
     * 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。
     * @param s
     * @return
     */
    public char firstUniqChar(String s) {
        int[] count = new int[26];
        for(char c : s.toCharArray()){
            count[c - 'a']++;
        }
        for(char c : s.toCharArray()){
            if(count[c - 'a'] == 1) return c;
        }
        return ' ';
    }

    @Test
    public void testfirstUniqChar() {
        String s = "sdhaishdkjasdj";
        char res = firstUniqChar(s);
        System.out.println(res);
    }

    /**
     *在数组中的两个数字，如果前面一个数字大于后面的数字，
     * 则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。
     * @param nums
     * @return
     */
    public int reversePairs(int[] nums) {
//        HashSet<Integer> hashSet = new HashSet<>();
//        for (int ele: nums) {
//            hashSet.add(ele);
//        }
//        int size = hashSet.size();
//        int res = size*(size-1)/2;
//        return res;
//        int res = 0;
//        for (int i = 0; i < nums.length -1; i++) {
//            for (int j = i + 1 ; j < nums.length; j++) {
//                if (nums[i] > nums[j]) {
//                    res++;
//                }
//            }
//        }
//        return res;
        return mergeSort(nums, 0, nums.length - 1);
    }

    private int mergeSort(int[] nums, int left, int right) {
        if (left >= right) return 0;
        int mid = (left + right) >> 1;
        //将归并的所有结果汇总返回
        int ans = mergeSort(nums, left, mid)
                + mergeSort(nums, mid + 1, right)
                + merge(nums, left, mid, right);
        return ans;
    }

    private int merge(int[] nums, int left, int mid, int right) {
        int i = left;
        int j = mid + 1;
        int k = 0;
        int count = 0;
        int res[] = new int[right - left + 1];
        while (i <= mid && j <= right) {
            if (nums[i] > nums[j]) count += mid - i + 1;//如果j位置小于i位置，那么j位置小于i位置后所有的左半边的数
            res[k++] = nums[i] <= nums[j] ? nums[i++] : nums[j++];
        }
        while (i <= mid) res[k++] = nums[i++];
        while (j <= right) res[k++] = nums[j++];
        for (int m = 0; m < res.length; m++) {
            nums[left + m] = res[m];
        }
        for (int l = 0; l < res.length; l++) {
            System.out.print(res[l]);
        }
        System.out.println();
        return count;
    }

    @Test
    public void testreversePairs() {
        int[] nums = {7, 5, 6, 4};
        int res = reversePairs(nums);
        System.out.println("===============");
        System.out.println(res);
    }
}
