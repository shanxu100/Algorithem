package nowcoder.NetEase2017spring;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class MySet {

    private static HashSet<Float> dataSet = new HashSet<>(1024);
    private static int w, x, y, z;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            w = in.nextInt();
            x = in.nextInt();
            y = in.nextInt();
            z = in.nextInt();

            doSet();
        }
    }

    public static void doSet() {
        for (float i = y; i <= z; i++) {
            for (float j = w; j <= x; j++) {
                dataSet.add(j / i);
            }
        }
        System.out.println(dataSet.size());
    }

}
