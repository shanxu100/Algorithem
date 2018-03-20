package nowcoder.practice;

import java.util.Scanner;
import java.util.TreeSet;

/**
 * @author Guan
 * @date Created on 2018/3/5
 */
public class MakeSet {

    public static TreeSet<Integer> set=new TreeSet<Integer>();

    public static void main(String[] args) {
        int n, m;
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            n = in.nextInt();
            m = in.nextInt();
            set.clear();
            for (int i=0;i<n+m;i++)
            {
                set.add(in.nextInt());
            }
            output();
        }
    }

    private static void output() {
        StringBuilder sb=new StringBuilder(set.size()*2);
        for (int i: set)
        {
            sb.append(i).append(" ");
        }
        sb.deleteCharAt(sb.length()-1);
        System.out.println(sb.toString());
    }

}
