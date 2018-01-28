package DP;

import java.util.Arrays;

/**
 * 对于找零问题有两个版本，一个是求找零后零钱的数量最少；另一个就是本题，求找零的方案数。
 * <p>
 * 有一个数组changes，changes中所有的值都为正数且不重复。每个值代表一种面值的货币，每种面值的货币可以使用任意张，
 * 对于一个给定值x，请设计一个高效算法，计算组成这个值的方案数。
 * 给定一个int数组changes，代表所以零钱，同时给定它的大小n，另外给定一个正整数x，
 * 请返回组成x的方案数，保证n小于等于100且x小于等于10000。
 *
 * @author Guan
 * @date Created on 2018/1/27
 */
public class Exchange {
    public int countWays(int[] changes, int n, int x) {
        // write code here
        int[] dp = new int[x + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = 0;
        }
        dp[0] = 1;
        for (int i = 0; i < n; i++) {
            //change[i]
            for (int j = changes[i]; j <= x; j++) {
                /**
                 * 关键
                 */
                dp[j] = dp[j - changes[i]] + dp[j];
            }
//            for (int t = 0; t < dp.length; t++) {
//                System.out.print(dp[t] + "\t");
//            }
//            System.out.println();

        }
        return dp[x];

    }

    public static void main(String[] args) {
        int[] changes = new int[]{5, 10, 25, 1};
        int n = changes.length;
        int x = 15;
        int result = new Exchange().countWays(changes, n, x);
        System.out.println(result);
    }
}
