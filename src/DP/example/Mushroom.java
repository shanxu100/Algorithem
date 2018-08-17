package DP.example;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * 蘑菇阵
 * https://www.nowcoder.com/practice/ed9bc679ea1248f9a3d86d0a55c0be10?tpId=49&&tqId=29290&rp=2&ru=/activity/oj&qru=/ta/2016test/question-ranking
 *
 * @author Guan
 * @date Created on 2018/8/13
 */
public class Mushroom {

    public static int N, M, K;

    public static Node[][] data;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            N = in.nextInt();
            M = in.nextInt();
            K = in.nextInt();
            data = new Node[N][M];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    data[i][j] = new Node();
                }
            }
            int x, y;
            for (int i = 0; i < K; i++) {
                x = in.nextInt() - 1;
                y = in.nextInt() - 1;
                data[x][y].hasMushroom = true;
            }

            doJob();

        }
    }

    public static void doJob() {

        boolean hasMushroom = false;
        // 行
        for (int i = 0; i < M; i++) {
            data[0][i].total = 1;
            if (data[0][i].hasMushroom) {
                hasMushroom = true;
            }
            if (hasMushroom) {
                data[0][i].num = 1;
            }
        }
        hasMushroom = false;
        // 列
        for (int i = 0; i < N; i++) {
            data[i][0].total = 1;
            if (data[i][0].hasMushroom) {
                hasMushroom = true;
            }
            if (hasMushroom) {
                data[i][0].num = 1;
            }
        }

        for (int i = 1; i < N; i++) {
            for (int j = 1; j < M; j++) {
                data[i][j].total = data[i - 1][j].total + data[i][j - 1].total;
                if (data[i][j].hasMushroom) {
                    data[i][j].num = data[i][j].total;
                } else {
                    data[i][j].num = data[i - 1][j].num + data[i][j - 1].num;
                }
            }
        }

        DecimalFormat df = new DecimalFormat("#0.00");
        double result = (data[N - 1][M - 1].total - data[N - 1][M - 1].num)/ data[N - 1][M - 1].total;
        System.out.println(df.format(result));
    }


    public static class Node {
        boolean hasMushroom = false;
        double total = 0, num = 0;
    }
}
