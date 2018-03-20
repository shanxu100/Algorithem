package nowcoder.practice.wrong;

import java.util.*;

/**
 * Wrong
 * 考虑多叉树，需要去掉
 *
 * @author Guan
 * @date Created on 2018/3/5
 */
public class HeightOfTree {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        if (n < 3) {
            System.out.println(n);
        } else {
            int[] height = new int[n];
            int[] binary = new int[n];
            height[0] = 1;
            int max = 0;
            for (int i = 0; i < n - 1; i++) {
                int parent = in.nextInt();
                int child = in.nextInt();
                binary[parent] += 1;
                if (binary[parent] < 3) {
                    height[child] = height[parent] + 1;
                }
                max = Math.max(max, height[child]);
            }
            System.out.println(max);
        }
    }


    public static void main2(String[] args) {
        int n, parent, child;
        HashMap<Integer, Integer> map;
        List<Node> list = new LinkedList<>();
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            n = in.nextInt();
            map = new HashMap<>(n);
            list.clear();
            map.put(0, 1);
            for (int i = 0; i < n - 1; i++) {
                parent = in.nextInt();
                child = in.nextInt();
                Node node = new Node(parent, child);
                list.add(node);
            }
            getHeight(list, map);

        }
    }

    public static void getHeight(List<Node> list, Map<Integer, Integer> map) {

        Collections.sort(list, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if (o1.parent > o2.parent) {
                    return 1;
                } else {
                    return -1;
                }
            }
        });

        int tmpHeight;
        for (Node node : list) {
            if (map.containsKey(node.parent)) {
                tmpHeight = map.get(node.parent);
                map.put(node.child, tmpHeight + 1);
            }
        }
        int maxHeight = -1;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            maxHeight = entry.getValue() > maxHeight ? entry.getValue() : maxHeight;
        }
        System.out.println(maxHeight);


    }

    public static class Node {
        int parent, child;

        public Node(int parent, int child) {
            this.parent = parent;
            this.child = child;
        }
    }


}
