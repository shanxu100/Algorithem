package DP;

import java.math.BigInteger;

/**
 * 有一楼梯共m级，刚开始时你在第一级，若每次只能跨上一级或者二级，要走上m级，共有多少走法？注：规定从一级到一级有0种走法。
 * <p>
 * 给定一个正整数int n，请返回一个数，代表上楼的方式数。保证n小于等于100。为了防止溢出，请返回结果Mod 1000000007的值。
 *
 * @author Guan
 * @date Created on 2018/1/28
 */
public class GoUpstairs {
    public int countWays(int n) {
        // write code here
        if (n == 0) {
            return 0;
        }
        BigInteger[] dp = new BigInteger[n];

        //只跨一级
        for (int i = 0; i < n; i++) {
            dp[i] = BigInteger.valueOf(1);
        }

        //一次可以跨1、2级
        for (int i = 2; i < n; i++) {
            dp[i] = dp[i - 2].add(dp[i - 1]);
        }
        return (int) (dp[n - 1].mod(BigInteger.valueOf(1000000007)).intValue());

    }

    public static void main(String[] args) {
        int result = new GoUpstairs().countWays(96);
        System.out.println(result);
    }
}
