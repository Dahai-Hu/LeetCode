package day0414;

import org.junit.Test;

import java.util.*;

/**
 * @hurusea
 * @create2020-04-14 9:57
 */
public class Solution {
    /**
     * 输入一个递增排序的数组和一个数字s，在数组中查找两个数，
     * 使得它们的和正好是s。如果有多对数字的和等于s，则输出任意一对即可。
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            if (nums[start] + nums[end] < target) {
                start++;
            } else if (nums[start] + nums[end] > target) {
                end--;
            } else {
                res[0] = nums[start];
                res[1] = nums[end];
                break;
            }
        }
        return res;
    }

    /**
     * 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
     * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
     *
     * @param target
     * @return
     */
    public int[][] findContinuousSequence(int target) {
        int i = 1; // 滑动窗口的左边界
        int j = 1; // 滑动窗口的右边界
        int sum = 0; // 滑动窗口中数字的和
        List<int[]> res = new ArrayList<>();

        while (i <= target / 2) {
            if (sum < target) {
                // 右边界向右移动
                sum += j;
                j++;
            } else if (sum > target) {
                // 左边界向右移动
                sum -= i;
                i++;
            } else {
                // 记录结果
                int[] arr = new int[j - i];
                for (int k = i; k < j; k++) {
                    arr[k - i] = k;
                }
                res.add(arr);
                // 左边界向右移动
                sum -= i;
                i++;
            }
        }
        return res.toArray(new int[res.size()][]);
    }

    /**
     * 输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。
     * 为简单起见，标点符号和普通字母一样处理。例如输入字符串"I am a student. "，
     * 则输出"student. a am I"。
     *
     * @param s
     * @return
     */
    public String reverseWords(String s) {
        s = s.trim(); // 删除首尾空格
        int j = s.length() - 1, i = j;
        StringBuilder res = new StringBuilder();
        while (i >= 0) {
            while (i >= 0 && s.charAt(i) != ' ') i--; // 搜索首个空格
            res.append(s.substring(i + 1, j + 1) + " "); // 添加单词
            while (i >= 0 && s.charAt(i) == ' ') i--; // 跳过单词间空格
            j = i; // j 指向下个单词的尾字符
        }
        return res.toString(); // 转化为字符串并返回
    }

    /**
     * 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。
     * 请定义一个函数实现字符串左旋转操作的功能。
     * 比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。
     *
     * @param s
     * @param n
     * @return
     */
    public String reverseLeftWords(String s, int n) {
        char[] chars = new char[s.length()];
        char[] res = new char[s.length()];
        for (int i = 0; i < s.length(); i++) {
            chars[i] = s.charAt(i);
        }
        for (int i = 0; i < res.length - n; i++) {
            res[i] = chars[i + n];
        }
        int j = 0;
        for (int i = res.length - n; i < res.length; i++) {
            res[i] = chars[j];
            j++;
        }
//        return Arrays.toString(res);
        StringBuilder sb = new StringBuilder();
        StringBuilder stringBuilder = sb.append(res);
        return stringBuilder.toString();
    }

    @Test
    public void testreverseLeftWords() {
        String s = "abcdefg";
        int n = 2;
        String res = reverseLeftWords(s, 2);
        System.out.println(res);
    }

    /**
     * 给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。
     *
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0) {
            return new int[0];
        }
        //循环判断n次
        int n = nums.length - k + 1;
        int[] res = new int[n];
        //头指针
        int i = 0;
        //尾指针
        int j = k - 1;
        //滑动窗口中最大值下标
        int max = 0;
        for (int l = 0; l < n; l++) {
            int temp = nums[l];
            for (int m = i; m <= j; m++) {
                if (nums[m] >= temp) {
                    max = m;
                    temp = nums[max];
                }
            }
            res[l] = nums[max];
            i++;
            j++;
        }
        return res;
    }

    @Test
    public void testmaxSlidingWindow() {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int[] res = maxSlidingWindow(nums, k);
        System.out.println(Arrays.toString(res));
    }

    /**
     * 请定义一个队列并实现函数 max_value 得到队列里的最大值，
     * 要求函数max_value、push_back 和 pop_front 的均摊时间复杂度都是O(1)。
     */
    private Deque<Integer> queue;
    private Deque<Integer> help;

    public Solution() {
        queue = new ArrayDeque<>();
        help = new ArrayDeque<>();
    }

    public int max_value() {
        return queue.isEmpty() ? -1 : help.peek();
    }

    public void push_back(int value) {
        queue.offer(value);
        while (!help.isEmpty() && value > help.peekLast()) {
            help.pollLast();
        }
        help.offer(value);
    }

    public int pop_front() {
        if (queue.isEmpty()) {
            return -1;
        }
        int val = queue.pop();
        if (help.peek() == val) {
            help.pop();
        }
        return val;
    }

    /**
     * 把n个骰子扔在地上，所有骰子朝上一面的点数之和为s。输入n，打印出s的所有可能的值出现的概率。
     *
     * @param n
     * @return
     */
    public double[] twoSum(int n) {
        int[][] dp = new int[n][6 * n];
        //初始条件
        for (int i = 0; i < 6; i++) {
            dp[0][i] = 1;
        }
        //动态规划
        for (int i = 1; i < n; i++) {
            for (int j = i - 1; j < 6 * n; j++) {
                for (int k = 1; k <= 6; k++) {
                    if (j - k < 0) {
                        break;
                    }
                    dp[i][j] += dp[i - 1][j - k];
                }
            }
        }
        double[] res = new double[5 * n + 1];
        for (int i = n; i <= 6 * n; i++) {
            res[i - n] = dp[n - 1][i - 1] / (double) Math.pow(6, n);
        }
        return res;
    }

    @Test
    public void testtwoSum() {
        double[] res = twoSum(2);
        System.out.println(Arrays.toString(res));
    }


    /**
     * 从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。
     * 2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。A 不能视为 14。
     *
     * @param nums
     * @return
     */
    public boolean isStraight(int[] nums) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int[] arr = new int[13];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                //判断重复
                if (arr[nums[i] - 1] == 1)
                    return false;
                else arr[nums[i] - 1] = 1;

                max = Math.max(nums[i], max);
                min = Math.min(nums[i], min);
            }
        }
        return max - min + 1 <= 5;
    }
}
