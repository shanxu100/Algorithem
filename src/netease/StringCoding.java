package netease;

import java.util.Scanner;

/**
 * @author Guan
 * @date Created on 2018/8/8
 */
public class StringCoding {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String str = in.nextLine();
            System.out.println(code(str));
        }
    }

    public static String code(String str) {
        int count = 1;
        StringBuilder sb = new StringBuilder();
        char[] chars = str.toCharArray();
        char pre = chars[0];
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == pre) {
                count++;
            } else {
                sb.append(count).append(pre);
                count = 1;
                pre = chars[i];
            }
        }
        sb.append(count).append(pre);
        return sb.toString();

    }
}
