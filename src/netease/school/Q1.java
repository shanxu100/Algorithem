package netease.school;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author Guan
 * @date Created on 2018/9/8
 */
public class Q1 {

    private static int[] a=new int[3];
    int[][] b=new int[1000000000][1000000000];

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            a[0] = in.nextInt();
            a[1] = in.nextInt();
            a[2] = in.nextInt();
            f();

        }


    }

    public static void f() {
        Arrays.sort(a);
        int result=0;
        result+=Math.abs(a[0]-a[1]);
        result+=Math.abs(a[1]-a[2]);
        System.out.println(result);

    }


}
