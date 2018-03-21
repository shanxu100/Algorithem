package nowcoder.practice.mark;

import java.util.*;

/**
 * @author Guan
 * @date Created on 2018/3/21
 */
public class Sum2 {
    public static int m,n;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            n = in.nextInt();
            m = in.nextInt();
            sum();
        }
    }

    public static void sum() {
        int[] A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i]=i+1;
        }

        helper(0, A, 0, new ArrayList<>(n));

    }


    public static void helper(int currValue, int[] A, int index, List<Integer> intSet) {
        if (currValue > m) {
            return;
        }
        if (currValue == m) {
//            System.out.println(intSet);
            output(intSet);
            return;
        }
        for (int i = index; i < n; i++) {
            int tmp = A[i];
            currValue += tmp;
            intSet.add(tmp);
            helper(currValue, A, i + 1, intSet);
            currValue -= tmp;
            intSet.remove(intSet.size() - 1);
        }
    }


    public static void output(List<Integer> list) {
        StringBuilder sb = new StringBuilder();
        for (int i : list) {
            sb.append(i).append(" ");
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb.toString());
    }

}
