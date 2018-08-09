package netease;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Guan
 * @date Created on 2018/8/9
 */
public class Candy {

    public static List<Node> list = new LinkedList<>();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String[] ss = in.nextLine().split(" ");
            doJob(ss);
        }

    }

    public static void doJob(String[] ss) {
        list.clear();
        for (String s : ss) {
            int i = Integer.valueOf(s);
            Node node = new Node(i);
            if (!list.contains(node)) {
                list.add(node);
                continue;
            }

            Node oldNode = findLastNode(i);
            if (oldNode.isFull()) {
                list.add(node);
            } else {
                oldNode.add();
            }
        }
        int result = 0;
        for (Node node : list) {
            result += node.maxSize;
        }
        System.out.println(result);


    }

    public static Node findLastNode(int num) {
        Node node = null;
        for (Node node1 : list) {
            if (node1.num == num) {
                node = node1;
            }
        }
        return node;
    }

    public static class Node {
        int num;
        int maxSize;
        int size = 1;

        public Node(int num) {
            this.num = num;
            maxSize = num + 1;
        }

        public boolean sameAs(int num) {
            return this.num == num;
        }

        public boolean isFull() {
            return size == maxSize;
        }

        public void add() {
            size++;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Node node = (Node) o;

            return num == node.num;
        }

        @Override
        public int hashCode() {
            return num;
        }
    }

}
