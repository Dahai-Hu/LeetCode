package day0329;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @hurusea
 * @create2020-03-30 20:16
 */
public class Chicken {

    public static void main(String[] args) {
        Scanner scaner = new Scanner(System.in);
        if(scaner.hasNextInt()){
            int n = scaner.nextInt();
            int m = scaner.nextInt();
            int k = scaner.nextInt();
            int[] a = new int[n];
            PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
                public int compare(Integer o1, Integer o2) {
                    return  o2.compareTo(o1);
                }
            });
            for(int i = 0;i < n;i++)
                queue.add(scaner.nextInt()+m*k); //先全部加上m*k
            int index = m-1;
            while(m-->0 && !queue.isEmpty()){
                int x = queue.poll();
                x = (x -index*k)/2+index*k;  //每次减去index*k
                queue.add(x);
                index --;
            }
            int ans =0;
            for (int x:queue)
                ans +=x;
            System.out.println(ans);
        }
    }
}
