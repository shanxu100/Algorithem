package nowcoder.Tencent.shixi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * @author Guan
 * @date Created on 2018/3/23
 */
public class MagicSquare {

    public static void main(String[] args) {
        int n;
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            n = in.nextInt();
            for (int i = 0; i < n; i++) {
                Group group = new Group();
                for (int j = 0; j < 4; j++) {
                    group.getPoint(j).x = in.nextInt();
                }
                for (int j = 0; j < 4; j++) {
                    group.getPoint(j).y = in.nextInt();
                }
                group.doCount();
                if (group.doJudge()) {
                    System.out.println("Yes");
                } else {
                    System.out.println("No");
                }
            }
        }

    }


    public static class Group {
        List<Point> list = new ArrayList<>(4);
        TreeSet<Integer> numSet = new TreeSet<>();

        public Group() {
            for (int i = 0; i < 4; i++) {
                list.add(new Point());
            }
        }

        public Point getPoint(int positon) {
            return list.get(positon);
        }

        public void doCount() {
            for (int i = 0; i < 4; i++) {
                for (int j = i + 1; j < 4; j++) {
                    int distence = getDistence(list.get(i), list.get(j));
                    numSet.add(distence);
                }
            }
        }

        public boolean doJudge() {
            if (numSet.size() != 2) {
                return false;
            }
            int num1 = numSet.first();
            int num2 = numSet.last();
            if (2 * num1 != num2) {
                return false;
            }
            return true;
        }

        public static int getDistence(Point p1, Point p2) {
            return (p1.x - p2.x) * (p1.x - p2.x) + (p1.y - p2.y) * (p1.y - p2.y);
        }

    }


    public static class Point {
        int x;
        int y;
    }
}
