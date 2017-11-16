package nowcoder.NetEase2017spring;

import java.util.Scanner;

/**
 * 超时
 */
public class MagicRing {

    private static int n;
    private static int k;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            n = in.nextInt();
            k = in.nextInt();
            int[] datas = new int[n];
            for (int i = 0; i < n; i++) {
                datas[i] = in.nextInt();
            }
            doUse(datas);
        }
    }

    private static int firstInt;

    public static void doUse(int[] datas) {

        for (int i = 0; i < k; i++) {
            firstInt = datas[0];
            for (int j = 0; j < n - 1; j++) {
                datas[j] += datas[j + 1];
                datas[j] %= 100;
            }
            datas[n - 1] += firstInt;
            datas[n - 1] %= 100;

        }
        sb.setLength(0);
        for (int i = 0; i < n; i++) {
            sb.append(datas[i]).append(" ");
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb.toString());
    }
}
