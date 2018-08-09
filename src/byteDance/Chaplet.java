package byteDance;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * [编程题] 手串
 *
 * @author Guan
 * @date Created on 2018/8/8
 */
public class Chaplet {

    static int n, m, c;
    static Item[] colors;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            n = in.nextInt();
            m = in.nextInt();
            c = in.nextInt();

            colors = new Item[c];
            for (int i=0;i<c;i++){
                colors[i] = new Item();
            }
            for (int i = 0; i < n; i++) {

                int num = in.nextInt();
                for (int j = 0; j < num; j++) {
                    colors[in.nextInt() - 1].add(i);
                }
            }

            int count = 0;
            for (Item item : colors) {
                if (!item.isRight()) {
                    count++;
                }
            }
            System.out.println(count);


        }
    }

    public static class Item {
        List<Integer> list = new ArrayList();

        public void add(int position) {
            list.add(position);
        }

        public boolean isRight() {
            if (list.size() == 0 || list.size() == 1) {
                return true;
            }

            for (int i = 0; i < list.size(); i++) {
                int j = (i + 1) % list.size();
                int distance = (list.get(j) - list.get(i) + n) % n;
                if (distance < m) {
                    return false;
                }
            }

            return true;

        }

    }
}
