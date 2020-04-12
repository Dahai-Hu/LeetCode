package ByteDance;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        ListNode head = new ListNode();
        ListNode tmp = head;
        for (int i = 0; i < n; i++) {
            tmp.next = new ListNode(scanner.nextInt());
            tmp = tmp.next;
        }
        int res = getNum(head);
        System.out.println(res);
    }
    public static int getNum(ListNode head) {
        int count = 0;
        ListNode pre = head.next;
        ListNode cur= pre.next;
        if (pre.next != null&&pre.val < cur.val) {
            ListNode temp = new ListNode();
            temp.val = pre.val-pre.val/2;
            count++;
            pre.val = pre.val/2;
            pre.next = temp;
            temp.next = cur;
        }
        int ans = getNum(head);
        count+=ans;
        return count;
    }
}
