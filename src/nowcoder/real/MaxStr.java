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
            MaxString(str);

        }
    }

    public static boolean isNum(char c) {
        if (c - '0' >= 0 && c - '0' <= 9) {
            return true;
        }
        return false;
    }

    public static String MaxString(String str) {
        if (str == "") {
            return str;
        }
        int len = 0, index = 0;
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; ) {
            int temp = 0;
            if (isNum(chars[i])) {
                for (int j = i; j < chars.length; j++) {
                    if (isNum(chars[j])) {
                        temp++;
                    } else {
                        break;
                    }
                }
                if (temp >= len && temp != 0) {
                    len = temp;
                    index = i;
                }
                i = i + temp;
            } else {
                i++;
            }
        }
        String result = "";
        if (len > 0)
        {
            result = str.substring(index, len);
        }
        return result;
    }
}
