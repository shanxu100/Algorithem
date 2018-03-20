package nowcoder.practice;

import java.util.Scanner;
import java.util.Set;

/**
 * AC
 *
 * @author Guan
 * @date Created on 2018/3/6
 */
public class CrossRiver {
    public static int N;
    public static int[] arr = new int[1001];
    public static int[] result = new int[1001];
    public static int minValue;

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            N = in.nextInt();
            for (int i = 0; i < N; i++) {
                arr[i] = in.nextInt();
                result[i] = Integer.MAX_VALUE;
            }
            result[0] = 0;
            crossRiver();
        }
    }

    private static void crossRiver() {
        minValue = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            int step = arr[i];
            if (step == 0 || result[i] == Integer.MAX_VALUE) {
                continue;
            }
            int tmp = result[i] + 1;
            for (int j = 1; j <= step; j++) {
                if (i + j >= N) {
                    minValue = tmp < minValue ? tmp : minValue;
                } else {
                    result[i + j] = tmp < result[i + j] ? tmp : result[i + j];
                }
            }
        }

        if (minValue == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(minValue);
        }
    }
}
