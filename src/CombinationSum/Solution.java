package CombinationSum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * Created by guan on 10/9/16.
 */
public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        HashSet<Integer> set = new HashSet<>();
        List<List<Integer>> result = new ArrayList<>();
        for (int i : candidates) {
            if (i > target) {
                continue;
            }
            set.add(i);
        }

        for (int i = 0; i < candidates.length; i++) {

        }

        return null;

    }


    public static void main(String[] args) {

    }
}
