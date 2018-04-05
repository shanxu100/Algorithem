package nowcoder.Tencent.zhengshi;

import java.util.Scanner;

/**
 * @author Guan
 * @date Created on 2018/4/5
 */
public class huajia {

    public static int result;
    public static int N, M;
    public static char[][] matrix;


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);


        while (in.hasNextLine()) {
            String[] tmp = in.nextLine().split(" ");
            N = Integer.valueOf(tmp[0]);
            M = Integer.valueOf(tmp[1]);
            matrix = new char[N][];
            for (int i = 0; i < N; i++) {
                matrix[i] = in.nextLine().toCharArray();
            }
            result = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (matrix[i][j] == 'B') {
                        fixB(i, j);
                    } else if (matrix[i][j] == 'Y') {
                        fixY(i, j);
                    } else if (matrix[i][j] == 'G') {
                        fixG(i, j);
                    }
                }
            }

            /**
             *
             *
             *
             *
             * 4 4
             YXXB
             XYGX
             XBYY
             BXXY
             *
             *
             */
            System.out.println(result);

        }

    }

    public static void fixG(int gx, int gy) {
        fixB(gx, gy);
        fixY(gx, gy);
    }

    public static void fixY(int bx, int by) {
        result++;
        int x = bx, y = by;

        while (x < N && x >= 0 && y >= 0 && y < M) {
            if (matrix[x][y]=='G') {
                matrix[x][y] ='B';
            } else {
                matrix[x][y] = 'X';
            }
            x++;
            y++;
        }
        x = bx;
        y = by;
        while (x < N && x >= 0 && y >= 0 && y < M) {
            if (matrix[x][y]=='G') {
                matrix[x][y] ='B';
            } else {
                matrix[x][y] = 'X';
            }
            x--;
            y--;
        }
    }

    public static void fixB(int bx, int by) {
        result++;
        int x = bx, y = by;
        while (x < N && x >= 0 && y >= 0 && y < M) {
            if (matrix[x][y]=='G') {
                matrix[x][y] ='Y';
            } else {
                matrix[x][y] = 'X';
            }
            x++;
            y--;
        }
        x = bx;
        y = by;
        while (x < N && x >= 0 && y >= 0 && y < M) {
            if (matrix[x][y]=='G') {
                matrix[x][y] ='Y';
            } else {
                matrix[x][y] = 'X';
            }
            x--;
            y++;
        }
    }

}
