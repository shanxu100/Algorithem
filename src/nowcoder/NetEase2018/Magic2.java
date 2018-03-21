package nowcoder.NetEase2018;

import java.util.Scanner;

/**
 * @author Guan
 * @date Created on 2018/3/20
 */
public class Magic2 {

    public static void main(String[] args)
    {
        Scanner in=new Scanner(System.in);
        int n;
        while (in.hasNextInt())
        {
            n=in.nextInt();
            System.out.println(getMagicCoin(n));
        }
    }

    public static String getMagicCoin(int n){
        StringBuilder sb=new StringBuilder();
        while (n>0)
        {
            if (n %2==0)
            {
                //偶数
                sb.insert(0,"2");
                n=(n-2)/2;
            }else {
                //奇数
                sb.insert(0,"1");
                n=(n-1)/2;
            }
        }
        return sb.toString();
    }
}
