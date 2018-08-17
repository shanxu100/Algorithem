package DP;

import java.util.Scanner;

/**
 * @author Guan
 * @date Created on 2018/8/13
 */
public class Criminals {


    public static int n, t, c;
    public static int[] data;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            n = in.nextInt();
            t = in.nextInt();
            c = in.nextInt();
            data = new int[n];

            for (int i = 0; i < n; i++) {
                data[i] = in.nextInt();
            }

            long sum = 0;
            int count = 0;
            for (int i = 0; i < c; i++) {
                sum += data[i];
            }
            if (sum <= t) {
                count++;
            }
            for (int i = c; i < n; i++) {
                sum = sum - data[i - c] + data[i];
                if (sum <= t) {
                    count++;
                }
            }
            System.out.println(count);
        }



    }

}
