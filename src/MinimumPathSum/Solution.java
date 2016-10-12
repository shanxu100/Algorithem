package MinimumPathSum;

/**
 * Created by guan on 10/12/16.
 */
public class Solution {
    public int minPathSum(int[][] grid) {

        if (grid.length == 0||grid[0].length==0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        int[] min = new int[n];
        int tmp;

        min[0] = grid[0][0];
        for (int i = 1; i < n; i++) {
            min[i] = min[i-1] + grid[0][i];
        }

        for (int i = 1; i < m; i++) {
            min[0] += grid[i][0];
            for (int j = 1; j < n; j++) {
                min[j]=(min[j]<min[j-1]?min[j]:min[j-1])+grid[i][j];
            }
        }

        return min[n-1];


    }

    public static void main(String[] args) {

        Solution solution=new Solution();
        System.out.println(solution.minPathSum(new int[][]{{1,3,5},{7,9,2},{4,6,8}}));
    }

}
