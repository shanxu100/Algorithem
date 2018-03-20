package nowcoder.practice.mark;

import com.sun.corba.se.spi.legacy.connection.LegacyServerSocketManager;

import java.util.Scanner;

/**
 * https://www.nowcoder.com/practice/5a0a2c7e431e4fbbbb1ff32ac6e8dfa0?tpId=85&tqId=29848&tPage=1&rp=1&ru=/ta/2017test&qru=/ta/2017test/question-ranking
 * @author Guan
 * @date Created on 2018/3/4
 */
public class Shuffle {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T, n, k;
        int[] A;
        T = in.nextInt();

        for (int i = 0; i < T; i++) {
            n = in.nextInt();
            k = in.nextInt();
            A = new int[2 * n];

            for (int j = 0; j < 2 * n; j++) {
                A[j] = in.nextInt();
            }

            doShuffle(A, k);
        }

    }

    /**
     * 暴力法
     *
     * @param A
     * @param k
     */
    private static void doShuffle(int[] A, int k) {

        int length = A.length;
        int middle;
        int high;
        int[] tmp = new int[length];

        while (k > 0) {
            k--;
            middle = length / 2 - 1;
            high = length - 1;
            for (int i = length - 1; i >= 0; ) {
                tmp[i] = A[high];
                high--;
                i--;
                tmp[i] = A[middle];
                middle--;
                i--;
            }
            System.arraycopy(tmp, 0, A, 0, length);
        }
        output(A);
    }


    /**
     * 输出
     *
     * @param A
     */
    public static void output(int[] A) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < A.length; i++) {
            sb.append(A[i]).append(" ");
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb.toString());
    }
}
