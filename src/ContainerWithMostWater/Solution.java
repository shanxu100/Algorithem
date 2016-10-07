package ContainerWithMostWater;

/**
 * Created by lianglitu on 16/10/6.
 */
public class Solution {

    public int maxArea(int[] height) {

        int count=0;
        int line=0;

        for(int i=0;i<height.length-1;i++)
        {
            int tmpmini=height[i]<height[i+1]?height[i]:height[i+1];

            count=count>tmpmini?count:tmpmini;

            if (tmpmini>count)
            {
                count=tmpmini;
                line=i+1;
            }
        }
        return line;

    }


    public static void main(String[] args)
    {
        Solution s=new Solution();
        System.out.println(s.maxArea());
    }
}
