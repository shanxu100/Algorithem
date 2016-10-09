package RemoveDuplicatesfromSortedArray;

/**
 * Created by guan on 10/9/16.
 */
public class Solution {
    public int removeDuplicates(int[] nums) {
        int result = 1;

        for (int i = 1, j = 1; i < nums.length; ) {
            if (nums[i - 1] != nums[i]) {
                nums[j]=nums[i];
                i++;
                j++;
                result++;
            } else {
                i++;
            }
        }

        for (int i=0;i<result;i++)
        {
            System.out.print(nums[i]+"\t");
        }
        System.out.println();

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.print(solution.removeDuplicates(new int[]{1, 1, 2}));
    }

}
