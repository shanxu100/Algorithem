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

    public static int eat(int N, int M) {

//        N--;
//        int num1 = 2 << (N - 1);
        double num1 = Math.pow(2, N - 1);

//        int num2 = (2 << N) - 1;
        double num2 = Math.pow(2, N) - 1;

        int result = (int) (M * (num1 / num2));
        return result;
    }
}
