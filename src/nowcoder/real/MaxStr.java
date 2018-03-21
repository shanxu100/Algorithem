package nowcoder.real;

import java.util.Scanner;

/**
 * @author Guan
 * @date Created on 2018/3/21
 */
public class MaxStr {
    public static void main(String[] args) {
        int n;
        Scanner in = new Scanner(System.in);

        while (in.hasNextLine()) {
            String str = in.nextLine();
            String result = maxString(str);
            //abcd12345ed125ss123058789
            System.out.println(result + "," + result.length());

        }
    }

    public static boolean isNum(char c) {
        if (c - '0' >= 0 && c - '0' <= 9) {
            return true;
        }
        return false;
    }

    public static String maxString(String str) {
        if (str.equals("")) {
            return str;
        }
        int length = 0;
        int index = 0;
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; ) {
            int temp = 0;
            if (isNum(chars[i])) {
                for (int j = i; j < chars.length; j++) {
                    if (isNum(chars[j])) {
                        temp++;
                        continue;
                    }
                    break;
                }
                //&& temp != 0
                if (temp >= length ) {
                    length = temp;
                    index = i;
                }
                i += temp;
            } else {
                i++;
            }
        }
        if (length > 0) {
            return str.substring(index, index + length);
        }
        return "";
    }

}
