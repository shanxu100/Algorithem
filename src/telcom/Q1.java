package telcom;

import java.util.*;

/**
 * @author Guan
 * @date Created on 2018/9/10
 */
public class Q1 {


    public static String s;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);


        while (in.hasNext()) {

        }


    }

    public static String deleteS(String s) {
        Item[] items = new Item[26];
        char[] chars = s.toCharArray();
        for (char c : chars) {
            int index = c - 'a';
            if (items[index] == null) {
                items[index] = new Item(c + "");
            } else {
                items[index].add();
            }
        }

        int min = Integer.MAX_VALUE;
        for (Item item : items) {
            if (item != null) {
                min = item.count < min ? item.count : min;
            }
        }
        List<String> list = new ArrayList<>(100);
        for (Item item : items) {
            if (item != null && item.count == min) {
                list.add(item.s);
            }
        }
//        StringBuilder sb=new StringBuilder(s);
        for (String sList : list) {
            s=s.replace(sList, "");
        }
        return s;

//        List<Item> list=new ArrayList<>(26);
//        for (if)
//
//        Collections.sort(items);

    }

    public static class Item {
        String s;
        int count = 0;

        public Item(String s) {
            this.s = s;
            this.count = 1;
        }

        public void add() {
            count++;
        }
    }

}
