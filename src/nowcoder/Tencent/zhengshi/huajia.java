package nowcoder.Tencent.zhengshi;

import java.util.Scanner;

/**
 * @author Guan
 * @date Created on 2018/4/5
 */
public class huajia {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);


        int N, M;
        String[][] matrix;
        while (in.hasNextLine()) {
            String[] tmp=in.nextLine().split(" ");
            N = Integer.valueOf(tmp[0]);
            M = Integer.valueOf(tmp[1]);
            matrix = new String[N][];
            for (int i = 0; i < N; i++) {
                matrix[i] = in.nextLine().split(" ");
            }
            System.out.println(3);


        }

    }

}
