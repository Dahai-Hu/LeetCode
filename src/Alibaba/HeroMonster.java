package Alibaba;

import java.util.Scanner;

/**
 * @hurusea
 * @create2020-04-07 20:17
 */
public class HeroMonster {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        int [][] map = new int[m][n];
        for (int i = 0; i <map.length; i++) {
            for (int j = 0; j <map[i].length ; j++) {
                map[i][j] = scanner.nextInt();
            }
        }
        HeroMonster heroMonster = new HeroMonster();
        for (int i = 0; i <m; i++) {
            for (int j = 0; j <n; j++) {
                if (map[i][j]==1){
                    heroMonster.floyd();
                }
            }
        }
    }
    public void floyd(){
        int step = 0;
        for (int i = 0; i <2; i++) {

        }

    }
}
