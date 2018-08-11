package netease.netease0811;

import java.util.Scanner;

/**
 * @author Guan
 * @date Created on 2018/8/11
 */
public class FengShou {
    public static int n, m;
    public static int[] data;

    public static int[] question;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            n = in.nextInt();
            data = new int[n];
            int tmp = 0;
            for (int i = 0; i < n; i++) {
                tmp += in.nextInt();
                data[i] = tmp;
            }

            m = in.nextInt();
            question = new int[m];
            for (int i = 0; i < m; i++) {
                question[i] = in.nextInt();
            }

            doJob();
        }

    }

    public static void doJob() {
        for (int i = 0; i < m; i++) {
            System.out.println(BinarySearchHand(question[i]) + 1);
        }
    }

    public static int BinarySearchHand(int target) {
        int left = 0;
        int right = data.length - 1;

        while (left < right) {
            int mid = (left + right + 1) / 2;
            if (data[mid] <= target) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        if (right >= 1 && data[right - 1] >= target) {
            return right - 1;
        }
        if (data[right] >= target) {
            return right;
        }
        if (data[right + 1] >= target) {
            return right + 1;
        }
        return -1;

    }


}
