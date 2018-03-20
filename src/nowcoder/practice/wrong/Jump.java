package nowcoder.practice.wrong;

import java.text.ParseException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * 小易来到了一条石板路前，每块石板上从1挨着编号为：1、2、3.......
 * 这条石板路要根据特殊的规则才能前进：对于小易当前所在的编号为K的 石板，小易单次只能往前跳K的一个约数(不含1和K)步，即跳到K+X(X为K的一个非1和本身的约数)的位置。 小易当前处在编号为N的石板，他想跳到编号恰好为M的石板去，小易想知道最少需要跳跃几次可以到达。
 * 例如：
 * N = 4，M = 24：
 * 4->6->8->12->18->24
 * 于是小易最少需要跳跃5次，就可以从4号石板跳到24号石板
 * <p>
 * 运行超时:您的程序未能在规定时间内运行结束，请检查是否循环有错或算法复杂度过大。
 * case通过率为70.00%
 *
 * @author Guan
 * @date Created on 2018/3/5
 */
public class Jump {

    public static void main(String[] args) {
        int N, M;
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            N = in.nextInt();
            M = in.nextInt();
            jump(N, M);
        }
    }

    public static void jump(int N, int M) {
        int[] arr = new int[M + 1];
        for (int i = 0; i <= M; i++) {
            arr[i] = Integer.MAX_VALUE;
        }

        arr[N] = 0;

        for (int i = N; i < M; i++) {
            if (arr[i] == Integer.MAX_VALUE) {
                continue;
            }
            List<Integer> Divisors = computDivisor(i);
            for (int d : Divisors) {
                if (i + d > M) {
                    break;
                }
                arr[i + d] = (arr[i] + 1 < arr[i + d] ? arr[i] + 1 : arr[i + d]);
            }
        }

        if (arr[M] == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(arr[M]);
        }


    }

    public static List<Integer> computDivisor(int D) {
        List<Integer> list = new LinkedList<>();
        int dd = D / 2;
        for (int i = 2; i <= dd; i++) {
            if (D % i == 0) {
                list.add(i);
            }
        }
        return list;
    }
}
