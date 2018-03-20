package nowcoder.practice;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * AC
 *
 * @author Guan
 * @date Created on 2018/3/5
 */
public class HotelPrice {

    public static int[] arr;

    public static void main(String[] args) {
        List<Price> list = new LinkedList<>();
        Scanner in = new Scanner(System.in);
        int a, b, c;
        int max = Integer.MIN_VALUE;
        while (in.hasNextInt()) {
            a = in.nextInt();
            max = a > max ? a : max;
            b = in.nextInt();
            max = b > max ? b : max;
            c = in.nextInt();

            Price p = new Price(a, b, c);
            list.add(p);
        }
        arr = new int[max + 1];
        merge(list);
    }

    public static void merge(List<Price> list) {

        for (int i = 0; i < arr.length; i++) {
            arr[i] = -1;
        }
        for (Price price : list) {
            for (int i = price.start; i <= price.end; i++) {
                arr[i] = price.p;
            }
        }
//        System.out.println();
        output();
    }

    public static void output() {

        int currentValue = arr[0];
        int startIndex = 0;
        List<Price> list = new LinkedList<>();
        for (int i = 1; i < arr.length; i++) {
            if (currentValue == arr[i]) {
                continue;
            } else {
                Price price = new Price(startIndex, i - 1, currentValue);
                list.add(price);
                startIndex = i;
                currentValue = arr[i];
            }
        }
        Price p = new Price(startIndex, arr.length - 1, currentValue);
        list.add(p);

        StringBuilder sb = new StringBuilder();
        for (Price price : list) {
            if (price.p != -1) {
                sb.append("[").append(price.start)
                        .append(", ").append(price.end)
                        .append(", ").append(price.p)
                        .append("],");
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb.toString());

    }

    public static class Price {
        int start, end, p;

        public Price(int start, int end, int p) {
            this.start = start;
            this.end = end;
            this.p = p;
        }
    }

}
