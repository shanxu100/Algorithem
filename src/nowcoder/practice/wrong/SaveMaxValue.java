package nowcoder.practice.wrong;

import java.util.*;

/**
 * @author Guan
 * @date Created on 2018/3/5
 */
public class SaveMaxValue {
    public static void main(String[] args) {
        String number;
        int n;
        Scanner in = new Scanner(System.in);
        /**
         * 如果使用了hasNextLine，下面就一直要用nextLine()方法
         */
        while (in.hasNextLine()) {
            number = in.nextLine();
            n = Integer.valueOf(in.nextLine());
//            System.out.println(number+" "+n);

            saveMaxValue(number, n);
        }


    }

    private static void saveMaxValue(String number, int n) {
//        System.out.println(number+" "+n);

        char[] chars = number.toCharArray();
        List<Character> list = new LinkedList<>();
        for (char c : chars) {
            //把char转换为int
            list.add(c);
        }

        int min;
        char minValue;
        while (n > 0) {
            n--;
            min = 0;
            minValue = 0x3A;
            int i = 0;
            Iterator<Character> iterator = list.iterator();
            while (iterator.hasNext()) {
                char c = iterator.next();
                if (c < minValue) {
                    min = i;
                    minValue=c;
                }
                i++;
            }
            list.remove(min);
        }
        for (int i : list) {
            //把char转换为int
            System.out.print(i-'0');
        }
        System.out.println();

    }


}
