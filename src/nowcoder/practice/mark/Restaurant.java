package nowcoder.practice.mark;

import java.util.*;

/**
 * https://www.nowcoder.com/questionTerminal/d2cced737eb54a3aa550f53bb3cc19d0
 * AC
 *
 * @author Guan
 * @date Created on 2018/3/5
 */
public class Restaurant {
    public static void main(String[] args) {
        int n, m;
        List<Integer> tables;
        List<Group> list;
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            n = in.nextInt();
            m = in.nextInt();

            tables = new ArrayList<>(n);
            for (int i = 0; i < n; i++) {
                tables.add(in.nextInt());
            }

            list = new ArrayList<>(m);
            for (int i = 0; i < m; i++) {
                list.add(new Group(in.nextInt(), in.nextInt()));
            }
            sit(n, m, tables, list);

        }
    }

    public static void sit(int n, int m, List<Integer> tables, List<Group> list) {
        mySort(tables, list);

        long result = 0;
        for (int i = 0; i < m; i++) {

            int index = binSearch(tables, list.get(i).b);
            if (index == -1) {
                continue;
            }
            tables.remove(index);
            result += list.get(i).c;
        }
        System.out.println(result);
    }

    /**
     * 采用二分法才行，否则超时
     *
     * @param tables
     * @param list
     */
    public static void mySort(List<Integer> tables, List<Group> list) {
        Collections.sort(tables);

        Collections.sort(list, new Comparator<Group>() {
            @Override
            public int compare(Group o1, Group o2) {
                if (o1.c > o2.c) {
                    return -1;
                } else if (o1.c < o2.c) {
                    return 1;
                } else if (o1.b < o2.b) {
                    return -1;
                } else {
                    return 1;
                }
            }
        });
    }

    public static int binSearch(List<Integer> tables, int target) {
        int low = 0;
        int high = tables.size() - 1;
        if (high < 0 || tables.get(high) < target) {
            return -1;
        }

        int mid;
        while (low < high) {
            mid = (low + high) / 2;
            if (tables.get(mid) < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return high;


    }


    /**
     * 每一批中的一组人
     */
    public static class Group {
        public int b, c;

        /**
         * @param b 人数
         * @param c 消费金额
         */
        public Group(int b, int c) {
            this.b = b;
            this.c = c;
        }
    }

}

