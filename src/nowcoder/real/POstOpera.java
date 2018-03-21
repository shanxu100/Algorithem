package nowcoder.real;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Stack;

/**
 * @author Guan
 * @date Created on 2018/3/21
 */
public class POstOpera {
    private static HashSet<String> set = new HashSet<>();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = 0;
        String str;
        String[] ss;
        set.add("+");
        set.add("-");
        set.add("*");
        set.add("/");
        set.add("(");

        while (in.hasNextLine()) {
            String tmp = in.nextLine();
            str = in.nextLine();
            ss = str.split(" ");
            doPostOpera(ss, n);
        }
    }

    private static void doPostOpera(String[] ss, int n) {
        Stack<String> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for (String s : ss) {
            if (set.contains(s)) {
                if (s.equals("(") || stack.isEmpty()) {
                    stack.push(s);
                } else {
                    String top = stack.peek();
                    while (compareOperation(top, s)) {
                        //出栈
                        sb.append(stack.pop());
                        if (stack.isEmpty()) {
//                            stack.push(s);
                            break;

                        } else {
                            top = stack.peek();
                        }
                    }
                    stack.push(s);
                }
                continue;
            }
            if (s.equals(")")) {
                while (!stack.peek().equals("(")) {
                    sb.append(stack.pop());
                }
                stack.pop();
                continue;
            }
            sb.append(s);

        }
        while (!stack.empty()) {
            sb.append(stack.pop());
        }
        System.out.println(sb.toString());


    }

    /**
     * a >= b ?
     *
     * @param a
     * @param b
     * @return
     */
    private static boolean compareOperation(String a, String b) {
        if (a.equals("*") || a.equals("/")) {
            return true;
        }
        if (b.equals("*") || b.equals("/")) {
            return false;
        }
        return true;
    }
}
