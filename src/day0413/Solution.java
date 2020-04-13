package day0413;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @hurusea
 * @create2020-04-13 21:05
 */
public class Solution {

    /**
     * 一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。
     * 请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。
     * @param nums
     * @return
     */
    public int[] singleNumbers(int[] nums) {
        int xorNumber = nums[0];
        for(int k=1; k<nums.length; k++){
            xorNumber ^=nums[k];
        }
        int onePosition = xorNumber&(-xorNumber);
        int ans1 = 0, ans2 = 0;
        for(int i=0; i<nums.length; i++){
            if((nums[i]&onePosition)==onePosition){
                ans1^=nums[i];
            }else{
                ans2^=nums[i];
            }
        }

        return new int[] {ans1^0, ans2^0};
    }

    @Test
    public void testsingleNumbers() {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        while (scanner.hasNextInt()) {
            list.add(scanner.nextInt());
        }
//        Integer[] nums = list.toArray(new Integer[list.size()]);
        int[] nums = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            nums[i] = list.get(i);
        }
        singleNumbers(nums);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        while (scanner.nextInt()!=0) {
            list.add(scanner.nextInt());
        }
//        Integer[] nums = list.toArray(new Integer[list.size()]);
        int[] nums = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            nums[i] = list.get(i);
        }
        Solution solution = new Solution();
        int[] res = solution.singleNumbers(nums);
        System.out.println(Arrays.toString(res));

    }

    /**
     * 在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字。
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        int a=0,b=0;
        for (int c : nums) {
            b = b ^ c & ~ a;
            a = a ^ c & ~ b;
        }
        return b;
    }
}