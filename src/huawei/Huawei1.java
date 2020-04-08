package huawei;

import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Scanner;

/**
 * @hurusea
 * @create2020-04-08 17:59
 */
public class Huawei1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Long> list = new ArrayList<Long>();
        while (scanner.hasNextLine()) {
            int n = scanner.nextInt();
            int l = scanner.nextInt();
            if (n==0&&l==0){
                break;
            }
            long res = 0;
            for (int i = 1; i <=l; i++) {
                res = res+(long)Math.pow(n,i)%1000000007;
            }
            System.out.println(res);
            list.add(res);
        }
        Object[] array = list.toArray();
        for (int i = 0; i <array.length; i++) {
//            System.out.println(array[i]);
        }
    }
}
