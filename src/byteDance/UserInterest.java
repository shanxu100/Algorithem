package byteDance;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * [编程题] 用户喜好
 * @author Guan
 * @date Created on 2018/8/8
 */
public class UserInterest {

    public static int[] interest;
    public static ArrayList<Item> list;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            //注意while处理多个case 
            int n = in.nextInt();
            interest = new int[n];
            for (int i = 0; i < n; i++) {
                interest[i] = in.nextInt();
            }
            int q = in.nextInt();
            list = new ArrayList<>(q);
            for (int i = 0; i < q; i++) {
                Item item = new Item(in.nextInt(), in.nextInt(), in.nextInt());
                list.add(item);
            }
            doJob();


        }
    }

    public static void doJob() {
        for (Item item : list) {
            int count = 0;
            int l = item.l - 1;
            int r = item.r - 1;
            while (l <= r) {
                if (interest[l] == item.k) {
                    count++;
                }
                ++l;
            }
            System.out.println(count);
        }
    }

    public static class Item {
        int l, r, k;

        public Item(int l, int r, int k) {
            this.l = l;
            this.r = r;
            this.k = k;
        }
    }

}
