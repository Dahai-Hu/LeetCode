package huawei;

import java.util.Scanner;

/**
 * @hurusea
 * @create2020-04-08 22:34
 */
public class Huawei1No3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true){
            int n = sc.nextInt();
            int l = sc.nextInt();
            if(n == 0 && l == 0) break;
            long res = 0;
            for (int i = 1; i <= l; i++) {
                res += quickMi(n, i);
            }
            System.out.println(res % 1000000007);
        }
        sc.close();
    }

    private static long quickMi(long aa, long bb){
        long res = 1;
        long a = aa, b = bb;
        a %= 1000000007;
        for (; b != 0; b /=2) {
            if(b % 2 == 1){
                res = (res * a) % 1000000007;
            }
            a = (a * a) % 1000000007;
        }
        return res;
    }
}
