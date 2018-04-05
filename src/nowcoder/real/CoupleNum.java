package nowcoder.real;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Guan
 * @date Created on 2018/3/27
 */
public class CoupleNum {
    public static int n;
    public static int k;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            n = in.nextInt();
            k = in.nextInt();
            System.out.println(doNum());
        }
    }

    public static int doNum() {
        int result = 0;
        result += countXY();
        for (int i = k + 1; i <= n/2; i++) {
            result += countXY2(i, getYushuList(k, i));
        }
        return result;
    }

    /**
     * 计算 k<=x<y<=n 的（x，y）对的数量
     *
     * @return
     */
    public static int countXY() {
        int result = 0;

        for (int i = k + 1; i <= n; i++) {
            result += (i - k);
        }
        return result;
    }

    /**
     * 指定y，和余数c的集合
     * 求x
     * x= y* d+ c
     *
     * @return
     */
    public static int countXY2(int y, List<Integer> list) {

        int result = 0;
        for (int i = 0; i < list.size(); i++) {
            int d = 1;
            int x = 0;
            int c = list.get(i);
            while ((x = y * d + c) <= n) {
                result++;
                d++;
            }
        }
        return result;
    }

    /**
     * 获取余数的list
     * k <= c < y
     *
     * @param k
     * @param y
     * @return
     */
    public static List<Integer> getYushuList(int k, int y) {
        List<Integer> list = new ArrayList<>(y - k + 1);
        for (int i = k; i < y; i++) {
            list.add(i);
        }
        return list;
    }

}
