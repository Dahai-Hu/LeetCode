package day0329;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @hurusea
 * @create2020-03-30 19:11
 */
public class Test {
    public static void main(String[] args) {
        Test test = new Test();
        int[] arr = {100, 200, 400};
        int chickenNum = test.chickenNum(3,3,100, arr);
        System.out.println(chickenNum);
    }

    public int chickenNum(int n,int m,int k,int[] list) {
        int sum = 0;
        for (int i = 0; i < m ; i++) {
            for (int j = 0; j <n; j++) {
                list[j]+=k;
            }
            Arrays.sort(list);
            list[n-1] = list[n-1]/2;
        }
        for (int i = 0; i <n; i++) {
            sum += list[i];
        }
        return sum;
    }
}
