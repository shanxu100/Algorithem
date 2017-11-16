package nowcoder.NetEase2018;

import java.util.Scanner;

public class Magic {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            //注意while处理多个case             
            int target = in.nextInt();
            doMagic(target);
        }
    }

    public static void doMagic(int target) {
        StringBuilder result = new StringBuilder();
        while (target > 0) {
            if (target % 2 == 0) {
                //偶数
                result.append("2");
                target = (target - 2) / 2;
            } else {
                //奇数
                result.append("1");
                target = (target - 1) / 2;
            }
        }
        System.out.println(result.reverse());
    }

}
