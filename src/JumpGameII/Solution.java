package JumpGameII;

import java.util.Arrays;

/**
 * Solved
 * <p>
 * Created by guan on 10/10/16.
 */
public class Solution {

    /**
     * AC
     *
     * @param nums
     * @return
     */
    public int jump(int[] nums) {
        int length = nums.length;
        int tmp;
        int[] steps = new int[length];
        steps[0] = 0;
        for (int i = 0, j = 1; i < length && j < length; i++) {
            tmp = nums[i] + i < length - 1 ? nums[i] + i : length - 1;

            while (j <= tmp) {
                steps[j] = steps[i] + 1;
                j++;
            }

        }
        return steps[length - 1];
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
     *
     * @param nums
     * @return
     */
    public int jump3(int[] nums) {
        int len;
        if ((len = nums.length) == 1)
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


    /**
     * 超时
     *
     * @param nums
     * @return
     */
    public int jump4(int[] nums) {
        int length = nums.length;
        int steps[] = new int[length];
        for (int i = 0; i < length; i++) {
            steps[i] = Integer.MAX_VALUE - 1000;
        }
        steps[0] = 0;

        for (int i = 0; i < length - 1; i++) {

            int j = 1;
            while (j <= nums[i] && i + j < length) {
                steps[i + j] = steps[i] + 1 < steps[i + j] ? steps[i] + 1 : steps[i + j];
                j++;
            }
        }
        return steps[length - 1];

    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println("\n" + solution.jump(new int[]{2, 3, 1, 1, 1, 1, 4}));

    }

}
