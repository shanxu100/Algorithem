package Tencent;

import sun.security.util.Length;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Guan
 * @date Created on 2018/9/16
 */
public class Q3 {

    public static String S;
    public static String P;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            S = in.nextLine();
            P = in.nextLine();
            List<Item> list = f();
            long result = 0;
            for (Item item : list) {
                int t = item.max - item.min + P.length();
                result += (t * t);
            }
            System.out.println(result);
        }


    }

    public static List<Item> f() {

        List<Integer> list = new ArrayList<>();
        List<Item> result = new ArrayList<>();


        while (true) {
            int position = S.indexOf(P);
            if (position == -1) {
                break;
            }
            StringBuilder sb = new StringBuilder(S);
            sb.setCharAt(position, '1');
            S = sb.toString();
            list.add(position);
        }
        if (list.size() == 0) {
            return result;
        }


        Item item = new Item();
        item.add(list.get(0));
        result.add(item);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) - list.get(i - 1) <= P.length()) {
                result.get(result.size() - 1).add(list.get(i));
            } else {
                Item item1 = new Item();
                item1.add(list.get(i));
                result.add(item1);
            }
        }

        return result;
    }

    public static class Item {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;

        public void add(int value) {
            min = Math.min(min, value);
            max = Math.max(max, value);
        }
    }


}
