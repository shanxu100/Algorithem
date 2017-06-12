package ContainerWithMostWater;

/**
 * 水箱问题
 * <p>
 * Created by lianglitu on 16/10/6.
 * <p>
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
            mini = Math.min(height[i], height[j]);

            count = count > (mini * (j - i)) ? count : (mini * (j - i));

            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }


        }

        return count;


    }

    public int maxArea2(int[] height) {
        //int len = height.length;

        int result = 0;
        int tmp;

        for (int i = 0, j = height.length - 1; i < j; ) {
            tmp = (height[i] < height[j] ? height[i] : height[j]) * (j - i);
            result = result > tmp ? result : tmp;

            if (height[i]<height[j])
            {
                i++;
            }else {
                j--;
            }
        }

        return result;
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.maxArea2(new int[]{1, 3, 2, 5, 25, 24, 5}));
    }
}
