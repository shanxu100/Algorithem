package nowcoder.toutiao;

import java.util.Scanner;

/**
 * @author Guan
 * @date Created on 2018/3/23
 */
public class UserInterest {
    public static int n, q;
    public static int[] A;
    public static Holder[] B;


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            n = in.nextInt();
            A = new int[n];
            for (int i = 0; i < n; i++) {
                A[i] = in.nextInt();
            }
            q = in.nextInt();
            B = new Holder[q];
            for (int i = 0; i < q; i++) {
                Holder holder = new Holder();
                holder.l = in.nextInt();
                holder.r = in.nextInt();
                holder.k = in.nextInt();
                B[i] = holder;
            }
            doInterest();
        }

    }

    public static void doInterest() {
        for (Holder holder : B) {
            int result = 0;
            for (int i = holder.l; i <= holder.r; i++) {
                if (A[i - 1] == holder.k) {
                    result++;
                }
            }
            System.out.println(result);
        }

    }

    public static class Holder {
        int l, r, k;
    }

}
