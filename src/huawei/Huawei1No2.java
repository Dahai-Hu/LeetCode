package huawei;

import java.util.Scanner;

/**
 * @hurusea
 * @create2020-04-08 21:15
 */
public class Huawei1No2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int l = scanner.nextInt();
            if (n == 0 && l == 0) {
                break;
            }
            System.out.println(solution(n, l));
        }
    }
    public static int solution(int n,int l){
        if (l == 0) {
            return 0;
        }
        if (n == 0) {
            return l;
        }
        int count = 0;
        for (int i = 1; i <=l; i++) {
            count=count+(int)Math.pow(n,i)%1000000007;
        }
        return count%1000000007;
    }
}
