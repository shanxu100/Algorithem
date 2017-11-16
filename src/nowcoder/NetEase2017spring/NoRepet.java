package nowcoder.NetEase2017spring;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class NoRepet {
    private static LinkedHashSet<Integer> dataSet;
    private static int[] nums;
    private static int N;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            N = in.nextInt();
            dataSet = new LinkedHashSet<>(N);
            nums = new int[N];
            for (int i = 0; i < N; i++) {
                nums[i] = in.nextInt();
            }

            for (int i = N - 1; i >= 0; i--) {
                dataSet.add(nums[i]);
            }
            sb.setLength(0);
            for (int data : dataSet) {
                sb.insert(0,data).insert(0," ");
            }
            sb.deleteCharAt(0);
            System.out.println(sb.toString());
        }
    }
}
