package nowcoder.practice.mark;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * https://www.nowcoder.com/practice/0147cbd790724bc9ae0b779aaf7c5b50?tpId=85&tqId=29850&tPage=2&rp=2&ru=/ta/2017test&qru=/ta/2017test/question-ranking
 * @author Guan
 */
public class Sequence {

    public static void main(String[] args) {
        int n;
        Scanner in = new Scanner(System.in);
//        ArrayList<Integer> list = new ArrayList<>(1003);
        int[] arr = new int[51];
        while (in.hasNextInt()) {
            n = in.nextInt();
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }
            getSequence(n, arr);
        }
    }

    public static void getSequence(int n, int[] arr) {
        int start = 0;
        int end = n - 1;
        int count = 0;
        while (start < end) {
            if (arr[start] == arr[end]) {
                start++;
                end--;
                continue;
            }

            count++;
            if (arr[start] < arr[end]) {
                start++;
                arr[start] += arr[start - 1];
            } else {
                end--;
                arr[end] += arr[end + 1];
            }
        }
        System.out.println(count);

    }

}
