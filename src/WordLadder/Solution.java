package WordLadder;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by guan on 10/15/16.
 */
public class Solution {

    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {

        HashMap<String,Integer> map = new HashMap(wordList.size());
        HashMap tmp = new HashMap(wordList.size());

        /**
         * 要修改
         */
        /**  1.HashMap 类映射不保证顺序；某些映射可明确保证其顺序: TreeMap 类
         *   2.在遍历Map过程中,不能用map.put(key,newVal),map.remove(key)来修改和删除元素，
         *   会引发 并发修改异常,可以通过迭代器的remove()：
         *   从迭代器指向的 collection 中移除当前迭代元素
         *   来达到删除访问中的元素的目的。
         *   */
        for (String w : wordList) {
            if (oneStep(endWord,w))
            {
                map.put(w,1);
                wordList.remove(w);
            }
        }

        if (map.size()==0)
            return 0;

        for (String w:map.keySet())
        {
            System.out.println(w);
            map.put(w,1);
        }

        return 0;


    }

    public boolean oneStep(String w1, String w2) {
        int count = 0;
        int i = 0, len = w1.length();

        while (i < len) {
            if (w1.charAt(i) == w2.charAt(i))
                count++;
            i++;
        }

        if (count == 1)
            return true;
        else
            return false;
    }


    public static void main(String[] args) {
        Solution solution=new Solution();
        HashSet set=new HashSet<String>();
        set.add("hot");
        set.add("dot");
        set.add("dog");
        set.add("lot");
        set.add("log");
        solution.ladderLength("hit","cog",set);
    }
}
