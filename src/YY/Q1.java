package YY;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Guan
 * @date Created on 2018/9/14
 */
public class Q1 {

    static int max_cnt = 0;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println(test("abcabdfbdfacabc"));

//        while (in.hasNext()) {
//
//        }


    }


    static int fun(String str) {
        List<String> subs = new LinkedList<>();
        int len = str.length();
        for (int i = 0; i < len; i++) {
            subs.add(str.substring(i));
        }

        int count = 1;
        int maxCount = 1;
        String sub;

        for (int i = 0; i < len; i++) {

            for (int j = i + 1; j < len; j++) {
                count = 1;
                if (subs.get(i).substring(0, j - i).equals(subs.get(j).substring(0, j - i))) {
                    ++count;
                    //j-i为子串长度
                    for (int k = j + j - i; k < len; k += j - i) {
                        if (subs.get(i).substring(0, j - i).equals(subs.get(k).substring(0, j - i))) {
                            ++count;
                        } else {
                            break;
                        }
                    }
                    if (count > maxCount) {
                        maxCount = count;
                        sub = subs.get(i).substring(0, j - i);
                    }
                }
            }


        }
        return maxCount;


    }


    public static int test(String str) {
        int len = str.length();

        int array[][] = new int[len + 1][len + 1];
        for (int m = 0; m < len; m++) {

            for (int n = 0; n < len; n++) {
                if (str.charAt(m) == str.charAt(n))
                    array[m + 1][n + 1] = array[m][n] + 1;

            }

        }

        int max = 0;
        for (int m = 0; m < len + 1; m++) {

            for (int n = 0; n < len + 1; n++) {
                if ((m != n) && (array[m][n] > max))
                    max = array[m][n];

            }

        }
        return max;
    }
}
