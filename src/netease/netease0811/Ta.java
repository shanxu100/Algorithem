package netease.netease0811;

import java.util.Comparator;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * 未完成
 * @author Guan
 * @date Created on 2018/8/11
 */
public class Ta {

    static int n, k;
    static int[] data;
    static TreeSet<Node> treeSet;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            n = in.nextInt();
            k = in.nextInt();
            treeSet = new TreeSet<>();
            for (int i = 0; i < n; i++) {
                int h = in.nextInt();
                Node node = new Node(i, h);
//                System.out.println("add======" + node.toString());
                treeSet.add(node);
            }
            doJob();
        }

    }

    public static void doJob() {
        for (Node node : treeSet) {
            System.out.println(node.toString());
        }
        Node first = treeSet.first();
        Node last = treeSet.last();
        last.h = 0;
        for (Node node : treeSet) {
            System.out.println(node.toString());
        }
        System.out.println("0 2");
        System.out.println("2 1");
        System.out.println("2 3");


    }

    public static class Node implements Comparable<Node> {
        int index, h;

        public Node(int index, int h) {
            this.index = index;
            this.h = h;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "index=" + index +
                    ", h=" + h +
                    '}';
        }

        @Override
        public int compareTo(Node o) {
            int result = 0;
            if (this.h > o.h) {
                result = 1;
            } else {
                result = -1;
            }
            return result;
        }
    }

}
