package nowcoder.practice.wrong;

import java.util.*;

/**
 * Wrong
 * 一个袋子里面有n个球，每个球上面都有一个号码(拥有相同号码的球是无区别的)。如果一个袋子是幸运的当且仅当所有球的号码的和大于
 * 所有球的号码的积。
 * 例如：如果袋子里面的球的号码是{1, 1, 2, 3}，这个袋子就是幸运的，因为1 + 1 + 2 + 3 > 1 * 1 * 2 * 3
 * 你可以适当从袋子里移除一些球(可以移除0个,但是别移除完)，要使移除后的袋子是幸运的。现在让你编程计算一下你可以获得
 * 的多少种不同的幸运的袋子。
 *
 * @author Guan
 * @date Created on 2018/3/6
 */
public class LuckBag {
    public static int count;

    public static void main(String[] args) {
        int n;
        int[] x = new int[1001];
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            n = in.nextInt();
            for (int i = 0; i < n; i++) {
                x[i] = in.nextInt();
            }
            lucky(n, x);
        }
    }

    public static void lucky(int n, int[] x) {
        List<Integer> list = new ArrayList<>(n);

        count = 0;
        helper(0, n, x, list);
        System.out.println(count);

    }

    public static void helper(int index, int n, int[] x, List<Integer> list) {
        if (index >= n) {
            System.out.println(list.toString());
            verify(list);
            return;
        }
        for (int i = index; i < n; i++) {
            list.add(x[i]);
            helper(i + 1, n, x, list);
            list.remove(list.size() - 1);
        }
    }

    public static boolean verify(List<Integer> list) {
        int sum = 0;
        int product = 0;
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            int tmp = it.next();
            sum += tmp;
            product *= tmp;
        }
        if (sum > product) {
            count++;
            return true;
        } else {
            return false;
        }
    }


}
