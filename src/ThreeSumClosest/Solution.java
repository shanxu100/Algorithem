package ThreeSumClosest;

import java.util.Arrays;

/**
 *
 * Created by guan on 10/9/16.
 *
 * Solved
 */
public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int result=0;

        int sum = 0;
        int start = 0, end = 0;

        int tmp = Integer.MAX_VALUE;
        int sub = 0;

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i - 1] == nums[i]) {
                continue;
            }
            start = i + 1;
            end = nums.length - 1;
            sum = target - nums[i];

            while (start < end) {

                sub = nums[start] + nums[end] - sum;
                if (sub == 0) {
                    return target;
                }

                if ((sub) * (sub) < tmp) {
                    tmp = sub * sub;
                    result = nums[i] + nums[start] + nums[end];
                }

                if (nums[start] + nums[end] < sum) {
                    start++;
                } else {
                    end--;
                }

            }

        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.threeSumClosest(new int[]{-1,2,1,-4},1));
    }

}
