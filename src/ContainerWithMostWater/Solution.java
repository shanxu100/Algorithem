package ContainerWithMostWater;

/**
 * Created by lianglitu on 16/10/6.
 *
 * Solved
 */
public class Solution {

    public int maxArea(int[] height) {


        int i = 0, j = height.length - 1;
        int count = 0, mini = 0;

        while (i < j) {
            /**
             * 就是这一句
             */
            mini = height[i] < height[j] ? height[i] : height[j];
            mini=Math.min(height[i],height[j]);

            count = count > (mini * (j - i)) ? count : (mini * (j - i));

            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }


        }

        return count;


    }


    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.maxArea(new int[]{1, 1}));
    }
}
