package nowcoder.HUAWEI;

import java.util.Scanner;

public class HighestScore {


    private static int N;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            N = in.nextInt();
            int M = in.nextInt();
            int[] scores = new int[N];
            for (int i = 0; i < N; i++) {
                scores[i] = in.nextInt();
            }

            while (M >= 1) {
                M--;
                String cmd = in.next();
                int A = in.nextInt();
                int B = in.nextInt();

                if (cmd.equals("Q")) {
                    doQuestion(A, B, scores);
                } else {
                    doUpdate(A, B, scores);
                }
            }
        }



    }

    private static void doUpdate(int A, int B, int[] scores) {
        scores[A - 1] = B;
    }

    private static void doQuestion(int A, int B, int[] score) {
        A--;
        B--;
        if (A > B) {
            int tmp = A;
            A = B;
            B = tmp;
        }
        int max = score[A];
        for (int i = A; i <= B; i++) {
            max = score[i] > max ? score[i] : max;
        }
        System.out.println(max);
    }

}
