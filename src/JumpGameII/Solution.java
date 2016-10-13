package JumpGameII;

import java.util.Arrays;

/**
 * Solved
 *
 * Created by guan on 10/10/16.
 */
public class Solution {

    /**
     * O(N*N) 超时
     *
     * @param nums
     * @return
     */
    public int jump(int[] nums) {

        int length = nums.length;
        int[][] matrix = new int[length][length];
        int[] min = new int[length];

        matrix[0][0] = 0;
        for (int i = 1; i < length; i++) {
            matrix[0][i] = Integer.MAX_VALUE;
            min[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < length; i++) {
            //matrix[i][i]=min[i];

            for (int j = i + 1, k = 0; k < nums[i] && j < length; k++, j++) {
                matrix[i][j] = min[i] + 1;
                min[j] = matrix[i][j] < min[j] ? matrix[i][j] : min[j];
            }

        }

        for (int[] t : matrix) {
            for (int i : t) {
                System.out.print(i + "\t\t");
            }
            System.out.println();
        }

        for (int i : min) {
            System.out.print(i + "\t\t");
        }

        return min[length - 1];


    }

    /**
     * 又超时
     *
     * @param nums
     * @return
     */
    public int jump2(int[] nums) {
        int len = nums.length, min = Integer.MAX_VALUE - 1;
        int[] step = new int[len];

        int tmp = len - 1;
        step[len - 1] = 0;
        for (int i = len - 2; i >= 0; i--) {
            for (int j = i + 1, k = 0; j < len && k < nums[i]; j++, k++) {
                min = step[j] < min ? step[j] : min;
            }
            step[i] = 1 + min;
            min = Integer.MAX_VALUE - 1;
        }
        System.out.println(Arrays.toString(step));
        return step[0];

    }


    /**
     * 终于不超时了
     * @param nums
     * @return
     */
    public int jump3(int[] nums) {
        int len ;
        if ((len=nums.length)==1)
            return 0;

        int[] steps = new int[len];
        steps[0] = 0;
        int tmp;


        for (int i = 0, j = 0; i < len && j < len; i++) {

            if ((tmp = nums[i] + i) > j) {
                while (j < tmp) {
                    steps[j + 1] = steps[i] + 1;
                    j++;
                    if (j == len - 1) {
                        return steps[j];
                    }
                }
            }

        }
        return steps[len - 1];
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println("\n" + solution.jump3(new int[]{0}));

    }

}
