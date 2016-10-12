package SetMatrixZeroes;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by guan on 10/12/16.
 */
public class Solution {
    public void setZeroes(int[][] matrix) {

        if (matrix.length == 0)
            return;

        int m = matrix.length;
        int n = matrix[0].length;

        Set<Integer> rowset = new HashSet<>();
        Set<Integer> columnset = new HashSet<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (matrix[i][j] == 0) {
                    rowset.add(i);
                    columnset.add(j);
                }
            }
        }

        for (int i : rowset) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = 0;
            }
        }

        for (int j : columnset) {
            for (int i = 0; i < m; i++) {
                matrix[i][j]=0;
            }
        }

        for (int[] i:matrix)
        {
            for (int j:i)
            {
                System.out.print(j+"\t");
            }
            System.out.println();
        }

    }

    public static void main(String[] args) {

        Solution solution=new Solution();
        solution.setZeroes(new int[][]{{}});
    }
}
