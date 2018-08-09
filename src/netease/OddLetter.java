package netease;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Guan
 * @date Created on 2018/8/9
 */
public class OddLetter {

    public static int[] charWidth = new int[26];
    public static String word;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNext()) {
            for (int i = 0; i < 26; i++) {
                charWidth[i] = in.nextInt();
            }
            in.nextLine();
            word = in.nextLine();
            doJob();
        }


    }

    public static void doJob() {
        char[] chars = word.toCharArray();
        int row = 1;
        int num = 0;
        for (char c : chars) {
            int width = charWidth[c - 'a'];
            if (num + width > 100) {
                row++;
                num = width;
            } else {
                num += width;
            }
        }
        System.out.println(row + " " + num);
    }

}
