package netease;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Guan
 * @date Created on 2018/8/9
 */
public class WordMatrix {


    public static char[][] matrix;
    public static int m, n;
    public static String word;

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int T = in.nextInt();
            while (T > 0) {
                T--;
//                String mn=in.nextLine();
                m = in.nextInt();
                n = in.nextInt();
                //nextInt和nextLine混合使用时，多读一行换行
                in.nextLine();
                matrix = new char[m][n];
                for (int i = 0; i < m; i++) {
                    matrix[i] = in.nextLine().toCharArray();
                }
                word = in.nextLine();
                doJob();
            }
        }


    }

    public static void doJob() {
        char[] wordChars = word.toCharArray();
        List<Position> list = findFirstChar(wordChars[0]);
        int result = 0;
        for (Position position : list) {
            result += findWord(position, wordChars);
        }
        System.out.println(result);


    }

    public static List<Position> findFirstChar(char c) {
        List<Position> list = new LinkedList<>();
//        int maxI = word.length();
//        int maxJ = word.length();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == c) {
                    list.add(new Position(i, j));
                }
            }
        }
        return list;

    }

    public static int findWord(Position position, char[] wordChars) {
        int count = 0;
        boolean isRight = true;
        boolean isDown = true;
        boolean isRightDown = true;

        //down
        for (int i = 0; i < wordChars.length; i++) {
            int x = i + position.x;
            if (x >= m) {
                isDown = false;
                break;
            }
            if (wordChars[i] == matrix[x][position.y]) {
                continue;
            }
            isDown = false;
        }
        if (isDown) {
            count++;
        }

        //right
        for (int i = 0; i < wordChars.length; i++) {
            int y = i + position.y;
            if (y >= n) {
                isRight = false;
                break;
            }
            if (wordChars[i] == matrix[position.x][y]) {
                continue;
            }
            isRight = false;
        }
        if (isRight) {
            count++;
        }

        //down-right
        for (int i = 0; i < wordChars.length; i++) {
            int x = i + position.x;
            int y = i + position.y;

            if (x >= m) {
                isRightDown = false;
                break;
            }
            if (y >= n) {
                isRightDown = false;
                break;
            }
            if (wordChars[i] == matrix[i + position.x][i + position.y]) {
                continue;
            }
            isRightDown = false;
        }
        if (isRightDown) {
            count++;
        }
        return count;

    }

    public static class Position {
        int x, y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}
