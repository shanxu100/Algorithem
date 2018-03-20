package nowcoder.practice;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * AC
 * <p>
 * 本题有一个难点，就是输入的行数不确定，也就是键盘输入几行就是几行，因此我们需要使用Scanner.class.hasNext()方法进行判断，
 * 该方法返回boolean类型的值，当键盘手动输入结束时才会返回false，window环境下使用ctrl+z结束输入循环，linux环境下使用ctrl+d结束输入循环。
 *
 * @author Guan
 * @date Created on 2018/3/4
 */
public class Cooking {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s;
        String[] food;
        Set<String> set = new HashSet<>(2500);

        while (in.hasNext()) {
            s = in.nextLine();
            food = s.split(" ");
            for (String f : food) {
                set.add(f);
            }
        }
        System.out.println(set.size());

    }

}
