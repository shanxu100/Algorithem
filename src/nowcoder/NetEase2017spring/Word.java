package nowcoder.NetEase2017spring;

import java.util.HashSet;
import java.util.Scanner;

public class Word {

    private static int n, m;
    private static HashSet<String> userSet;
    private static HashSet<String> sysSet;


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            n = in.nextInt();
            m = in.nextInt();
            userSet = new HashSet<>(n);
            sysSet = new HashSet<>(m);
            for (int i = 0; i < n; i++) {
                userSet.add(in.next());
            }
            for (int i = 0; i < m; i++) {
                sysSet.add(in.next());
            }
            score();
        }
    }

    public static void score() {
        int result = 0;
        for (String s : userSet) {
            if (sysSet.contains(s)) {
                result += s.length() * s.length();
            }
        }
        System.out.println(result);

    }
}
