package lengthOfLongestSubstring;

import java.util.HashMap;

/**
 * Created by lianglitu on 16/10/2.
 */
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        char[] c=s.toCharArray();
        HashMap<Character,Character> map=new HashMap<Character, Character>();

        int len=0;


        for(int i=0;i<c.length;i++)
        {
            map.clear();
            map.put(c[i],c[i]);

            int j=i+1;
            for( ;j<c.length;j++) {

                if (!map.containsKey(c[j]))
                {
                    map.put(c[j],c[j]);
                }else
                {

                    break;
                }

            }

            int t_len=map.size();
            len=t_len>len?t_len:len;

        }
        return len;

    }

    public static void main(String[] args)
    {
        Solution s=new Solution();
        System.out.println(s.lengthOfLongestSubstring("abcabcbb"));
    }



}
