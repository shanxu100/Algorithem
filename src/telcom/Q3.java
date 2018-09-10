package telcom;

import java.util.Scanner;

/**
 * @author Guan
 * @date Created on 2018/9/10
 */
public class Q3 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);


        while (in.hasNext()) {

            int N = in.nextInt();
            System.out.println(f(N));
        }


    }

    public static int f(int N) {
        if (N <= 0) {
            return 0;
        }
        int number = 0;
        int count = 0;
        while (count < N) {
            number++;
            if (isUgly(number)) {
                count++;
            }
        }
        return number;
    }

    public static boolean isUgly(int num) {
        while (num % 2 == 0) {
            num /= 2;
        }
        while (num % 3 == 0) {
            num /= 3;
        }
        while (num % 5 == 0) {
            num /= 5;
        }
        return (num == 1) ? true : false;
    }

}
