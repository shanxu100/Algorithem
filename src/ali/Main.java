package ali;

/**
 * @author Guan
 * @date Created on 2018/8/17
 */

import java.util.Arrays;
import java.util.Scanner;

public class Main {

/** 请完成下面这个函数，实现题目要求的功能 **/
    /** 当然，你也可以不按照这个模板来作答，完全按照自己的想法来 ^-^  **/
    static int maxWorkinghourGap(int[] workinghours) {

        Arrays.sort(workinghours);
        int max=0;
        for (int i=1;i<workinghours.length;i++){
            int temp=workinghours[i]-workinghours[i-1];
            max=temp>max?temp:max;
        }
        return max;

    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String inputData;
        try {
            inputData = in.nextLine();
        } catch (Exception e) {
            return;
        }

        String[] strs = inputData.split(",");
        int[] workinghours = new int[strs.length];
        for (int i=0;i<strs.length;i++) {
            workinghours[i] = Integer.parseInt(strs[i]);
        }

        int res = maxWorkinghourGap(workinghours);
        System.out.println(String.valueOf(res));

    }
}
