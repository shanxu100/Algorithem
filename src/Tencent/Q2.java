package Tencent;

import java.util.Scanner;

/**
 * @author Guan
 * @date Created on 2018/9/16
 */
public class Q2 {

    public static int N;
    public static String s;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            N = Integer.parseInt(in.nextLine());
            s = in.nextLine();
            s.replace(" ", "");
            String[] ss = s.split("[0]+");
            double result=Math.pow(2,ss.length-1);
            System.out.println(s.length()/2);

        }

    }
}
