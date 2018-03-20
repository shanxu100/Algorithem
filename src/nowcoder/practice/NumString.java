package nowcoder.practice;

import java.util.*;

/**
 * @author Guan
 * @date Created on 2018/3/6
 */
public class NumString {

    public static void main(String[] args) {
        int N;
        List<String> list = new ArrayList<>(101);
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            N = in.nextInt();
            list.clear();
            for (int i = 0; i < N; i++) {
                list.add(String.valueOf(in.nextInt()));
            }

            getNumString(N, list);
        }
    }

    public static void getNumString(int N, List<String> list) {

        /**
         * 不用考虑的太复杂
         */
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if ((o1 + o2).compareTo(o2 + o1) > 0) {
                    return -1;
                } else {
                    return 1;
                }
            }
        });


        for (String str : list) {
            System.out.print(str);
        }
        System.out.println();
    }
}
