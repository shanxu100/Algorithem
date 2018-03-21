package nowcoder.NetEase2018;

import java.util.Scanner;

/**
 * @author Guan
 * @date Created on 2018/3/20
 */
public class OppositInt {

    public static void main(String[] args) {

        Scanner in=new Scanner(System.in);
        int n;
        while (in.hasNextInt())
        {
            n=in.nextInt();

            System.out.println(getOppositInt(n));
        }
    }

    public static int getOppositInt(int n)
    {
        String opposit=new StringBuilder(String.valueOf(n)).reverse().toString();
        int n2=Integer.valueOf(opposit);
        return n+n2;
    }
}
