package nowcoder.practice;

import java.util.List;
import java.util.Scanner;

/**
 * @author Guan
 * @date Created on 2018/3/7
 */
public class DictSequence {
    static long n, m;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLong()) {
            n = in.nextLong();
            m = in.nextLong();
            getSequence();
        }
    }

    public static void getSequence() {

    }

    public static void helper(int start, int end, int h, List<Integer> list) {

    }

    public static Holder countHolder(int start, int end, int target, int h) {

        Holder holder = new Holder();
        if (target > start) {
            holder.pre = (long) Math.pow(10, h - 1) + 1;
        } else {
            holder.pre = 0;
        }
        if (target < end) {
            holder.post = (long) Math.pow(10, h - 2) + 1;
        } else {
            holder.post = 0;
        }
        holder.mid = n - holder.pre * (target - start) - holder.post * (target - end);
        return holder;
    }

    public static class Holder {
        long pre, mid, post;
    }

}
