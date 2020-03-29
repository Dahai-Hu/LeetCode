package day0329;

import org.junit.Test;

/**
 * @hurusea
 * @create2020-03-29 9:47
 *
 * 面试题19-
 */
public class Solution {

    /**
     * 请实现一个函数用来匹配包含'. '和'*'的正则表达式。
     * 模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（含0次）。
     * 在本题中，匹配是指字符串的所有字符匹配整个模式。
     * 例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但与"aa.a"和"ab*a"均不匹配。
     * @param s
     * @param p
     * @return
     */

    public boolean isMatch(String s, String p) {

        return true;
    }


    /**
     * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
     * 例如，字符串"+100"、"5e2"、"-123"、"3.1416"、"0123"及"-1E-16"都表示数值，
     * 但"12e"、"1a3.14"、"1.2.3"、"+-5"及"12e+5.4"都不是。
     *
     *
     * @param s
     * @return
     */
    public boolean isNumber(String s) {
        if(s == null || s.length() == 0){
            return false;
        }
        //标记是否遇到相应情况
        boolean numSeen = false;
        boolean dotSeen = false;
        boolean eSeen = false;
        char[] str = s.trim().toCharArray();
        for(int i = 0;i < str.length; i++){
            if(str[i] >= '0' && str[i] <= '9'){
                numSeen = true;
            }else if(str[i] == '.'){
                //.之前不能出现.或者e
                if(dotSeen || eSeen){
                    return false;
                }
                dotSeen = true;
            }else if(str[i] == 'e' || str[i] == 'E'){
                //e之前不能出现e，必须出现数
                if(eSeen || !numSeen){
                    return false;
                }
                eSeen = true;
                numSeen = false;//重置numSeen，排除123e或者123e+的情况,确保e之后也出现数
            }else if(str[i] == '-' || str[i] == '+'){
                //+-出现在0位置或者e/E的后面第一个位置才是合法的
                if(i != 0 && str[i-1] != 'e' && str[i-1] != 'E'){
                    return false;
                }
            }else{//其他不合法字符
                return false;
            }
        }
        return numSeen;
    }


    /**
     * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
     * 使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
     * @param nums
     * @return
     */
    public int[] exchange(int[] nums) {
        int i = 0, j = nums.length - 1, tmp;
        while(i < j) {
            while(i < j && (nums[i] & 1) == 1) i++;
            while(i < j && (nums[j] & 1) == 0) j--;
            tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
        return nums;
    }


    @Test
    public void testGetthFromEnd(){
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        head.next=node2;
        node2.next=node3;
        node3.next=node4;
        node4.next=node5;
        node5.next=node6;
        node6.next=null;
        ListNode result = getKthFromEnd(head, 3);
        System.out.println(result.val);

    }
    /**
     *输入一个链表，输出该链表中倒数第k个节点。
     *为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
     * 例如，一个链表有6个节点，从头节点开始，它们的值依次是1、2、3、4、5、6。
     * 这个链表的倒数第3个节点是值为4的节点。
     * @param head
     * @param k
     * @return
     */

    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode result = head;
        ListNode temp = head;
        if (head==null){
            System.out.println("空链表异常");
            return null;
        }
        int n = 1;
        while (temp.next!=null){
            n++;
            temp=temp.next;
        }
        if (k>n){
            System.out.println("一共只有"+n+"个节点");
        }else {
            int step = n-k;
            while (step>0){
                step--;
                result=result.next;
            }
        }
        return result;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    /**
     *
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        ListNode cur = head;
        ListNode pre = null;
        ListNode temp = null;
        while (cur != null) {
            temp=cur.next;
            cur.next=pre;
            pre=cur;
            cur=temp;
        }
        return pre;
    }

    /**
     * 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dum = new ListNode(0), cur = dum;
        while(l1 != null && l2 != null) {
            if(l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            }
            else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        cur.next = l1 != null ? l1 : l2;
        return dum.next;
    }

}
