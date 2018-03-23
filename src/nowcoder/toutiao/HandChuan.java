package nowcoder.toutiao;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Guan
 * @date Created on 2018/3/23
 */
public class HandChuan {

    public static int n, m, c;
    public static ArrayList<Holder> colorList;

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            n = in.nextInt();
            m = in.nextInt();
            c = in.nextInt();
            colorList = new ArrayList<>(c);
            for (int i = 0; i < c; i++) {
                colorList.add(new Holder());
            }
            for (int i = 0; i < n; i++) {
                int tmp = in.nextInt();
                for (int j = 0; j < tmp; j++) {
                    int color = in.nextInt();
                    colorList.get(color - 1).add(i);
                }
            }

            int result = 0;
            for (Holder holder : colorList) {
                if (holder.minDiff < m) {
                    result++;
                }
            }
            System.out.println(result);
        }
    }

    public static class Holder {
        ArrayList<Integer> list = new ArrayList<>();
        int minDiff = Integer.MAX_VALUE;
        int lastEle = 0;

        public void add(int e) {
            if (list.size() != 0) {
                int newDiff = (e - lastEle) < (lastEle + n - e) ? (e - lastEle) : (lastEle + n - e);
                minDiff = newDiff < minDiff ? newDiff : minDiff;
                list.add(e);
                lastEle=e;
            } else {
                list.add(e);
                lastEle = e;
            }
        }


    }
}
