package nowcoder.practice.mark;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * https://www.nowcoder.com/practice/635ff765d4af45b5bf8e3756ed415792?tpId=85&tqId=29879&tPage=1&rp=1&ru=/ta/2017test&qru=/ta/2017test/question-ranking
 * 没有保证字典序
 *
 * @author Guan
 * @date Created on 2018/3/6
 */
public class Sum {
    public static int m;

    public static void main(String[] args) {
        int n;
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            n = in.nextInt();
            m = in.nextInt();
            sum(n);
        }
    }

    public static void sum(int n) {
        List<Integer> list = new ArrayList<>(n);

        helper(1, 0, list, n);
    }

    public static void helper(int currValue, int currSum, List<Integer> list, int n) {
        if (currValue > n) {
//            output(list);
            return;
        }

        for (int i = currValue; i <= n; i++) {
            currSum += i;
            if (currSum > m) {
                break;
            }
            list.add(i);
            if (currSum == m) {
                output(list);
            } else {
                helper(i + 1, currSum, list, n);
            }

            list.remove(list.size() - 1);
            currSum -= i;
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
