package nowcoder.practice;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * AC
 * @author Guan
 * @date Created on 2018/3/5
 */
public class MakeQueue {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T;
        int n;
        while (in.hasNextInt()) {
            T = in.nextInt();
            for (int i = 0; i < T; i++) {
                n = in.nextInt();
                makeQueue(n);
            }

        }

    }

    public static void makeQueue(int n) {
        LinkedList<Integer> linkedList = new LinkedList<Integer>();
        int tmp;
        while (n > 0) {
            linkedList.addFirst(n);
            tmp = linkedList.getLast();
            linkedList.removeLast();
            linkedList.addFirst(tmp);
            n--;
        }

        output(linkedList);
    }

    private static void output(LinkedList<Integer> linkedList) {
        StringBuilder sb = new StringBuilder();
        for (Integer integer : linkedList) {
            sb.append(integer).append(" ");
        }
        sb.deleteCharAt(sb.length()-1);
        System.out.println(sb.toString());
    }
}
