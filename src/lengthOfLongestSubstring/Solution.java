package lengthOfLongestSubstring;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by lianglitu on 16/10/2.
 * <p>
 * Solved
 */
public class Solution {

    /**
     * 效率最低
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        char[] c = s.toCharArray();
        HashMap<Character, Character> map = new HashMap<Character, Character>();

        int len = 0;


        for (int i = 0; i < c.length; i++) {
            map.clear();
            map.put(c[i], c[i]);

            int j = i + 1;
            for (; j < c.length; j++) {

                if (!map.containsKey(c[j])) {
                    map.put(c[j], c[j]);
                } else {

                    break;
                }

            }

            int t_len = map.size();
            len = t_len > len ? t_len : len;

        }
        return len;

    }

    /**
     * 58ms
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring_2(String s) {
        char[] c = s.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();
        int count = 0;

        for (int i = 0, j = 0; j < s.length(); ) {
            if (!map.containsKey(c[j])) {
                map.put(c[j], j);
                j++;

            } else {
                map.remove(c[i]);
                i++;
            }
            count = count > map.size() ? count : map.size();
        }
        return count;


    }

    /**
     * 50+ms
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring_3(String s) {
        if (s.equals(""))
            return 0;

        char[] c = s.toCharArray();
        Map<Character,Integer> map=new HashMap<>();
        int count = 1;
        int tmp=0;
        map.put(c[0],0);


        for (int i = 1,j=0; i < s.length(); i++) {

            if (map.containsKey(c[i]) && (tmp=map.get(c[i]))>=j)
            {
                j=tmp+1;
            }

            map.put(c[i],i);
            count=(i-j+1)>count?(i-j+1):count;

        }
        return count;


    }


    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.lengthOfLongestSubstring_3(""));
    }


}
