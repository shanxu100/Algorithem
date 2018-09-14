package baidu;

import java.util.*;

/**
 * @author Guan
 * @date Created on 2018/9/14
 */
public class Q3 {

    public static int n;
    public static List<Item> list;


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            n = in.nextInt();
            list = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                Item item = new Item();
                item.wuli = in.nextInt();
                list.add(item);
            }
            for (int i = 0; i < n; i++) {
                list.get(i).mofa = in.nextInt();
            }
            System.out.println(getF());

        }

    }

    public static int getF() {
        int tmpN = n / 3;
        Item[] wuliItems = new Item[tmpN];
        Item[] mofaItems = new Item[tmpN];
        Item[] otherItems = new Item[tmpN];
        Collections.sort(list, new ValueCompare());
        for (int i = 0; i < tmpN; i++) {
            wuliItems[i] = list.get(0);
            list.remove(0);
        }

        for (int i = 0; i < tmpN; i++) {
            mofaItems[i] = list.get(0);
            list.remove(0);
        }

        for (int i = 0; i < tmpN; i++) {
            otherItems[i] = list.get(0);
            list.remove(0);
        }
        int result = 0;
        result += count(wuliItems, 0);
        result += count(mofaItems, 1);
        result += count(otherItems, 2);
        return result;


    }

    public static int count(Item[] items, int type) {
        int result = 0;
        if (type == 0) {
            for (Item item : items) {
                result += item.wuli;
            }
        } else if (type == 1) {
            for (Item item : items) {
                result += item.mofa;
            }
        } else {
            for (Item item : items) {
                result += item.mofa;
                result += item.wuli;
            }
            result = result / 2;

        }
        return result;
    }

    public static class Item {
        public int wuli;
        public int mofa;
        public double value;

        public void doValue() {
            value = wuli / mofa;
        }
    }

    public static class ValueCompare implements Comparator<Item> {

        @Override
        public int compare(Item o1, Item o2) {
            if (o1.value > o2.value) {
                return -1;
            } else {
                return 1;
            }
        }
    }

    public static class WuliCompare implements Comparator<Item> {

        @Override
        public int compare(Item o1, Item o2) {
            if (o1.wuli > o2.wuli) {
                return -1;
            } else if (o1.wuli < o2.wuli) {
                return 1;
            } else {
                return o1.mofa < o2.mofa ? 1 : -1;
            }
        }
    }

    public static class MofaCompare implements Comparator<Item> {

        @Override
        public int compare(Item o1, Item o2) {
            if (o1.mofa > o2.mofa) {
                return -1;
            } else if (o1.mofa < o2.mofa) {
                return 1;
            } else {
                return o1.wuli < o2.wuli ? 1 : -1;
            }
        }
    }

}
