package SimplifyPath;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Not Solved
 *
 * Created by guan on 10/12/16.
 */
public class Solution {
    public String simplifyPath(String path) {

        String[] pathes = path.split("/");
        Stack<String> stack = new Stack<>();

        StringBuilder sb = new StringBuilder();
        int p = -1;

        for (int i = 1; i < pathes.length; i++) {

            if (pathes[i].equals("."))
            {
                continue;
            }
            if (pathes[i].equals("..")) {

                if (stack.size() > 0) {
                    stack.pop();
                }
                continue;
            }

            stack.push(pathes[i]);


        }


        for (int i = 0; i < stack.size(); i++) {
            sb.insert(0, stack.pop());
        }

        return sb.insert(0, "/").toString();

    }

    public static void main(String[] args) {

        Solution solution = new Solution();
        System.out.print(solution.simplifyPath("/a/./b/../../c/"));
    }
}
