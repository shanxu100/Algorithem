package nowcoder.toutiao;

import java.util.*;

/**
 * @author Guan
 * @date Created on 2018/3/24
 */
public class Jump {

    public static int N, K, H;
    public static long[] A;
    public static List<Integer> list;
//    public static TreeSet<Integer> set;

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            N = in.nextInt();
            K = in.nextInt();
            H = in.nextInt();
            A = new long[N];
            list = new LinkedList<Integer>();
            for (int i = 0; i < N; i++) {
//                A[i] = in.nextInt();
                list.add(in.nextInt());
            }
            doJump();
        }
    }


    public static void doJump() {

        Collections.sort(list);
        int maxH=0;
        int currtH=0;
        int index=0;


    }
}
