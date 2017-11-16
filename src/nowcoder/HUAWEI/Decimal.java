package nowcoder.HUAWEI;

import com.sun.deploy.util.StringUtils;

import java.util.HashMap;
import java.util.Scanner;

public class Decimal {

    public static void main(String[] args) {
        int result = 0;
        int value = 0;
        String input;
        char[] chars;
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            input = in.next();
            chars = input.toCharArray();
            int lastIndex = chars.length - 1;
            for (int index = lastIndex; index >= 2; index--) {
                value = chars[index] > '9' ? chars[index] - 55 : chars[index] - 48;
                result += value * Math.pow(16, (lastIndex - index));
            }
            System.out.println(result);
            result=0;
        }

    }
}
