package byteDance.ByteDance0812;

import java.util.Scanner;
import java.util.TreeMap;

/**
 * @author Guan
 * @date Created on 2018/8/12
 */
public class Live {
    public static TreeMap<Integer, Node> map;
    public static int M, N;


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            N = in.nextInt();
            M = in.nextInt();
            map = new TreeMap<>();
            for (int i = 0; i < N * 2; i++) {

            }


            doJob();

        }
    }

    private static void doJob() {

    }

    public static class Node {
        public int startNum = 0;
        public int endNum = 0;
    }

}
