package nowcoder.practice;

import java.util.Scanner;

/**
 * @author Guan
 * @date Created on 2018/8/18
 */
public class Chat {

    public static int p, q, l, r;
    public static int[][] A;
    public static int[][] B;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNext()) {

            p = input.nextInt();
            q = input.nextInt();
            l = input.nextInt();
            r = input.nextInt();
            A = new int[p][2];
            B = new int[q][2];
            for (int i = 0; i < p; i++) {
                A[i][0] = input.nextInt();
                A[i][1] = input.nextInt();
            }
            for (int i = 0; i < q; i++) {
                B[i][0] = input.nextInt();
                B[i][1] = input.nextInt();
            }
            System.out.println(doJob());

        }
    }

    public static int doJob() {

        int count = 0;
        for (int t = l; t <= r; t++) {
            if (isAvailable(t)) {
                count++;
            }
        }
        return count;

    }

    public static boolean isAvailable(int t) {
        for (int i = 0; i < p; i++) {
            for (int j = 0; j < q; j++) {
                //关键：比较区间是否重合
                if (A[i][0] <= B[j][1] + t && A[i][1] >= B[j][0] + t) {
                    return true;
                }
            }
        }
        return false;
    }


}
