package JumpGameII;

import java.util.Arrays;

/**
 * Created by guan on 10/10/16.
 */
public class Solution {

    /**
     * O(N*N) 超时
     * @param nums
     * @return
     */
    public int jump(int[] nums) {

        int length=nums.length;
        int[][] matrix=new int[length][length];
        int[] min=new int[length];

        matrix[0][0]=0;
        for(int i=1;i<length;i++)
        {
            matrix[0][i]=Integer.MAX_VALUE;
            min[i]=Integer.MAX_VALUE;
        }

        for (int i=0;i<length;i++)
        {
            //matrix[i][i]=min[i];

            for (int j=i+1,k=0;k<nums[i]&&j<length;k++,j++)
            {
                matrix[i][j]=min[i]+1;
                min[j]=matrix[i][j]<min[j]?matrix[i][j]:min[j];
            }

        }

        for (int[] t:matrix)
        {
            for (int i:t)
            {
                System.out.print(i+"\t\t");
            }
            System.out.println();
        }

        for (int i:min)
        {
            System.out.print(i+"\t\t");
        }

        return min[length-1];


    }

    /**
     * 又超时
     * @param nums
     * @return
     */
    public int jump2(int[] nums){
        int len=nums.length,min=Integer.MAX_VALUE-1;
        int[] step=new int[len];

        step[len-1]=0;
        for (int i=len-2;i>=0;i--)
        {
            for (int j=i+1,k=0;j<len && k<nums[i];j++,k++)
            {
                min=step[j]<min?step[j]:min;
            }
            step[i]=1+min;
            min=Integer.MAX_VALUE-1;
        }
        System.out.println(Arrays.toString(step));
        return step[0];

    }
    public static void main(String[] args) {
        Solution solution=new Solution();
        System.out.println("\n"+solution.jump2(new int[]{1,2,0,1}));

    }

    /**
     * java里对于数组的处理有一个专门的工具类：java.util.Arrays
     这个类提供了5个功能：
     1，将数组转换成java.util.ArrayList类型；【asList()】
     2，数组的排序；【sort()】
     3，数组的二分查找；【binarySearch()】
     4，两个数组的比较；【equals()】
     5，给数组赋初值；【fill()】
     */
}
