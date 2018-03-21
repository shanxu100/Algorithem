package nowcoder.test;

import java.util.Scanner;

/**
 * @author Guan
 * @date Created on 2018/3/21
 */
public class Sum {

    public static void main(String[] args) {
        int a, b;
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            a = in.nextInt();
            b = in.nextInt();
            System.out.println(a + b);
        }
    }

}
