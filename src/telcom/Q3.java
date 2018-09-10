package telcom;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Guan
 * @date Created on 2018/9/10
 */
public class Q3 {

    public static Map<Integer, Boolean> map = new HashMap<>(5000);

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);


        while (in.hasNext()) {

            int N = in.nextInt();
            System.out.println(f(N));
        }


    }

    public static int f(int N) {

        int[] a = new int[N];
        a[0] = 1;
        int t2 = 0;
        int t3 = 0;
        int t5 = 0;
        for (int i = 1; i < N; i++) {
            int min = getMin(a[t2] * 2, a[t3] * 3, a[t5] * 5);
            a[i] = min;
            while (a[t2] * 2 == a[i])
            {
                t2++;
            }
            while (a[t3] * 3 == a[i])
            {
                t3++;
            }
            while (a[t5] * 5 == a[i])
            {
                t5++;
            }
        }
        return a[N - 1];

    }

    public static int getMin(int n1, int n2, int n3) {
        int min = (n1 < n2) ? n1 : n2;
        return min < n3 ? min : n3;
    }


}
