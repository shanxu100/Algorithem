package ReverseInteger;

/**
 * Created by lianglitu on 16/10/6.
 *
 * Not Solved
 */
public class Solution {
    public int reverse(int x) {


        //return Integer.reverse(x);

        boolean flag=x>0?true:false;

        char[] cx=Integer.toString(Math.abs(x)).toCharArray();
        char[] tmp=new char[cx.length];

        for (int i=0, j=cx.length-1;j>=0;j--,i++)
        {
            tmp[i]=cx[j];
        }


        long result=Long.parseLong(String.valueOf(tmp).trim());

        if (flag)
        {
            return (int)result;
        }else
        {
            return (int) (0-result);
        }



    }

    public static void main(String[] args)
    {
        Solution solution=new Solution();
        System.out.println(Integer.MAX_VALUE);
        //System.out.println(solution.reverse(9646324351));
    }
}
