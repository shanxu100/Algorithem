package nowcoder.NetEase2018;

import java.util.Scanner;

/**
 * @author Guan
 * @date Created on 2018/3/20
 */
public class Resort {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t, n;
        int[] A;
        while (in.hasNextInt()) {
            t = in.nextInt();
            for (int i = 0; i < t; i++) {
                n = in.nextInt();
                A = new int[n];
                for (int j = 0; j < n; j++) {
                    A[j] = in.nextInt();
                }
                System.out.println(doResort(A));
            }

        }

    }

    private static String doResort(int[] A) {
        int type0 = 0;
        int type1 = 0;
        int type2 = 0;
        for (int num : A) {
            if (num % 4 == 0) {
                type2++;
            } else if (num % 2 == 0) {
                type1++;
            } else {
                type0++;
            }
        }
        if (type1 >= 1) {
            if (type0 <= type2) {
                return "Yes";
            } else {
                return "No";
            }
        } else {
            if (type0 <= type2 + 1) {
                return "Yes";
            } else {
                return "No";
            }
        }

    }

}
