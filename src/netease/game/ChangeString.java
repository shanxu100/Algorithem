package netease.game;

import java.util.Scanner;

/**
 * @author Guan
 * @date Created on 2018/9/15
 */
public class ChangeString {

    public static int[][] steps;

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String str1 = in.nextLine();
            String str2 = in.nextLine();

            System.out.println(changeStr(str1, str2));

        }

    }

    public static int changeStr(String str1, String str2) {
        if (str1.length() == 0) {
            return str2.length();
        }
        if (str2.length() == 0) {
            return str1.length();
        }
        int length1 = str1.length();
        int length2 = str2.length();
        steps = new int[length1 + 1][length2 + 1];
        for (int i = 0; i <= length1; i++) {
            for (int j = 0; j <= length2; j++) {

                if (i == 0) {
                    steps[i][j] = j;
                } else if (j == 0) {
                    steps[i][j] = i;
                } else if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    steps[i][j] = steps[i - 1][j - 1];
                } else {
                    steps[i][j] = Math.min(steps[i][j - 1] + 1, steps[i - 1][j] + 1);
                }

            }
        }
        return steps[length1][length2];


    }
}
