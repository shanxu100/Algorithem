package nowcoder.real;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author Guan
 * @date Created on 2018/3/21
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        String[] str = new String[num];
        int[] a = new int[num];
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < num; i++) {
            str[i] = sc.next();
            int data = Integer.decode(str[i]);
            List<Integer> l = new ArrayList<Integer>();
            while (data != 0) {
                int d1 = data % 2;
                data = data / 2;
                l.add(d1);
            }
            int t = l.size() % 4;
            t = 4 - t;
            while (t != 0) {
                list.add(0);
                t--;
            }
            for (int j = l.size() - 1; j >= 0; j--) {
                list.add(l.get(j));
            }
        }
        int d1 = sc.nextInt();
        int[] dd = new int[d1];
        for (int k = 0; k < d1; k++) {
            dd[k] = sc.nextInt();
        }
        int s1 = 0;
        for (int i = 0; i < d1; i++) {
            int s = dd[i];
            int sum = 0;
            for (int j = 0; j < s; j++) {
                int ss = list.get(s1);
                s1++;
                sum = sum * 2;
                sum += ss;
            }
            System.out.println(sum);
        }
    }
}