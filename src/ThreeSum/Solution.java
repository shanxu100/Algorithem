package ThreeSum;

import javax.lang.model.type.ArrayType;
import java.util.*;

/**
 * Created by Guan on 2016/10/8.
 *
 * Solved
 */
public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        HashMap<Integer, Integer> map = new HashMap<>();
        int need = 0;
        int need2 = 0;
        List<List<Integer>> result = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();

        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }


        for (int i = 0; i < nums.length - 2; i++) {
            need = 0 - nums[i];
            /////////////////////////
            for (int j = i + 1; j < nums.length - 1; j++) {
                need2 = need - nums[j];

                if (map.containsKey(need2) && map.get(need2) > i && map.get(need2) > j) {
                    List<Integer> tmp = new ArrayList<>();
                    tmp.add(nums[i]);
                    tmp.add(nums[j]);
                    tmp.add(need2);
                    //System.out.println(nums[i]+"\t"+nums[j]+"\t"+need2);

                    set.add(tmp);
                }
            }

        }

        for (List list : set) {
            result.add(list);
        }


        return result;


    }

    public List<List<Integer>> try2(int[] nums) {

        Arrays.sort(nums);
        List<List<Integer>> res = new LinkedList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
                int lo = i + 1, hi = nums.length - 1, sum = 0 - nums[i];
                while (lo < hi) {
                    if (nums[lo] + nums[hi] == sum) {
                        res.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
                        while (lo < hi && nums[lo] == nums[lo + 1]) lo++;
                        while (lo < hi && nums[hi] == nums[hi - 1]) hi--;
                        lo++;
                        hi--;
                    } else if (nums[lo] + nums[hi] < sum) lo++;
                    else hi--;
                }
            }
        }
        return res;


    }

    public List<List<Integer>> try3(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        List<List<Integer>> result = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();
        int length = nums.length;

        if (length < 3) {
            return result;
        }

        Arrays.sort(nums);

        for (int i = 0; i < length; i++) {

            map.put(nums[i], i);
        }


        int need = 0;
        int index = 0;


        for (int i = 0; i < length - 2; i++) {

            int start = i, end = length - 1;

            while (start < end) {

                need = 0 - nums[start] - nums[end];

                if (need < nums[start] || need > nums[end] || !map.containsKey(need)) {

                    end--;
                    continue;

                }

                index = map.get(need);

                if ((index != start && index != end)) {
                    /**
                     * Arrays.asList()方法要比每次new ArrayList<>() 快.
                     */
                    set.add(Arrays.asList(nums[start], need, nums[end]));

                }
                end--;


            }
        }

        for (List list : set) {
            result.add(list);
        }

        return result;


    }


    public List<List<Integer>> try4(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i - 1] == nums[i]) {
                continue;
            }
            int start = i + 1, end = nums.length - 1;
            int sum = 0 - nums[i];

            while (start < end) {
                if (nums[start] + nums[end] == sum) {
                    result.add(Arrays.asList(nums[i], nums[start], nums[end]));
                    while (start < end && nums[start + 1] == nums[start]) {
                        start++;
                    }
                    while (start < end && nums[end - 1] == nums[end]) {
                        end--;
                    }
                    start++;
                    end--;

                } else if (start < end && nums[start] + nums[end] > sum) {
                    end--;
                } else {
                    start++;
                }

            }
        }

        return result;

    }


    public void testList() {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            list.add(i);
        }

        list.clear();
        System.out.println("clear()方法：list的大小：" + list.size());

        list.add(99);
        for (int i : list) {
            System.out.println("元素：" + i);
        }
    }

    public void testSet() {
        /**
         * Set中的元素不可以重复
         * 不仅基本数据类型适用，其他的数据类型也适用。
         * 比如：两个List，分别含有两个元素“1”和“2”。
         * 这两个List通过“==”比较结果为false，但在Set中就属于相同的元素。
         */
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();

        l1.add(1);
        l1.add(2);

        l2.add(1);
        l2.add(2);

        Set<List> set = new HashSet<>();
        set.add(l1);
        set.add(l2);
        if (l1 == l2) {
            System.out.println("==");
        } else {
            System.out.println("!=");
        }

        System.out.println(set.size());
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<Integer>> result = solution.try4(new int[]{0,0,0});

        for (int i = 0; i < result.size(); i++) {
            for (int j = 0; j < result.get(i).size(); j++) {
                System.out.print(result.get(i).get(j) + "\t");
            }
            System.out.print("\n");
        }


        solution.testSet();


    }

}
