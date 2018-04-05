package nowcoder.Tencent.zhengshi;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * @author Guan
 * @date Created on 2018/4/5
 */
public class zhipai {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);


        int n;
        Integer[] a;
        while (in.hasNextInt()) {

            n = in.nextInt();
            a = new Integer[n];
            for (int i = 0; i < n; i++) {
                a[i] = in.nextInt();
            }

            System.out.println(score(n, a));

        }

    }

    public static int score(int n, Integer[] a) {
        Arrays.sort(a, Collections.reverseOrder());
        int result = 0;
        int tmp;
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                tmp = 1;
            } else {
                tmp = -1;
            }
            result += (a[i] * tmp);
        }
        return result;

    }
}
