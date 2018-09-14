package baidu;

import java.util.Scanner;

/**
 * @author Guan
 * @date Created on 2018/9/14
 */
public class Q1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int num = in.nextInt();
            double count = 0;

//            int[] arr=new int[num];
            int temp;
            for (int i = 0; i < num; i++) {
                temp = in.nextInt();
                if (temp < 5900) {
                    count++;
                }
            }
            System.out.println(String.format("%.2f", count / num*100)+"%");

        }

    }


}
