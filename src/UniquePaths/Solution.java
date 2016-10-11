package UniquePaths;

/**
 * Created by guan on 10/11/16.
 */
public class Solution {

    public int uniquePaths(int m, int n) {

        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                nums[j]=nums[j-1]+nums[j];
            }
        }

        return nums[n-1];


    }

    public static void main(String[] args) {

        Solution solution=new Solution();
        System.out.println(solution.uniquePaths(3,7));
    }

}
