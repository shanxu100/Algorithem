package practice;

/**
 * @author Guan
 * @date Created on 2018/1/26
 */
public class MiBinary {

    public static void main(String[] args) {
        MiBinary m = new MiBinary();
        System.out.println(m.countBitDiff(1999, 2299));
    }

    public int countBitDiff(int m, int n) {
        int t = m & n;
//        System.out.println("1999 " + Integer.toBinaryString(1999));
//        System.out.println("2299" + Integer.toBinaryString(2299));

        System.out.println("t=" + t + "        " + Integer.toBinaryString(t));
        int count = 0;
        while (t != 0) {
            if (t % 2 == 1) {
                count++;
            }
            t = t / 2;
        }
        return 32 - count;
    }
}
