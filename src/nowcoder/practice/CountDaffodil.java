package nowcoder.practice;

import com.sun.deploy.util.SyncAccess;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * AC
 *
 * @author Guan
 * @date Created on 2018/3/5
 */
public class CountDaffodil {
    public static int[] arr = new int[10];
    public static LinkedList<Integer> result = new LinkedList<>();

    public static int a, b, c;

    public static void main(String[] args) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i * i * i;
        }
        int N, M;
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            N = in.nextInt();
            M = in.nextInt();
            countDaffodil(N, M);
        }
    }


    private static void countDaffodil(int n, int m) {
        result.clear();
        for (int i = n; i <= m; i++) {
            a = i % 10;
            b = (i / 10) % 10;
            c = (i / 100);

            if (arr[a] + arr[b] + arr[c] == i) {
                result.add(i);
            }
        }

        output();

    }

    public static void output() {
        if (result.size() == 0) {
            System.out.println("no");
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (int a : result) {
            sb.append(a).append(" ");
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb.toString());
    }


}
