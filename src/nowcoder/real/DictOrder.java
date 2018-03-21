package nowcoder.real;

import java.util.Scanner;

/**
 * @author Guan
 * @date Created on 2018/3/21
 */
public class DictOrder {
    public static void main(String[] args) {
        int n;
        Scanner in = new Scanner(System.in);

        while (in.hasNextLine()) {
            n = Integer.valueOf(in.nextLine());
            String str;
            for (int i = 0; i < n; i++) {
                str = in.nextLine();
                doDictOrder(str);
            }
        }
    }

    public static void doDictOrder(String str) {
        int result = 0;
        char[] ss = str.toCharArray();
        for (int i = 1; i < ss.length; i++) {
            result = result + pOfN(i, 26);
            result += numOfP(ss.length - i, ss[i - 1] - 'a' + 1, ss[i]);
        }
        result += numOfP(ss.length, 0, ss[0]);
        result++;
        System.out.println(result);
    }


    public static int jiecheng(int n) {
        if (n == 0) {
            return 1;
        }
        int mysum = 1;
        for (int i = 1; i <= n; i++) {
            mysum = mysum * i;
        }
        return mysum;
    }

    public static int pOfN(int p, int n) {
        int mysum = 1;
        for (int i = n - p; i < n; i++) {
            mysum *= (i + 1);
        }
        int result= mysum / jiecheng(p);
        return result;
    }

    public static int numOfP(int p, int n, char a) {
        int mysum = 0;
        for (int k = n + 1; k < (a - 'a' + 1); k++) {
            mysum += pOfN(p - 1, (26 - k));
        }
        return mysum;
    }
}
