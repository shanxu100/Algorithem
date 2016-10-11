package Permutations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by lianglitu on 16/10/11.
 */
public class Solution {


    public List<List<Integer>> permute(int[] nums) {

        int n = 0;
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> prefix = new ArrayList<>();
        LinkedList<Integer> remain = new LinkedList<>();
        for (int i : nums) {
            remain.add(i);
        }

        tracing(n, prefix, remain, res);

        return res;

    }

    public void tracing(int n, List<Integer> prefix, List<Integer> remain,
                        List<List<Integer>> res) {
        if (remain.size() == 0) {
            res.add(prefix);
            return;
        }

        for (int i = 0; i < remain.size(); i++) {
            prefix.add(remain.get(i));
            tracing(n + 1, prefix, remain, res);
        }


    }


    public static void main(String[] args) {

    }
}
