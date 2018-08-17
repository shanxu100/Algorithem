package DP.example;

import java.util.Scanner;

/**
 * https://www.nowcoder.com/questionTerminal/12cbdcdf5d1e4059b6ddd420de6342b6
 * 重要：样板题
 *
 * @author Guan
 * @date Created on 2018/8/13
 */
public class Visit {

    public static void main(String[] args) {

        int[][] map = new int[][]{
                {0, 1, 0},
                {2, 0, 0}
        };

        System.out.println(new Visit().countPath(map, 2, 3));
    }

    public int countPath(int[][] map, int n, int m) {
        // write code here
        int sX = 0, sY = 0, eX = 0, eY = 0;
        int xForward, yForward;
        int[][] plans = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 1) {
                    sX = i;
                    sY = j;
                }
                if (map[i][j] == 2) {
                    eX = i;
                    eY = j;
                }
            }
        }

        xForward = eX - sX > 0 ? 1 : -1;
        yForward = eY - sY > 0 ? 1 : -1;

        //关键1：注意终止的关键条件
        for (int x = sX; x != eX + xForward; x += xForward) {
            for (int y = sY; y != eY + yForward; y += yForward) {
                //关键2：初始化第一个点的方式
                if (x == sX && y == sY) {
                    plans[x][y] = 1;
                } else if (x == sX) {
                    //初始化第一行的方式
                    plans[x][y] = map[x][y] == -1 ? 0 : plans[x][y - yForward];
                } else if (y == sY) {
                    //初始化第一列的方式
                    plans[x][y] = map[x][y] == -1 ? 0 : plans[x - xForward][y];
                } else {
                    plans[x][y] = map[x][y] == -1 ? 0 : plans[x - xForward][y] + plans[x][y - yForward];
                }
            }
        }
        return plans[eX][eY];

    }


}
