package ali;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @author Guan
 * @date Created on 2018/9/7
 */
public class Q1 {

    public static void main(String[] args) {
        System.out.println(maxNum(20, 7));
        ;

    }

    static int M, N;
    static HashMap<Integer, Integer> map = new HashMap<>(9);

    static boolean stop = false;
    static StringBuilder sb = new StringBuilder();


    static String maxNum(int m, int n) {

        map.put(1, 1);
        map.put(2, 5);
        map.put(3, 5);
        map.put(4, 4);
        map.put(5, 5);
        map.put(6, 6);
        map.put(7, 3);
        map.put(8, 7);
        map.put(9, 6);

        N = n;
        int[] holder = new int[n];
        f(m, holder, 0);
        return sb.toString();

    }

    public static void f(int m, int[] holder, int count) {
        if (m <= 0 || stop) {
            return;
        }

        if (count == N) {
            stop = true;
            for (int i = 0; i < N; i++) {
                sb.append(holder[i] + "");
            }
            return;
        }
        for (int i = 9; i > 0; i--) {
            int price = map.get(i);
            if (m - price > 0) {
                holder[count] = i;
                f(m - price, holder, count + 1);
            }

        }

    }

}
