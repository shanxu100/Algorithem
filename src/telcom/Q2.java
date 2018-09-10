package telcom;

import java.util.Scanner;

/**
 * @author Guan
 * @date Created on 2018/9/10
 */
public class Q2 {

//    public static String s1, s2;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);


        while (in.hasNext()) {

            String[] tmpS = in.nextLine().split(" ");
//            s1 = tmpS[0];
//            s1 = tmpS[1];
            System.out.println(cmp(tmpS[0],tmpS[1]));

        }


    }

    public static int cmp(String s1, String s2) {
        int min = Math.min(s1.length(), s2.length());
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();

        int max = 0;
        for (int i = 0; i < min; i++) {
            int start1 = s1.length()-1 - i;
            int start2 = 0;
            int count = 0;
            while (start2 <= i) {
                if (chars1[start1] == chars2[start2]) {
                    count++;
                }
                start1++;
                start2++;
                max = count > max ? count : max;
            }
        }
        return max;
    }

}
