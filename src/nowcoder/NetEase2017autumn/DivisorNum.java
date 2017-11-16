package nowcoder.NetEase2017autumn;

import java.util.Scanner;


/**
 * 思路是对的，程序超时
 * tips:
 * 1、一个数 n ，它约数在 1 ~ n/2 之间
 * 2、f(k)=f(2k)
 *
 * @author Guan
 */
public class DivisorNum {
    private static int num, tmp, remainder;
    private static long result;


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            num = in.nextInt();
            result = 0;

            doSum();
        }

    }

    public static void doSum() {
        long start=System.currentTimeMillis();

        //处理奇数
        tmp=num;
        if(num % 2!=0)
        {
            tmp=num+1;
        }
        result=tmp*tmp/2/2;

        //处理偶数
        for (int i = 2; i <= num; i +=2) {
            tmp = i;
            while (tmp % 2 == 0) {
                tmp /= 2;
            }
            result += tmp;
        }
        System.out.println(result);
        long stop=System.currentTimeMillis();
        System.out.println(stop-start+"ms");

    }


    /**
     * 重点——考虑以下几个类似问题：
     * 如何快速的求
     * 1、公约数
     * 2、一个数的约数个数
     * 3、一个数的最大约数
     * 4、判断一个数是否是质数
     *
     * @param x
     * @return
     */
    public static int getMaxOddDivisor(int x) {

        return x;
        //偶数
//        if (fs[x/2]!=0)
//        {
//            return fs[x/2];
//        }

//        //sqrt=(int) Math.sqrt(x);
//        sqrt = x / 2;
//        I = (sqrt % 2 == 0) ? (sqrt - 1) : sqrt;
//        for (; I > 0; I -= 2) {
//            if (x % I == 0) {
//                return I;
//            }
//        }
//        return 1;
    }
}
