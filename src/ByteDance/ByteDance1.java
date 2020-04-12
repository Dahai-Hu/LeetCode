package ByteDance;

import java.util.Scanner;

/**
 * @hurusea
 * @create2020-04-12 18:34
 */
public class ByteDance1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        //t组测试数据
        for (int i = 0; i < t; i++) {
            //每行有n个数字
            int n = scanner.nextInt();
            int[] a = new int[n];
            int[] b = new int[n];
            for (int j = 0; j < n; j++) {
                a[j] = scanner.nextInt();
            }
            for (int j = 0; j < n; j++) {
                b[j] = scanner.nextInt();
            }
            if (solution(a, b)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }

    }

    public static boolean solution(int[] a, int[] b) {
        int k = 0;
        int flag = 0;
        for (int i = 0; i < a.length; i++) {
            if (b[i] - a[i] == k) {
                continue;
            } else if (a[i] - b[i] > 0) {
                return false;
            } else {
                if (b[i] - a[i] !=0) {
                    flag++;
                    k = b[i] - a[i];
                } else {
                    k = 0;
                }
            }
        }
        if (flag == 1) {
            return true;
        } else {
            return false;
        }
    }
}
