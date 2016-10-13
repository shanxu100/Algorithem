package AddBinary;

/**
 * Solved
 *
 * Created by guan on 10/13/16.
 *
 * 模拟二进制大数加法
 */
public class Solution {
    public String addBinary(String a, String b) {

        int len1 = a.length();
        int len2 = b.length();
        int len = len1 > len2 ? len1 : len2;
        int[] result = new int[len + 1];

        StringBuilder sb=new StringBuilder();

        for (char c : a.toCharArray()) {
            result[--len1] = c - '0';
        }
        for (char c : b.toCharArray()) {
            result[--len2] += (c - '0');
        }

        for (int i = 0; i < len ; i++) {
            result[i+1]+=result[i]/2;
            result[i]=result[i]%2;
        }

        for (int i=len;i>=0;i--)
        {
            if (result[i]!=0)
            {
                while (i>=0) {
                    sb.append(result[i]);
                    i--;
                }
                return sb.toString();
            }
        }

        return "0";
    }

    public static void main(String[] args) {

        Solution solution=new Solution();
        System.out.println(solution.addBinary("0","0"));
    }
}
