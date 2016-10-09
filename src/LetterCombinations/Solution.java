package LetterCombinations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by guan on 10/9/16.
 *
 * Not Solved
 */
public class Solution {
    public List<String> letterCombinations(String digits) {
        char[] dig=digits.toCharArray();
        char[] res=new char[digits.length()];
        List<char[]> chars=new ArrayList<>();


        for (char c:dig)
        {
            System.out.println((char)(c+47));
        }



        return  null;

    }

    public static void main(String[] args)
    {
        Solution solution=new Solution();
        solution.letterCombinations("2");
    }
}
