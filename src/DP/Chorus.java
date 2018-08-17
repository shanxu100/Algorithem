package DP;

import java.util.Scanner;

/**
 * 合唱团
 * https://www.nowcoder.com/practice/661c49118ca241909add3a11c96408c8?tpId=85&&tqId=29830&rp=1&ru=/activity/oj&qru=/ta/2017test/question-ranking
 * @author Guan
 * @date Created on 2018/8/13
 */
public class Chorus {

    public static int n;
    public static int[] data;
    public static int k, d;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            n = in.nextInt();
            data = new int[n];
            for (int i = 0; i < n; i++) {
                data[i] = in.nextInt();
            }
            k = in.nextInt();
            d = in.nextInt();
            doJob();
        }


    }

    public static void doJob() {
        Node[] ns = new Node[k + 1];

        ns[0] = new Node(1, -1);
        for (int i = 1; i <= k; i++) {
            ns[i] = new Node(data[0], 0);
        }

        for (int i = 1; i < n; i++) {

            for (int j = k; j > 0; j--) {
                if (canDo(ns[j - 1].index, i)) {
                    int temp = ns[j - 1].value * data[i];
                    ns[j].value = temp > ns[j].value ? temp : ns[j].value;
                }
            }
        }


        int max = Integer.MIN_VALUE;
        for (Node node : ns) {
            max = node.value > max ? node.value : max;
        }
        System.out.println(max);

    }

    public static boolean canDo(int indexI, int indexJ) {
        if (indexI == -1 || indexJ == -1) {
            return true;
        }
        int abs = Math.abs(data[indexI] - data[indexJ]);
        return abs <= d;
    }


    public static class Node {
        public int value = 0;
        public int index;

        public Node(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }

}
