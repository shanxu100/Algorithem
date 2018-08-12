package byteDance.ByteDance0812;

import java.util.*;

/**
 * @author Guan
 * @date Created on 2018/8/12
 */
public class WorldCup {

    public static int M, N;
    public static Node[][] data;
    static Queue<Node> queue;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String[] mn = in.nextLine().split(",");
            M = Integer.valueOf(mn[0]);
            N = Integer.valueOf(mn[1]);
            data = new Node[M][N];

            for (int i = 0; i < M; i++) {
                String[] ss = in.nextLine().split(",");
                for (int j = 0; j < ss.length; j++) {
                    data[i][j] = new Node(i, j, Integer.parseInt(ss[j]));
                }
            }
            doJob();

        }
    }

    public static void doJob() {
        long groupCount = 0;
        long id=1000000000;
        queue = new ArrayDeque<>();
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (data[i][j].value == 1 && data[i][j].id == -1) {
                    id--;
                    groupCount++;
                    queue.add(data[i][j]);
                    while (!queue.isEmpty()) {
                        Node node = queue.poll();
                        enqueue(node.x, node.y);
                        node.id = id;
                    }
                }
            }
        }
        Map<Long, Long> map = new HashMap<>();
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (data[i][j].value != 0) {
                    if (map.containsKey(data[i][j].id)){
                        long value = map.get(data[i][j].id) + 1;
                        map.put(data[i][j].id, value);
                    }else {
                        map.put(data[i][j].id, 1L);
                    }

                }
            }
        }
        long max = 0;
        for (Map.Entry<Long, Long> entry : map.entrySet()) {
            max = entry.getValue() > max ? entry.getValue() : max;
        }
        System.out.println(groupCount + "," + max);

    }

    public static void enqueue(int x, int y) {

        int minX = x - 1 >= 0 ? x - 1 : x;
        int maxX = x + 1 < M ? x + 1 : x;
        int minY = y - 1 >= 0 ? y - 1 : y;
        int maxY = y + 1 < N ? y + 1 : y;
        for (int i = minX; i <= maxX; i++) {
            for (int j = minY; j <= maxY; j++) {
                if (data[i][j].value == 1 && data[i][j].id == -1) {
                    queue.add(data[i][j]);
                }

            }
        }
    }


    public static class Node {
        int x, y, value;
        long id = -1;

        public Node(int x, int y, int value) {
            this.x = x;
            this.y = y;
            this.value = value;
        }
    }
}
