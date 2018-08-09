package netease;

import java.util.Scanner;

/**
 * @author Guan
 * @date Created on 2018/8/9
 */
public class Clock {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int T = Integer.valueOf(in.nextLine());
            for (int i = 0; i < T; i++) {
                String time = in.nextLine();
                formatTime(time);
            }

        }
    }

    public static void formatTime(String time) {
        StringBuilder sb = new StringBuilder();
        String[] ss = time.split(":");
        char[] chars = time.toCharArray();
        if (Integer.valueOf(ss[0]) > 23) {
            sb.append("0").append(chars[1]);
        } else {
            sb.append(ss[0]);
        }
        sb.append(":");

        if (chars[3] > '5') {
            sb.append("0").append(chars[4]);
        } else {
            sb.append(ss[1]);
        }
        sb.append(":");

        if (chars[6] > '5') {
            sb.append("0").append(chars[7]);
        } else {
            sb.append(ss[2]);
        }
        System.out.println(sb.toString());

    }

}
