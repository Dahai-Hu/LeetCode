package Alibaba;

import java.util.Scanner;

/**
 * 编程题No.1
 * @hurusea
 * @create2020-04-01 15:30
 */
public class Question01 {
    public static void main(String[] args) {
        Question01 question01 = new Question01();
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 0; i <t; i++) {
            String str = scanner.nextLine();
            question01.canReverse(str);
        }

    }

    public void canReverse(String string) {


    }
}
