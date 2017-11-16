package nowcoder.NetEase2017spring;

import java.util.Scanner;

public class HurryUp {
    private static int N;
    private static int gx;
    private static int gy;
    private static int walkTime;
    private static int taxiTime;

    private static int onlyWalkTime;
    private static int mixTime=Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            N = in.nextInt();
            int[] xs = new int[N];
            int[] ys = new int[N];
            for (int i = 0; i < N; i++) {
                xs[i] = in.nextInt();
            }
            for (int i = 0; i < N; i++) {
                ys[i] = in.nextInt();
            }
            gx = in.nextInt();
            gy = in.nextInt();
            walkTime = in.nextInt();
            taxiTime = in.nextInt();

            doHurryUp(xs, ys);
        }
    }

    static int tmp;
    public static void doHurryUp(int[] xs, int[] ys) {
        onlyWalkTime = (Math.abs(gx) + Math.abs(gy)) * walkTime;

        for (int i=0;i<N;i++)
        {
            tmp=getMixTime(xs[i],ys[i]);
            mixTime=mixTime>tmp?tmp:mixTime;
        }
        System.out.println(onlyWalkTime>mixTime?mixTime:onlyWalkTime);
    }

    static int time1, time2;

    public static int getMixTime(int cx, int cy) {
        time1 = (Math.abs(cx) + Math.abs(cy)) * walkTime;
        time2 = (Math.abs(gx - cx) + Math.abs(gy - cy)) * taxiTime;
        return time1 + time2;

    }


}
