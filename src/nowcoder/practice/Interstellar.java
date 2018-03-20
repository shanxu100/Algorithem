package nowcoder.practice;

import java.util.Scanner;

/**
 * AC
 *
 * @author Guan
 * @date Created on 2018/3/5
 */
public class Interstellar {
    public static void main(String[] args) {
        long h;
        Scanner in = new Scanner(System.in);
        while (in.hasNextLong()) {
            h = in.nextLong();
            interstellar(h);
        }
    }

    private static void interstellar(long h) {
        h = (long) (Math.sqrt(4 * h + 1) - 1) / 2;
        System.out.println(h);

    }
}
