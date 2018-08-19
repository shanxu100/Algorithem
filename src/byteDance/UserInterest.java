package byteDance;

import java.util.*;

/**
 * [编程题] 用户喜好
 * 70%
 *
 * @author Guan
 * @date Created on 2018/8/8
 */
public class UserInterest {

    public static int[] interests;
    public static ArrayList<Item> list;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            //注意while处理多个case 
            int n = in.nextInt();
            interests = new int[n];
            for (int i = 0; i < n; i++) {
                interests[i] = in.nextInt();
            }
            int q = in.nextInt();
            list = new ArrayList<>(q);
            for (int i = 0; i < q; i++) {
                Item item = new Item(in.nextInt(), in.nextInt(), in.nextInt());
                list.add(item);
            }
            doJob2();


        }
    }

    /**
     * 超时
     */
    public static void doJob() {
        for (Item item : list) {
            int count = 0;
            int l = item.l - 1;
            int r = item.r - 1;
            while (l <= r) {
                if (interests[l] == item.k) {
                    count++;
                }
                ++l;
            }
            System.out.println(count);
        }
    }

    /**
     * 创建map<int 喜爱值，List 喜爱值对应的所有用户升序编号>
     */
    public static void doJob2() {
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < interests.length; i++) {
            int interest = interests[i];
            if (!map.containsKey(interest)) {
                map.put(interest, new LinkedList<Integer>());
            }
            map.get(interest).add(i + 1);
        }

        for (Item item : list) {
            int count = 0;
            List<Integer> list = map.get(item.k);
            if (list == null) {
                continue;
            }
            for (int index : list) {
                if (index >= item.l && index <= item.r) {
                    count++;
                }
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
