package telcom;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Guan
 * @date Created on 2018/9/10
 */
public class Q3 {

    public static Map<Integer, Boolean> map = new HashMap<>(5000);

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);


        while (in.hasNext()) {

            int N = in.nextInt();
            System.out.println(f(N));
        }


    }

    public static int f(int N) {
        if (N <= 0) {
            return 0;
        }
        int number = 0;
        int count = 0;
        while (count < N) {
            number++;
            if (isUgly(number)) {
                count++;
            }
        }
        return number;
    }

    public static boolean isUgly(int num) {
        int origNum = num;
        if (map.containsKey(num)) {
            return map.get(num);
        }

        while (num % 2 == 0) {
            num /= 2;
        }
        while (num % 3 == 0) {
            num /= 3;
        }
        while (num % 5 == 0) {
            num /= 5;
        }
        if (num == 1) {
            map.put(origNum, true);
            return true;
        } else {
            map.put(origNum, false);
            return false;
        }

    }

}
