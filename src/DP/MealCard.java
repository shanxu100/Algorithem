package DP;

import java.awt.event.FocusEvent;
import java.util.Scanner;

/**
 * 电子科大本部食堂的饭卡有一种很诡异的设计，即在购买之前判断余额。如果购买一个商品之前，卡上的剩余金额大于或等于5元，就一定可以购买成功（即使购买后卡上余额为负），否则无法购买（即使金额足够）。所以大家都希望尽量使卡上的余额最少。
 * 某天，食堂中有n种菜出售，每种菜可购买一次。已知每种菜的价格以及卡上的余额，问最少可使卡上的余额为多少。
 *
 * @author Guan
 * @date Created on 2018/1/28
 */
public class MealCard {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n, m;
        int[] cost;
        while ((n = in.nextInt()) != 0) {
            cost = new int[n];
            for (int i = 0; i < n; i++) {
                cost[i] = in.nextInt();
            }
            m = in.nextInt();
            System.out.println(F(n, cost, m));
        }
    }

    /**
     * @param n    n种物品
     * @param cost 物品的花费和价值，注意：这里的value和weight相等
     * @param m    对应背包的容量
     * @return
     */
    public static int F(int n, int[] cost, int m) {
        if (m < 5) {
            return m;
        }
        //保留最后的5块钱
        m -= 5;
        int maxValue = -1;
        int maxPostion = 0;
        for (int i = 0; i < n; i++) {
            if (cost[i] > maxValue) {
                maxValue = cost[i];
                maxPostion = i;
            }
        }


        //所获取的价值
        int[] value = new int[m + 1];
        for (int i = 0; i <= m; i++) {
            value[i] = 0;
        }

        for (int i = 0; i < n; i++) {
            if (i == maxPostion) {
                continue;
            }
            for (int j = m; j >= cost[i]; j--) {
                value[j] = (value[j - cost[i]] + cost[i]) > value[j] ?
                        (value[j - cost[i]] + cost[i]) : value[j];
            }
        }
        for (int i = 0; i <= m; i++) {
            System.out.print(value[i] + "\t");
        }
        return m + 5 - value[m] - cost[maxPostion];
    }

}
