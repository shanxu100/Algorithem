package PermutationsII;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Solved
 *
 * Created by guan on 10/11/16.
 *
 * 类型：全排列
 * 前提：元素可能出现重复，即会出现排列结果重复的情况。
 * 但是最终结果要排除这些重复的情况。
 */
public class Solution {

    static int tmp = 0;

    public List<List<Integer>> permuteUnique(int[] nums) {

        int start = 0, end = nums.length - 1;
        List<Integer> prefix = new ArrayList<Integer>();
        List<List<Integer>> res = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();

        tracing(start, end, prefix, nums, res, set);

        return res;

    }

    public static void tracing(int start, int end, List<Integer> prefix, int[] nums,
                               List<List<Integer>> res, Set<List<Integer>> set) {

        if (start > end) {
            if (!set.contains(prefix)) {
                res.add(prefix);
                set.add(prefix);
            }
            return;
        }

        for (int i = start; i <= end; i++) {
            tmp = nums[i];
            nums[i] = nums[start];
            nums[start] = tmp;

            List<Integer> _prefix = new ArrayList<>(prefix);
            _prefix.add(nums[start]);
            tracing(start + 1, end, _prefix, nums, res, set);

            tmp = nums[i];
            nums[i] = nums[start];
            nums[start] = tmp;

        }

    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<Integer>> res = solution.permuteUnique(new int[]{});

        for (List<Integer> list : res) {
            for (int i : list) {
                System.out.print(i + "\t");
            }
            System.out.println();
        }

    }

}
