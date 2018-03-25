package nowcoder.toutiao;

import java.util.List;
import java.util.Scanner;

/**
 * @author Guan
 * @date Created on 2018/3/24
 */
public class AllotRoom {

    public static void main(String[] args) {
        int n, x;
        long[] R;
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            n = in.nextInt();
            x = in.nextInt();
            R = new long[n];
            for (int i = 0; i < n; i++) {
                R[i] = in.nextInt();
//                R[i] = 0;

            }
            doAllotRoom2(n, x, R);
            output(R);
        }

    }

    public static void doAllotRoom(int n, int x, long[] R) {
        int index = x - 1;
        int count = 0;
        while (R[index] != 0) {
            R[index]--;
            count++;
            index = index == 0 ? R.length - 1 : index - 1;
        }
        R[index] = count;

    }

    public static void doAllotRoom2(int n, int x, long[] R) {
        int index = x - 1;
        int count = 0;

        int minIndex = findMinValue_Index(R);
        long tmp = R[minIndex];

        for (int i = 0; i < R.length; i++) {
            R[i] -= tmp;
        }

        while (R[index] != 0) {
            R[index]--;
            count++;
            index = index == 0 ? R.length - 1 : index - 1;
        }

        R[index] = count + tmp * R.length;

    }

    public static int findMinValue_Index(long[] R) {
        long minValue = Integer.MAX_VALUE;
        int index = 0;
        for (int i = 0; i < R.length; i++) {
            if (R[i] <= minValue) {
                index = i;
                minValue = R[i];
            }
        }
        return index;
    }

    public static void output(long[] data) {
        int length = data.length;
        StringBuilder sb = new StringBuilder(length * 2);
        for (int i = 0; i < length; i++) {
            sb.append(data[i]).append(" ");
        }
        System.out.println(sb.deleteCharAt(sb.length() - 1).toString());
    }
}
