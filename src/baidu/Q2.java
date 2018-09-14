package baidu;

import java.util.Scanner;

/**
 * @author Guan
 * @date Created on 2018/9/14
 */
public class Q2 {

    public static int n, m;
    public static int[] arr;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {

            n = in.nextInt();
            arr = new int[n + 1];
            arr[0] = -1;
            for (int i = 1; i < n + 1; i++) {
                arr[i] = in.nextInt();
            }
            m = in.nextInt();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < m; i++) {
                int x = in.nextInt();
                int k = in.nextInt();
                sb.append(getF(x, k)).append(" ");
            }
            sb.setLength(sb.length() - 1);
            System.out.println(sb.toString());
        }

    }

    public static int getF(int x, int k) {
        if (k <= 0) {
            return 0;
        }
        int result = 0;
        int tempK = k;
        int tempX=x;
        while (tempK > 0) {
            tempX = arr[tempX];
            if (tempX == 0) {
                return 0;
            }
            tempK--;
        }

        for (int i = 1; i <= n; i++) {
            if (i==x){
                continue;
            }
            tempK = k;
            int tmpI = i;
            while (tempK > 0 && tmpI != 0) {
                tmpI = arr[tmpI];
                tempK--;
            }
            if (tmpI == tempX) {
                result++;
            }
        }
        return result;

    }

}
