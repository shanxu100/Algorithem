package GroupAnagrams;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by guan on 10/11/16.
 *
 * Not Solved
 */
public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length==0)
        {
            return null;
        }

        List<List<String>> res=new ArrayList<>();

        List<String> li=new ArrayList<String>();
        li.add(strs[0]);
        res.add(li);

        for (String s:strs)
        {
            for (List<String> list:res )
            {
                for (char c:s.toCharArray())
                {
                    if (!(list.get(0)).contains(c+""))
                    {
                        List<String> l=new ArrayList<String>();
                        l.add(s);
                        res.add(l);
                    }
                }
            }
        }


        return res;
    }

    public static void main(String[] args)
    {

        Solution solution=new Solution();
        List<List<String>> res=solution.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
        //solution.groupAnagrams(new String[]{});

        for (List<String> list : res) {
            for (String i : list) {
                System.out.print(i + "\t");
            }
            System.out.println();
        }
    }

}
