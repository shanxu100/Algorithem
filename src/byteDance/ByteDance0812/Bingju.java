package byteDance.ByteDance0812;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * @author Guan
 * @date Created on 2018/8/12
 */
public class Bingju {

    public static TreeMap<Integer, Node> map;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int m = Integer.parseInt(in.nextLine());
            map = new TreeMap<>();

            for (int i = 0; i < m; i++) {
                String[] line = in.nextLine().split(";");
                for (int j = 0; j < line.length; j++) {
                    String[] se = line[j].split(",");
                    int start = Integer.parseInt(se[0]);
                    int end = Integer.parseInt(se[1]);
                    if (map.containsKey(start)) {
                        map.get(start).startNum++;
                    } else {
                        Node node = new Node();
                        node.startNum = 1;
                        map.put(start, node);
                    }
                    if (map.containsKey(end)) {
                        map.get(end).endNum++;
                    } else {
                        Node node = new Node();
                        node.endNum = 1;
                        map.put(end, node);
                    }

                }

            }
            doJob();

        }
    }

    public static void doJob() {
        int start = 0, end = 0;
        int startCount = 0, endCount = 0;
        boolean isFirst = true;
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Integer, Node> entry : map.entrySet()) {
//            System.out.println(entry.getKey() + "--" + entry.getValue().startNum+"/"+entry.getValue().endNum);

            if (isFirst) {
                sb.append(entry.getKey()).append(",");
                isFirst = false;
            }
            start++;
            startCount += entry.getValue().startNum;
            endCount += entry.getValue().endNum;
            if (startCount - endCount == 0) {
                sb.append(entry.getKey()).append(";");
                isFirst = true;
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb.toString());

//        for ()
    }

    public static class Node {
        public int startNum = 0;
        public int endNum = 0;
    }

}
