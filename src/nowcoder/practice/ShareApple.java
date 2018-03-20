package nowcoder.practice;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author Guan
 * @date Created on 2018/3/5
 */
public class ShareApple {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n;
        int[] a;
        while (in.hasNextInt()) {
            n = in.nextInt();
            a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = in.nextInt();
            }

            System.out.println(shareApple(n, a));
        }

    }

    private static int shareApple(int n, int[] a) {
        int total = 0;
        int average, result, diff;
        int[] tmp = new int[n];
        for (int i = 0; i < n; i++) {
            total += a[i];
        }
        if (total % n != 0) {
            return -1;
        }
        average = total / n;
        result = 0;
        for (int i = 0; i < n; i++) {
            tmp[i] = average - a[i];
            if (tmp[i] % 2 != 0) {
                return -1;
            }
            if (tmp[i] > 0) {
                result += tmp[i] / 2;
            }
        }
        return result;

    }
}
