package SearchInsertPosition;

/**
 * Created by guan on 10/9/16.
 */
public class Solution {
    public int searchInsert(int[] nums, int target) {

        int length = nums.length;
        int i = 0, j = length - 1;
        int tmp = 0;
        int result=0;

        while (i < j) {
            tmp = (i + j) / 2;
            if (nums[tmp]==target)
            {
                return tmp;
            }
            if (nums[tmp]>target)
            {
                j=tmp-1;
            }else {
                i=tmp+1;
            }
        }

        if(nums[i]>=target)
        {
            return i;
        }else
        {
            return i+1;
        }


    }


    public static void main(String[] args) {
        Solution solution=new Solution();
        System.out.println(solution.searchInsert(new int[]{1,3,5,6,9},10));
    }

}
