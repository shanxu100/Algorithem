package nowcoder.NetEase2017autumn;

import java.util.Scanner;

/**
 * AC
 * @author Guan
 */
public class CountCandy {
    public static int a, b, c, d;
    public static int A, B, C;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            a = in.nextInt();
            b = in.nextInt();
            c = in.nextInt();
            d = in.nextInt();
            doCount();
        }
    }

    public static void doCount() {
        A = (a + b + d + a) / 2;
        B = A - a;
        C = B - b;
        if (A < 0 || B < 0 || C < 0
                || A - B != a || B - C != b || A + B != c || B + C != d) {
            System.out.println("No");
            return;
        }
        System.out.println(A + " " + B + " " + C);
    }
}
