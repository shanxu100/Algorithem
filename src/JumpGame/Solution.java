package JumpGame;

/**
 * Solved
 *
 * Created by lianglitu on 16/10/10.
 */
public class Solution {
    /**
     * 超时
     *
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {

        int len = nums.length;

        boolean[] res = new boolean[len];


        res[len - 1] = true;

//        for (boolean b : res) {
//            System.out.print(b + "\t");
//        }

        for (int i = len - 2; i >= 0; i--) {

            for (int j = i + 1, k = 0; j < len && k < nums[i]; j++, k++) {
                if (res[j]) {
                    res[i] = true;
                }
            }
        }

        return res[0];
    }

    /**
     * AC
     *
     * @param nums
     * @return
     */
    public boolean canJump2(int[] nums) {

        int len = nums.length;
        int canstep = nums[0];
        int location = 0;

        if (len == 1)
            return true;

        while (location < len && canstep > 0) {
            canstep = nums[location] >= canstep ? nums[location] + 1 : canstep;
            canstep--;
            location++;
        }


        return location == len;

    }


    public static void main(String[] args) {

        Solution solution = new Solution();
        System.out.println(solution.canJump2(new int[]{2, 3, 1, 1, 4}));
    }
}
