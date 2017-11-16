package nowcoder.Tencent;

import java.util.Scanner;

public class MoveChart {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            //注意while处理多个case             
            String str = in.next();
            moveChart(str);
        }
    }

    public static void moveChart(String str) {
        char[] chars = str.toCharArray();
        StringBuilder lowercase = new StringBuilder();
        StringBuilder uppercase = new StringBuilder();

        for (char c : chars) {
            if ((c >= 'a') && (c <= 'z')) {
                lowercase.append(c);
            } else {
                uppercase.append(c);
            }
        }
        lowercase.append(uppercase);
        System.out.println(lowercase.toString());
    }


}
