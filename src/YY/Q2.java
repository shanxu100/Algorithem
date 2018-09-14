package YY;

import java.util.Scanner;

/**
 * @author Guan
 * @date Created on 2018/9/14
 */
public class Q2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println(sum(2));

//        int m, n;
//        while (in.hasNext()) {
//            m = in.nextInt();
//            n = in.nextInt();
//
//            for
//        }


    }

    public static int sum(int n) {
        int s = 1;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                s += i;
                n = n / i;
            }
        }
        if (n > 1) {
            s = s + n;
        }
        return s;
    }

    static int count(int n) {
        int s = 1;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                int a = 0;
                while (n % i == 0) {
                    n /= i;
                    a++;
                }
                s = s * (a + 1);
            }
        }
        if (n > 1) s = s * 2;
        return s;
    }
}
