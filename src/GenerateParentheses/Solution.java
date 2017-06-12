package GenerateParentheses;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

/**
 * 排列组合，前缀
 * <p>
 * Created by guan on 10/9/16.
 * <p>
 * Solved
 */
public class Solution {
    /*
    List<String> ans = new ArrayList<String>();
    String open = "(";
    String closed = ")";

    public List<String> generateParenthesis(int n) {
        //The length of the string will be twice the input size.
        permutations("", 0, 0, 2 * n);
        return ans;
    }

    public void permutations(String st, int x, int y, int n) {
        //x: number of open brackets.
        //y: number of closed brackets.
        if (st.length() == n) {
            ans.add(st);
            return;
        }
        if (x < n / 2) permutations(st + open, x + 1, y, n);
        if (x == n / 2 || x > y) permutations(st + closed, x, y + 1, n);
    }
    */


    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<String>();
        String str = "(";
        trace(n, 1, 0, str, result);

        return result;
    }

    /**
     * 使用第归解决。
     * 同样的方法可以解决：像abcd这样一个序列的全排列问题
     *
     * @param n
     * @param left  左括号的个数
     * @param right 右括号的个数
     * @param str   作为记录当前序列的前缀。
     * @param res
     */
    public void trace(int n, int left, int right, String str, List<String> res) {

        if (left > n || left < right) {
            return;
        }

        if (left == n && right == n) {
            res.add(str);
            return;
        }

        trace(n, left + 1, right, str + "(", res);
        trace(n, left, right + 1, str + ")", res);

    }

    //=====================
    int n;
    List<String> resultList = new ArrayList<>();
    //StringBuilder pre = new StringBuilder("");

    public List<String> generate(int n) {
        this.n = n;

        String pre="";
        trace2(pre + "(", 1, 0);

        return resultList;
    }

    public void trace2(String pre, int left, int right) {

        if (left > n || right > left) {
            return;
        }

        if (left == n && right == n) {
            resultList.add(pre.toString());
            return;
        }

        trace2(pre + "(", left + 1, right);
        trace2(pre + ")", left, right + 1);
    }


    public static void main(String[] args) {

        Solution solution = new Solution();
        List<String> res = solution.generate(3);
        for (String s : res) {
            System.out.println(s);
        }
    }
}
