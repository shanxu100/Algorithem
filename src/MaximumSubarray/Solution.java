package MaximumSubarray;

/**
 * Created by guan on 10/9/16.
 *
 * Not Solved
 */
public class Solution {
    public int maxSubArray(int[] nums) {

        /**
         * 超时
         */
        int[][] matrix = new int[nums.length][nums.length];
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            matrix[i][i] = nums[i];
            max = matrix[i][i] > max ? matrix[i][i] : max;
        }

//        for (int[] t:matrix)
//        {
//            for (int i:t)
//            {
//                System.out.print(i+"\t");
//            }
//            System.out.println("**********************");
//        }

        for (int count = 1; count < nums.length; count++) {
            int i = 0, j = count;
            while (j < nums.length) {
                matrix[i][j] = matrix[i][j - 1] + matrix[j][j];
                max = matrix[i][j] > max ? matrix[i][j] : max;
                i++;
                j++;
            }

//           for (int[] t:matrix)
//           {
//               for (int k:t)
//               {
//                   System.out.print(k+"\t");
//               }
//               System.out.println();
//           }
//           System.out.println("=================================");


        }

        return max;

    }

    public static void main(String[] args) {

        Solution solution = new Solution();
        System.out.println(solution.maxSubArray(new int[]{}));
    }
}
