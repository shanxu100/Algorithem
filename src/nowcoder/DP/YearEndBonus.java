package nowcoder.DP;

/**
 * @author Guan
 * @date Created on 2018/8/17
 */
public class YearEndBonus {
    public int getMost(int[][] board) {
        // write code here
        //6*6
        int m = 6;
        int n = 6;

        for (int i = 1; i < m; i++) {
            board[0][i] += board[0][i - 1];
        }
        for (int i = 1; i < n; i++) {
            board[i][0] += board[i - 1][0];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                board[i][j] += Math.max(board[i - 1][j], board[i][j - 1]);
            }
        }
        return board[5][5];

    }

    public static void main(String[] args) {
        int[][] data = new int[][]{
                {426, 306, 641, 372, 477, 409},
                {223, 172, 327, 586, 363, 553},
                {292, 645, 248, 316, 711, 295},
                {127, 192, 495, 208, 547, 175},
                {131, 448, 178, 264, 207, 676},
                {655, 407, 309, 358, 246, 714}
        };
        System.out.println(new YearEndBonus().getMost(data));
    }

}
