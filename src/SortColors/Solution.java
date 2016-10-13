package SortColors;

import java.util.Arrays;

/**
 * Solved
 * Created by guan on 10/13/16.
 */
public class Solution {
    public void sortColors(int[] nums) {

        int a = 0, b = 0, c = 0;
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                a++;
            } else if (nums[i] == 1) {
                b++;
            } else {
                c++;
            }
        }

        while (count < a) {
            nums[count] = 0;
            count++;
        }
        while (count < a + b) {
            nums[count] = 1;
            count++;
        }
        while (count < a + b + c) {
            nums[count] = 2;
            count++;
        }

        System.out.print(Arrays.asList(nums));

    }

    /**
     * 双值针法
     * 未解决
     * @param nums
     */
    public static void sortColors2(int[] nums) {

        int start = 0, end = nums.length - 1;

        for (int i = 1; i < end; i = start > i ? start : i + 1) {
            if (nums[i] == 0) {
                nums[i] = nums[start];
                nums[start] = 0;
                start++;
                i--;
            } else if (nums[i] == 2) {
                nums[i] = nums[end];
                nums[end] = 2;
                end--;
                i--;
            }

        }


        System.out.print("");
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.sortColors2(new int[]{0, 0, 1, 1, 2, 2, 0, 0, 1});
    }
}
