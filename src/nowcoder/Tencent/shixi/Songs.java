package nowcoder.Tencent.shixi;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Guan
 * @date Created on 2018/4/5
 */
public class Songs {
    public static int K, A, countA, B, countB;
    public static long totle;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);


        while (in.hasNextInt()) {
            K = in.nextInt();
            A = in.nextInt();
            countA = in.nextInt();
            B = in.nextInt();
            countB = in.nextInt();
            totle = 0;
            singSongs(0, 0, 0);

            System.out.println(totle % 1000000007);


        }

    }


    /**
     * wrong
     * @param currentValue
     * @param count1
     * @param count2
     */
    public static void singSongs(int currentValue, int count1, int count2) {
        if (count1 >= countA || count2 >= countB || currentValue > K) {
            return;
        }

        if (currentValue == K) {
            totle++;
            return;
        }

        for (int i = count1; i < countA; i++) {
            singSongs(currentValue + A, i + 1, count2);

        }

        for (int i = count2; i < countB; i++) {
            singSongs(currentValue + B, count1, i + 1);
        }

    }

}
