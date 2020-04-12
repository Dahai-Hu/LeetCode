package ByteDance;

import java.util.Scanner;

public class ByteDance2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        ListNode head = new ListNode();
        for (int i = 0; i < n; i++) {
            head.next = new ListNode(scanner.nextInt());
        }
        int res = getNum(head);
        System.out.println(res);
    }
    public static int getNum(ListNode head) {
        int count = 0;
        ListNode pre = head.next;
        ListNode cur= pre.next;
        while (pre.next != null) {
            solution(pre, cur,count);
        }
        return count;
    }

    public static int solution(ListNode pre,ListNode cur,int count) {
        if (pre.val < cur.val) {
            ListNode temp = new ListNode();
            temp.val = cur.val/2;
            count++;
            cur.val = cur.val - temp.val;
            pre.next = temp;
            temp.next = cur;
        }
        return count;
    }
}
class ListNode {
    int val;
    ListNode next;
    public ListNode() {
    }
    ListNode(int x) {
        val = x;
        next = null;
    }
}