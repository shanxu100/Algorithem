package DP.example;

/**
 * 最长公共子序列
 * 样本题：
 *
 * @author Guan
 * @date Created on 2018/8/17
 */
public class LCS {

    public static void main(String[] args) {


        String A = "1AB2345CD";
        String B = "12345EF";
        System.out.println(new LCS().findLongest(A, A.length(), B, B.length()));
    }

    /**
     * 链接：https://www.nowcoder.com/questionTerminal/c996bbb77dd447d681ec6907ccfb488a
     * 来源：牛客网
     * <p>
     * 思路（参考程序员代码面是指南），DP表，dp[i]][j]代表A[0...i]与B[0...j]的最长公共子序列；
     * 我们先求出第一行与第一列的DP值，然后在求里面的值，里面的值有三种情况：
     * 1.来自dp[i-1][j];
     * 2.来自dp[i][j-1];
     * 3.A[i]==B[j]时为dp[i-1][j-1];
     * 我们求出这三者的最大值即可，用一个res来计算。最后返回即可。
     * <p>
     * 特点：子序列各个元素可以不相邻
     */
    public int findLCS(String A, int n, String B, int m) {
        int[][] dp = new int[n][m];
        char[] charsA = A.toCharArray();
        char[] charsB = B.toCharArray();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (i == 0 && j == 0) {
                    dp[0][0] = charsA[0] == charsB[0] ? 1 : 0;
                } else if (i == 0) {
                    dp[0][j] = charsA[0] == charsB[j] ? 1 : dp[0][j - 1];
                } else if (j == 0) {
                    dp[i][0] = charsA[i] == charsB[0] ? 1 : dp[i - 1][0];
                } else {
                    if (charsA[i] == charsB[j]) {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    } else {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                    }
                }
            }
        }

        return dp[n - 1][m - 1];
    }


    /**
     * 连续的LCS
     *
     * @param A
     * @param n
     * @param B
     * @param m
     * @return
     */
    public int findLongest(String A, int n, String B, int m) {
        // write code here
        int[][] dp = new int[n][m];
        char[] charsA = A.toCharArray();
        char[] charsB = B.toCharArray();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 && j == 0) {
                    dp[0][0] = charsA[0] == charsB[0] ? 1 : 0;
                } else if (i == 0) {
                    dp[0][j] = charsA[0] == charsB[j] ? 1 : 0;
                } else if (j == 0) {
                    dp[i][0] = charsA[i] == charsB[0] ? 1 : 0;
                } else {
                    dp[i][j] = charsA[i] == charsB[j] ? dp[i - 1][j - 1] + 1 : 0;
                }
            }
        }

        //寻找矩阵中的最大值
        int max = -1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                max = Math.max(max, dp[i][j]);
            }
        }
        return max;

    }
}
