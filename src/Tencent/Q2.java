package Tencent;

import java.util.Scanner;

/**
 * @author Guan
 * @date Created on 2018/9/16
 */
public class Q2 {

    public static int N;
    public static int[] arr;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            N = in.nextInt();
            arr=new int[N];
            for (int i=0;i<N;i++){
                arr[i]=in.nextInt();
            }
            System.out.println(N/2+"");

        }

    }
}
