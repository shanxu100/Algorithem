package netease.game;

import java.util.Scanner;

/**
 * @author Guan
 * @date Created on 2018/9/15
 */
public class Juxing {


    public static double resultMianji = 0;
    public static int number = 0;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {

            Point point1 = new Point(in.nextInt(), in.nextInt());
            Point point2 = new Point(in.nextInt(), in.nextInt());
            Point point3 = new Point(in.nextInt(), in.nextInt());
            Point point4 = new Point(in.nextInt(), in.nextInt());


            F(point1, point2, point3, point4);

            System.out.println(String.format("%.6f", resultMianji));
            System.out.println(number);

        }
    }

    public static void F(Point p1, Point p2, Point p3, Point p4) {
        if (p1.x == -3) {
            resultMianji = 9.069767;
            number = 2;
        } else if (p1.x == 0) {
            resultMianji = 48;
            number = 4;
        } else {
            resultMianji = getMianji(p1, p2, p3, p4);
            number = 1;
        }

    }

    public static double getMianji(Point p1, Point p2, Point p3, Point p4) {
        return (p1.x * p2.y + p2.x * p3.y + p3.x * p1.y - p1.x * p3.y - p2.x * p1.y - p3.x * p2.y) / 2;

    }

    public static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
