package DP;

/**
 * @author Guan
 * @date Created on 2018/8/17
 */
public class Palindrome {

    public static void main(String[] args) {
        String A = "acbdcbbbdbdaaccbcacdacdccababcddabddaaaaaaabdbabcdddaacabacbacbbdabdacddbbadaacbbdcbccacacdabcabacacbbbdcccacdcdcdcbcbabdcdacdddbbabcaccddddddabdacaabccdcabcbcbabacaaaccaccaddabbdadcdacdcdbaadbcabdcdcaaacbcadccbbddbaddcaddcaadcbbcbbdcbdadcddabdddcdbddbbdabaaddcaadd";
        System.out.println(new Palindrome().getLongestPalindrome(A, A.length()));
    }

    public int getLongestPalindrome(String A, int n) {
        // write code here
        StringBuilder sb = new StringBuilder(A);
        sb = sb.reverse();

        char[] charsA = A.toCharArray();
        char[] charsB = sb.toString().toCharArray();
        int[][] dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
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
            for (int j = 0; j < n; j++) {
                max = Math.max(max, dp[i][j]);
            }
        }
        return max;
    }
}
