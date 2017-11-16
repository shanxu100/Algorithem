package nowcoder.HUAWEI;

import java.util.Scanner;

public class Drink {
    private static int A;
    private static int B;
    private static int total = 0;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num;

        while (true) {
            num = in.nextInt();
            if (num == 0) {
                break;
            }
            total = 0;
            doDrink(num);
            System.out.println(total);
        }


    }

    public static void doDrink(int num) {
        if (num == 1) {
            return;
        }
        if (num == 2) {
            total++;
            return;
        }

        A = num / 3;
        B = num % 3;
        total += A;

        doDrink(A + B);
    }

}
