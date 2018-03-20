package nowcoder.practice;

import java.util.Scanner;

/**
 * @author Guan
 * @date Created on 2018/3/6
 */
public class ReverseStr {
    public static void main(String[] args) {
        String s;
        String[] ss;
        StringBuilder sb = new StringBuilder(105);
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            s = in.nextLine();
            ss = s.split(" ");

            for (int i = ss.length - 1; i >= 0; i--) {
                sb.append(ss[i]).append(" ");
            }
            sb.deleteCharAt(sb.length() - 1);
            System.out.println(sb.toString());

        }
    }
}
