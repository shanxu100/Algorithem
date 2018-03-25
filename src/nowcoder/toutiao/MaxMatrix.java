package nowcoder.toutiao;

/**
 * @author Guan
 * @date Created on 2018/3/24
 */
public class MaxMatrix {


    public static int max(int[][] matrix, int n, int m) {
        int base_sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                base_sum += matrix[i][j];
            }
        }
        int result = 0;
        for (int i = 0; i + n < matrix.length; i++) {
            if (i > 0) {
                for (int y = 0; y < m; y++) {
                    base_sum += matrix[i + n][y] - matrix[i - 1][y];
                }
            }
            int real_sum = base_sum;
            if (real_sum > result) {
                result = real_sum;
            }
            for (int j = 0; j + m < matrix.length; j++) {
                for (int x = i; x < i + n; x++) {
                    real_sum += matrix[x][j + m] - matrix[x][j - 1];
                }
                if (real_sum > result) {
                    result = real_sum;
                }
            }
        }
        return result;

    }
}
