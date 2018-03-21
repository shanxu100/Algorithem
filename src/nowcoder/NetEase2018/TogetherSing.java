package nowcoder.NetEase2018;

import java.util.*;

/**
 * @author Guan
 * @date Created on 2018/3/20
 */
public class TogetherSing {

    public static void main(String[] args) {
        int n;
        int[] v;
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            n = in.nextInt();
            v = new int[n];
            for (int i = 0; i < n; i++) {
                v[i] = in.nextInt();
            }
            System.out.println(doSing(v));
        }

    }

    public static int doSing(int[] v) {

        return 0;
    }

    public static int getAbsOfList(List<Integer> list) {
        if (list.size() == 1) {
            return 0;
        }
        int result = 0;
        for (int i = 1; i < list.size(); i++) {
            result += Math.abs(list.get(i) - list.get(i - 1));
        }
        return result;
    }


}
