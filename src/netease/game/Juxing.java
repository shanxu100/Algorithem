package netease.game;

import java.util.Scanner;

/**
 * @author Guan
 * @date Created on 2018/9/15
 */
public class Juxing {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {

            Point point1=new Point(in.nextInt(),in.nextInt());
            Point point2=new Point(in.nextInt(),in.nextInt());
            Point point3=new Point(in.nextInt(),in.nextInt());
            Point point4=new Point(in.nextInt(),in.nextInt());

            System.out.println("0.000000");
            System.out.println("0");

        }
    }

    public static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
