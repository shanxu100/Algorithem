package nowcoder.NetEase2017autumn;

import java.util.Scanner;

/**
 * AC
 * @author Guan
 */
public class Reverse {
    private static int x, y;
    private static int a, b;
    private static StringBuilder sb = new StringBuilder();
    private static int result;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            x = in.nextInt();
            y = in.nextInt();
            doSum(x, y);
        }
    }

    public static void doSum(int x, int y) {
        x = reverse(x + "");
        y = reverse(y + "");
        result = x + y;
        result = reverse(result + "");
        System.out.println(result);

    }

    public static int reverse(String s) {
        sb.setLength(0);
        sb.append(s);
        sb.reverse();
        return Integer.parseInt(sb.toString());
    }
}
