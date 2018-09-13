package baidu;

import java.util.Scanner;

/**
 * @author Guan
 * @date Created on 2018/9/13
 */
public class SqrtSum {

    public static void main(String[] args){

        Scanner in=new Scanner(System.in);
        while (in.hasNext()){
            double n=in.nextInt();
            double m=in.nextInt();
            double result=n;
            for (int i=1;i<m;i++){
                n=Math.sqrt(n);
                result+=n;
            }
            System.out.println(String.format("%.2f",result));
        }
    }
}
