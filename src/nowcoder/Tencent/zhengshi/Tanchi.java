package nowcoder.Tencent.zhengshi;

import java.util.Scanner;

/**
 * @author Guan
 * @date Created on 2018/4/5
 */
public class Tanchi {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);


        int N, M;
        while (in.hasNextInt()) {

            N = in.nextInt();
            M = in.nextInt();

            System.out.println(eat(N, M));


        }

    }

    public static long eat(int N, int M) {

//        N--;
        long num1 = 1 << (N - 1);
//        double num1 = Math.pow(2, N - 1);

        long num2 = (1 << N) - 1;
//        double num2 = Math.pow(2, N) - 1;

        long result = (long) (M * num1 / num2);
        return result;
    }
}
