package netease.school;

import java.util.Scanner;

/**
 * @author Guan
 * @date Created on 2018/9/8
 */
public class Q2 {

    private static int[][] b;
    private static int t;
    private static int N, M;


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            t = in.nextInt();
            for (int i = 0; i < t; i++) {
                N = in.nextInt();
                M = in.nextInt();
                f();
            }


        }


    }

    public static void f() {
        b = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                b[i][j] = 0;
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                change(i, j);
            }
        }

        long result = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (b[i][j] % 2 != 0) {
                    result++;
                }
            }
        }
        System.out.println(result);

    }

    public static void change(int i, int j) {
        int i1 = i - 1;
        int j1 = j - 1;
        int i2 = i + 1;
        int j2 = j + 1;
        if (i1 >= 0) {
            if (j1 >= 0) {
                b[i1][j1]++;
            }
            b[i1][j]++;
            if (j2 < M) {
                b[i1][j2]++;
            }
        }

        if (j1 >= 0) {
            b[i][j1]++;
        }
        b[i][j]++;
        if (j2 < M) {
            b[i][j2]++;
        }

        if (i2 < N) {
            if (j1 >= 0) {
                b[i2][j1]++;
            }
            b[i2][j]++;
            if (j2 < M) {
                b[i2][j2]++;
            }
        }

    }

}
