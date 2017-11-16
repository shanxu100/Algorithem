package nowcoder.NetEase2017autumn;

import java.util.Scanner;

/**
 * AC
 * @author Guan
 */
public class BuyApples {

    private static int num, result, tmp;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {

            num = in.nextInt();
            result = 0;
            doBuy();
        }

    }

    public static void doBuy() {
        if (num % 2 != 0 || num < 6) {
            System.out.println(-1);
            return;
        }
        num /= 2;

        tmp = num % 4;
        result = num / 4;
        if (tmp == 0) {
            System.out.println(result);
        } else if (tmp == 1 && result >= 2) {
            result = result - 2 + 3;
            System.out.println(result);
        } else if (tmp == 2 && result >= 1) {
            result = result - 1 + 2;
            System.out.println(result);
        } else if (tmp == 3) {
            result++;
            System.out.println(result);
        } else {
            System.out.println(-1);
        }
    }
}
