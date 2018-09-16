package Tencent;

import java.util.Scanner;

/**
 * @author Guan
 * @date Created on 2018/9/16
 */
public class Q1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int n = in.nextInt();
            int result = getS(n);
            if (n % result == 0) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
    }

    public static int getS(int n) {
        int result = 0;
        while (n > 0) {
            result += n % 10;
            n = n / 10;
        }
        return result;
    }
}
