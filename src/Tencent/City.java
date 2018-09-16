package Tencent;

import java.util.*;

/**
 * @author Guan
 * @date Created on 2018/9/16
 */
public class City {

    public static int n, m;

    public static Node[] array;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            n = in.nextInt();
            m = in.nextInt();

            array = new Node[n];
            for (int i = 0; i < m; i++) {
                int u = in.nextInt();
                int v = in.nextInt();
                if (array[u] == null) {
                    array[u] = new Node(n);
                }
                add(array[n], new Node(v));


            }
            f();

        }
    }

    public static void f() {


    }

    public static void F2(Node node) {


    }

    public static void add(Node root, Node node) {
        while (root.next != null) {
            root = root.next;
        }
        root.next = node;
    }

    public static class Node {
        private int city;

        int x = -1, y = -1;

        Node next;

        public Node(int city) {
            this.city = city;
        }


    }


}
