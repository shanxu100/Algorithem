package baidu;

import java.util.Scanner;

/**
 * @author Guan
 * @date Created on 2018/9/13
 */
public class NarcissisticNumber {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int m = in.nextInt();
            int n = in.nextInt();
            StringBuilder sb = new StringBuilder();
            for (int i = m; i <= n; i++) {
                int result;
                if ((result = isNarcissisticNumber(i)) != -1) {
                    sb.append(result).append(" ");
                }
            }
            if (sb.length()==0){
                sb.append("no");
            }else {
                sb.deleteCharAt(sb.length() - 1);
            }
            System.out.println(sb.toString());
        }
    }

    public static int isNarcissisticNumber(int num) {
        int a, b, c, tmp;
        tmp = num;
        c = tmp % 10;
        tmp = tmp / 10;
        b = tmp % 10;
        tmp = tmp / 10;
        a = tmp % 10;
        int result = a * a * a + b * b * b + c * c * c;
        result = result != num ? -1 : result;
        return result;
    }
}
