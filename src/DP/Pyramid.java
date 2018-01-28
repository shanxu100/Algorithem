package DP;

import java.util.*;

/**
 * 未完成
 * @author Guan
 * @date Created on 2018/1/28
 */
public class Pyramid {

    public static int F(int N, Item[] items) {

        Arrays.sort(items, new Comparator<Item>() {
            @Override
            public int compare(Item o1, Item o2) {
                if (o1.weight > o2.weight) {
                    return 1;
                } else if (o1.weight < o2.weight) {
                    return -1;
                } else if (o1.height > o2.height) {
                    return 1;
                } else if (o1.height < o2.height) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });

        for (Item item : items) {
            System.out.println(item.toString());
        }
        int[] B = new int[N];
        for (int i = 0; i < N; i++) {
            B[i] = 1;
        }

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (items[j].height <= items[i].height) {
                    B[i] = (B[j] + 1) > B[i] ? (B[j] + 1) : B[i];
                }
            }
        }
        int max = 0;
        for (int b : B) {
            max = b > max ? b : max;
            System.out.print(b+"\t");
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Item[] items;
        int N;
        while (in.hasNextInt()) {
            N = in.nextInt();
            items = new Item[N];
            for (int i = 0; i < N; i++) {
                items[i] = new Item();
                items[i].id = in.nextInt();
                items[i].weight = in.nextInt();
                items[i].height = in.nextInt();
            }
            System.out.println(F(N, items));
        }
    }

    public static class Item {
        public int id, weight, height;

        @Override
        public String toString() {
            return "Item{" +
                    "id=" + id +
                    ", weight=" + weight +
                    ", height=" + height +
                    '}';
        }
    }
}
