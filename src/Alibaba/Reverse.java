package Alibaba;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @hurusea
 * @create2020-04-01 19:11
 */
public class Reverse {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N;
        N = sc.nextInt();
        int[] ans = new int[N];
        Arrays.fill(ans,Integer.MAX_VALUE);
        sc.nextLine();
        for (int i = 0; i < N; i++) {
            String str = sc.nextLine();
            int len = str.length();
            char[] resc = new char[len];
            Arrays.fill(resc,'0');
            String res = String.valueOf(resc);
            int times = (int)Math.pow(2,len);
            for (int j = 0; j < times; j++) {
                StringBuffer ss = new StringBuffer(str);
                int q = 0;
                int k = j;
                for (int p = 0; p < len; p++) {
                    if (k % 2 == 0){
                        ss = turn(ss,p);
                        q++;
                    }
                    k /= 2;
                }
                if (ss.toString().equals(res)){
                    ans[i] = Math.min(ans[i],q);
                }
            }
        }

        for (int i = 0; i < N; i++) {
            if (ans[i] == Integer.MAX_VALUE) {
                System.out.println("No");
            } else {
                System.out.println(ans[i]);
            }
        }
    }

    public static StringBuffer turn(StringBuffer sb, int index){
        if (index - 1 >= 0){
            if (sb.charAt(index - 1) == '1'){
                sb.setCharAt(index - 1,'0');
            }
            else {
                sb.setCharAt(index - 1, '1');
            }
        }
        if (sb.charAt(index) == '1'){
            sb.setCharAt(index,'0');
        }
        else {
            sb.setCharAt(index,'1');
        }
        if (index + 1 < sb.length()){
            if (sb.charAt(index + 1) == '1'){
                sb.setCharAt(index + 1,'0');
            }
            else {
                sb.setCharAt(index + 1, '1');
            }
        }
        return sb;
    }
}
