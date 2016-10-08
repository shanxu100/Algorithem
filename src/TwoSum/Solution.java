package TwoSum;

import java.util.HashMap;

/**
 * Created by lianglitu on 16/10/2.
 */
public class Solution {
    public int[] twoSum(int[] nums, int target) {

        HashMap<Integer ,Integer> map=new HashMap();

        for(int i=0;i<nums.length;i++)
        {
            map.put(nums[i],i);
        }

        System.out.println("map size: "+map.size());

        for(int i=0;i<nums.length-1;i++)
        {
            int compelement=target-nums[i];
            Integer index;

            if(map.containsKey(compelement)&& (index=map.get(compelement))!=i) {
                return new int[]{i, (int) index};
            }
        }


        /**
         * 通过指定key获取对应的value
         * 如果key值不存在，则返回null；
         * 如果key存在但是value为null，则返回null；
         * 如果key存在并且value不为null，则返回value的值；
         * 恰当的使用时机：已知key值存在（并且value不为null）的情况下，想要通过key找到value的时候
         */
        //map.get();
        /**
         * 恰当的使用时机：当要判断map中是否包含了键key的时候
         * 如果包含key但是对应的value值为null，则返回ture
         * 如果包含key并且对应的value值存在，则返回value
         * 如果不包含key，则返回false
         */
        //map.containsKey();

        /**
         * 以上同理
         */
        //map.containsValue();
        return null;

    }



    public static void main(String[] args)
    {
        Solution s=new Solution();
        int[] nums=new int[]{2,1,2};
        int [] result=s.twoSum(nums,4);
        for(int i :result)
        {
            System.out.println(i);
        }
    }
}
