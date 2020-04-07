package day0407;

import org.junit.Test;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @hurusea
 * @create2020-04-07 8:54
 */
public class Solution {
    /**
     *
     * @param root
     * @return
     * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。
     * 要求不能创建任何新的节点，只能调整树中节点指针的指向。
     */
    Node pre = new Node(0), head = pre;
    public Node treeToDoublyList(Node root) {
        if(root == null) return null;
        dfs(root);
        head = head.right;
        head.left = pre;
        pre.right = head;
        return head;
    }
    void dfs(Node cur) {
        if(cur == null) return;
        dfs(cur.left);
        pre.right = cur;
        cur.left = pre;
        pre = cur;
        dfs(cur.right);
    }

    /**
     * 序列化二叉树。
     * @param root
     * @return
     */

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "[]";
        StringBuilder res = new StringBuilder("[");
        Queue<TreeNode> queue = new LinkedList<>() {{ add(root); }};
        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if(node != null) {
                res.append(node.val + ",");
                queue.add(node.left);
                queue.add(node.right);
            }
            else res.append("null,");
        }
        res.deleteCharAt(res.length() - 1);
        res.append("]");
        return res.toString();
    }

    /**
     * 反序列化二叉树
     * @param data
     * @return
     */
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.equals("[]")) return null;
        String[] vals = data.substring(1, data.length() - 1).split(",");
        TreeNode root = new TreeNode(Integer.parseInt(vals[0]));
        Queue<TreeNode> queue = new LinkedList<>() {{ add(root); }};
        int i = 1;
        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if(!vals[i].equals("null")) {
                node.left = new TreeNode(Integer.parseInt(vals[i]));
                queue.add(node.left);
            }
            i++;
            if(!vals[i].equals("null")) {
                node.right = new TreeNode(Integer.parseInt(vals[i]));
                queue.add(node.right);
            }
            i++;
        }
        return root;
    }

    /**
     *数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
     * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        int count = 0;
        int flag = nums.length/2;
        for (int i = 0; i <nums.length; i++) {
            int temp = nums[i];
            for (int j = 0; j <nums.length; j++) {
                if (nums[j]==temp){
                    count++;
                }
            }
            if (count > flag) {
                return nums[i];
            }
            count = 0;
        }
        return -1;
    }

    @Test
    public void test() {
        int[] nums = {1, 2, 3, 2, 2, 2, 5, 4, 2};
        int result = majorityElement(nums);
        System.out.println(result);
    }

    /**
     * 输入整数数组 arr ，找出其中最小的 k 个数。
     * 例如，输入4、5、1、6、2、7、3、8这8个数字，
     * 则最小的4个数字是1、2、3、4。
     * @param arr
     * @param k
     * @return
     * 1.定义一个长度为k的数组res
     * 2.对arr进行遍历，将第一个元素放进res
     * 3.比较arr元素和res元素，保证res中升序
     * 4.res满了之后，将arr中的元素和res中第一个进行比较
     */
    public int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0) {
            return new int[0];
        }
        // 使用一个最大堆（大顶堆）
        // Java 的 PriorityQueue 默认是小顶堆，添加 comparator 参数使其变成最大堆
        Queue<Integer> heap = new PriorityQueue<>(k, (i1, i2) -> Integer.compare(i2, i1));

        for (int e : arr) {
            // 当前数字小于堆顶元素才会入堆
            if (heap.isEmpty() || heap.size() < k || e < heap.peek()) {
                heap.offer(e);
            }
            if (heap.size() > k) {
                heap.poll(); // 删除堆顶最大元素
            }
        }

        // 将堆中的元素存入数组
        int[] res = new int[heap.size()];
        int j = 0;
        for (int e : heap) {
            res[j++] = e;
        }
        return res;
    }

}

class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}