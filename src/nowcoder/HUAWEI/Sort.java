package nowcoder.HUAWEI;

import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;

public class Sort {
    public static void main(String[] args) {

        TreeSet<Integer> ids;
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int total = in.nextInt();
            ids = new TreeSet<Integer>();
            for (int i = 0; i < total; i++) {
                ids.add(in.nextInt());
            }

            for (int i : ids) {
                System.out.println(i);
            }
        }

    }
}
