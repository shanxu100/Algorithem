package nowcoder.NetEase2017autumn;

import java.util.Scanner;

/**
 *  AC
 * @author Guan
 */
public class GracefulPoint {
    private static int x, y, r_int, total;

    public static void main(String[] args) {
        int rr;
        Scanner in = new Scanner(System.in);

        while (in.hasNextInt()) {
            rr = in.nextInt();
            doPrint(rr);
        }
    }

    private static void doPrint(int rr) {
        x = 0;
        y = 0;
        total = 0;
        r_int = (int) Math.sqrt(rr);

        for (int x = 0; x <= r_int; x++) {
            y = (int) Math.sqrt(rr - x * x);
            if (x * x + y * y == rr) {
                doCount(x,y);
            }
        }
        System.out.println(total);
    }

    private static void doCount(int x, int y) {
        if (x == 0 && y == 0) {
            total++;
        } else if (x == 0 || y == 0) {
            total += 2;
        } else {
            total += 4;
        }
    }
}
