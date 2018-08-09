package practice;

import java.util.Arrays;
import java.util.logging.Level;

/**
 * @author Guan
 * @date Created on 2018/3/23
 */
public class Sort {
    public static int n = 20;
    public static int[] data = new int[n];

    public static void main(String[] args) {
        for (int i = 0; i < data.length; i++) {
            data[i] = (int) (Math.random() * 10);
            System.out.print(data[i]);
        }
        System.out.println();
//        maopaoSort(data);
        quickSort(data, 0, 9);

        output(data);

    }

    /**
     * 冒泡排序
     *
     * @param data
     */
    public static void maopaoSort(int[] data) {

        for (int i = data.length - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (data[j] > data[j + 1]) {
                    swap(data, j, j + 1);
                }
            }
        }

    }


    /**
     * 快速排序
     */
    private static void quickSort(int[] a, int l, int r) {
        if (l >= r) {
            return;
        }

        int mid = a[l], left = l, right = r;
        while (left < right) {
            while (left < right && a[right] > mid) {
                right--;
            }
            a[left] = a[right];
            while (left < right && a[left] < mid) {
                left++;
            }
            a[right] = a[left];
        }
        a[left] = mid;
        quickSort(data, l, left - 1);
        quickSort(data, left + 1, r);

    }


    //============Helper================
    private static void swap(int[] data, int index1, int index2) {
        int tmp = data[index1];
        data[index1] = data[index2];
        data[index2] = tmp;
    }

    private static void output(int[] data) {
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println();

    }

    boolean isHuiwen(char[] chars) {
        for (int i = 0; i < chars.length / 2; i++) {
            if (chars[i] != chars[chars.length - 1 - i]) {
                return false;
            }
        }
        return true;
    }


}
