package netease.school;

import java.io.OutputStream;
import java.util.Scanner;

/**
 * @author Guan
 * @date Created on 2018/9/8
 */
public class Q3 {

    private static Item[] a;

    static int n, m;
    static int x, v, k;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            n = in.nextInt();
            m = in.nextInt();
            a = new Item[n];
            for (int i = 0; i < n; i++) {
                a[i] = new Item(in.nextInt());
            }
            int type = 0;

            for (int i = 0; i < m; i++) {
                type = in.nextInt();
                if (type == 1) {
                    k = in.nextInt();
                    f1(k);
                } else if (type == 2) {
                    x = in.nextInt();
                    v = in.nextInt();
                    f2(x, v);
                }
            }

        }


    }

    public static void f1(int k) {

        System.out.println(a[k - 1].now);

    }

    public static void f2(int x, long v) {
        x--;
        long v1;
        while (x < n) {
            v1 = a[x].add(v);
            if (v1 != 0) {
                v = v1;
                x++;
            } else {
                break;
            }
        }

    }

    public static class Item {
        long c = 0;
        long now = 0;

        public Item(long c) {
            this.c = c;
        }

        public long add(long n) {
            if (c - now >= n) {
                now += n;
                return 0;
            } else {
                now = c;
                return n - c;
            }
        }
    }


}
