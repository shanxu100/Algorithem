package MaximumSubarray;

/**
 * Created by guan on 10/9/16.
 * <p>
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


    public int maxSubArray2(int[] nums) {

        if (nums.length==0)
            return 0;

        int[] max = new int[nums.length];
        int maxsum = nums[0];
        max[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            /**
             * max[i]表示，以nums[i]结尾的子串的和的最大值
             */
            max[i] = (max[i - 1] + nums[i]) > nums[i] ? (max[i - 1] + nums[i]) : nums[i];
            maxsum = max[i] > maxsum ? max[i] : maxsum;
        }
        return maxsum;

    }

    public static void main(String[] args) {

        Solution solution = new Solution();
        System.out.println(solution.maxSubArray2(new int[]{1}));
    }
}
