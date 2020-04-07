package Alibaba;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * @hurusea
 * @create2020-04-07 19:50
 */
public class Netease {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        ArrayList<Integer> xx = new ArrayList<>();
        ArrayList<Integer> yy = new ArrayList<>();
        int count = 1;
        int num = n*4+1;
        while (count<num){
            if ((count % 2) != 0) {
                xx.add(in.nextInt());
            } else {
                yy.add(in.nextInt());
            }
            count++;
        }
        Integer x_Max = Collections.max(xx);
        Integer x_Min = Collections.min(xx);
        Integer y_Max = Collections.max(yy);
        Integer y_Min = Collections.min(xx);
        int res = (x_Max - x_Min) * (y_Max - y_Min);
        System.out.println(res);
    }
}
