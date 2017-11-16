package nowcoder.NetEase2017spring;

import java.util.Scanner;

public class OddE {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String s = in.next();
            doCompute(s);
        }
    }

    public static void doCompute(String s) {
        char[] chars = s.toCharArray();
        int result = chars[0] - '0';

        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == '+') {
                i++;
                result += (chars[i]-'0');
            }
            if (chars[i] == '-') {
                i++;
                result -= (chars[i]-'0');
            }
            if (chars[i] == '*') {
                i++;
                result *= (chars[i]-'0');
            }
        }
        System.out.println(result);
    }
}
