package day0410;

import org.junit.Test;

import java.util.*;

/**
 * @hurusea
 * @create2020-04-10 10:14
 */
public class Solution {
    /**
     * 输入两个链表，找出它们的第一个公共节点。
     * @param headA
     * @param headB
     * @return
     * 程序尽量满足 O(n) 时间复杂度，且仅用 O(1) 内存。
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        LinkedHashMap<ListNode, Boolean> map = new LinkedHashMap<>();
        ListNode cur1 = headA;
        ListNode cur2 = headB;
        while (cur1!= null) {
            map.put(cur1, map.containsKey(cur1));
            cur1 = cur1.next;
        }
        while (cur2!=null) {
            if (map.containsKey(cur2)) {
                return cur2;
            }
            cur2 = cur2.next;
        }
        return null;
    }

    @Test
    public void testgetIntersectionNode() {
        ListNode headA = new ListNode(0);
        headA.next = new ListNode(9);
        headA.next.next = new ListNode(1);
        ListNode com = new ListNode(2);
        headA.next.next.next = com;
        com.next = new ListNode(4);
        ListNode headB = new ListNode(3);
        headB.next = com;
        ListNode res = getIntersectionNode(headA, headB);
        System.out.println(res.val);
    }

    /**
     * 统计一个数字在排序数组中出现的次数。
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
//        if (nums == null) {
//            return -1;
//        }
//        int count = 0;
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i]==target) {
//                count++;
//            }
//        }
//        return count;
        int i = 0, j = nums.length - 1;
        while(i <= j) {
            int m = (i + j) / 2;
            if(nums[m] <= target) i = m + 1;
            else j = m - 1;
        }
        int right = i;

        i = 0; j = nums.length - 1;
        while(i <= j) {
            int m = (i + j) / 2;
            if(nums[m] < target) i = m + 1;
            else j = m - 1;
        }
        int left = j;

        return right - left - 1;
    }

    /**
     * 一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。
     * 在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
     * @param nums
     * @return
     */
    public int missingNumber(int[] nums) {
//        for (int i = 0; i < nums.length ; i++) {
//            if (nums[i] != i) {
//                return i;
//            }
//        }
//        return nums.length;
        int i = 0, j = nums.length - 1;
        while(i <= j) {
            int m = (i + j) / 2;
            if(nums[m] == m) i = m + 1;
            else j = m - 1;
        }
        return i;
    }

    @Test
    public void testmissingNumber() {
        int[] nums = {0, 1, 2, 3, 4, 5, 6, 7, 9};
        int res = missingNumber(nums);
        System.out.println(res);
    }

    /**
     * 给定一棵二叉搜索树，请找出其中第k大的节点。
     * @param root
     * @param k
     * @return
     */
    int res, k;
    public int kthLargest(TreeNode root, int k) {
        this.k = k;
        dfs(root);
        return res;
    }
    void dfs(TreeNode root) {
        if(root == null) return;
        dfs(root.right);
        if(--k == 0) res = root.val;
        dfs(root.left);
    }

    /**
     * 输入一棵二叉树的根节点，求该树的深度。
     * 从根节点到叶节点依次经过的节点（含根、叶节点）形成树的一条路径，
     * 最长路径的长度为树的深度。
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
