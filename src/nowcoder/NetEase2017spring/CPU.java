package nowcoder.NetEase2017spring;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 * WRONG
 */
public class CPU {
    private static int N;
    private static int cpu1, cpu2;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            N = in.nextInt();
            int[] datas = new int[N];
            for (int i = 0; i < N; i++) {
                datas[i] = in.nextInt();
            }
            doJobs(datas);
        }
    }

    public static void doJobs(int[] datas) {
        Arrays.sort(datas);
        cpu1 = 0;
        cpu2 = 0;
        for (int i = N - 1; i >= 0; i--) {
            if (cpu1 < cpu2) {
                cpu1 += datas[i];
            } else {
                cpu2 += datas[i];
            }
        }
        System.out.println(cpu1 > cpu2 ? cpu1 : cpu2);
    }
}
