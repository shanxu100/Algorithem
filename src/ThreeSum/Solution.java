package ThreeSum;

import javax.lang.model.type.ArrayType;
import java.util.*;

/**
 * Created by Guan on 2016/10/8.
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

        HashMap<Integer, Integer> map = new HashMap<>();
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        if (nums.length < 3) {
            return result;
        }

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }


        Set<List<Integer>> set = new HashSet<>();
        int need = 0;

        int start = 0, end = nums.length - 1;

        while (start < end) {
            need = 0 - nums[start] - nums[end];
        }


        for (int i = 0; i < nums.length && nums[i] <= 0; i++) {

            for (int j = nums.length - 1; j > i && nums[j] >= 0; j--) {

                int tmp = 0 - nums[i] - nums[j];
                if (tmp < nums[i] || tmp > nums[j] || !map.containsKey(tmp)) {
                    continue;
                }

                need = map.get(tmp);
                if (need != i && need != j) {
                    List<Integer> tmp_list = new ArrayList<>();
                    tmp_list.clear();
                    tmp_list.add(nums[i]);
                    tmp_list.add(tmp);
                    tmp_list.add(nums[j]);
                    set.add(tmp_list);
                }
            }
        }
        for (List list : set) {
            result.add(list);
        }

        return result;


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
                    List<Integer> tmp_list = new ArrayList<>();
                    tmp_list.add(nums[start]);
                    tmp_list.add(need);
                    tmp_list.add(nums[end]);
                    set.add(tmp_list);

                }
                end--;


            }
        }

        for (List list : set) {
            result.add(list);
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
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        l1.add(1);
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
        List<List<Integer>> result = solution.try3(new int[]{-2,0,1,1,2});
        //List<List<Integer>> result = solution.threeSum(new int[]{0, 0 ,0});
        //solution.threeSum(new int[]{0, 0});
        for (int i = 0; i < result.size(); i++) {
            for (int j = 0; j < result.get(i).size(); j++) {
                System.out.print(result.get(i).get(j) + "\t");
            }
            System.out.print("\n");
        }


        //solution.testSet();


    }

}
