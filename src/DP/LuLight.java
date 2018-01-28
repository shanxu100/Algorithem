package DP;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 题目描述
 * 一条长l的笔直的街道上有n个路灯，若这条街的起点为0，终点为l，第i个路灯坐标为ai ，每盏灯可以覆盖到的最远距离为d，为了照明需求，所有灯的灯光必须覆盖整条街，但是为了省电，要是这个d最小，请找到这个最小的d。
 * 输入描述:
 * 每组数据第一行两个整数n和l（n大于0小于等于1000，l小于等于1000000000大于0）。第二行有n个整数(均大于等于0小于等于l)，为每盏灯的坐标，多个路灯可以在同一点。
 * 输出描述:
 * 输出答案，保留两位小数。
 * https://www.nowcoder.com/practice/62cdf520b9d94616b6644ac03a0306ff?tpId=49&&tqId=29309&rp=3&ru=/activity/oj&qru=/ta/2016test/question-ranking
 *
 * @author Guan
 * @date Created on 2018/1/27
 */
public class LuLight {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        DecimalFormat decimalFormat = new DecimalFormat(".00");
        int n, l;
        int a[];
        while (in.hasNext()) {
            n = in.nextInt();
            l = in.nextInt();
            a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = in.nextInt();
            }
            System.out.println(decimalFormat.format(maxD(n, l, a)));
        }

    }

    public static float maxD(int n, int l, int[] a) {
        if (n == 1) {
            return l / 2.0f;
        }
        float tmp = 0;
        Arrays.sort(a);
        for (int i = 1; i < n; i++) {
            tmp = a[i] - a[i - 1] > tmp ? a[i] - a[i - 1] : tmp;
        }
        tmp = tmp / 2.0f;
        tmp = a[0] > tmp ? a[0] : tmp;
        tmp = (l - a[n - 1]) > tmp ? (l - a[n - 1]) : tmp;
        return tmp;
    }


}
