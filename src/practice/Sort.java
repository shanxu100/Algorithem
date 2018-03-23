package practice;

/**
 * @author Guan
 * @date Created on 2018/3/23
 */
public class Sort {
    public static int n = 10;
    public static int[] data = new int[n];

    public static void main(String[] args) {
        for (int i = 0; i < data.length; i++) {
            data[i] = (int) (Math.random() * 10);
            System.out.print(data[i]);
        }
        System.out.println();
//        maopaoSort(data);
        quickSort(data,0,9);

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
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i]);
        }
        System.out.println();

    }

    private static void swap(int[] data, int index1, int index2) {
        int tmp = data[index1];
        data[index1] = data[index2];
        data[index2] = tmp;
    }

    //快速排序
    public static void quickSort(int[] a, int low, int high) {
        //递归快速排序
        int pivotLoc = 0;//中心点
        if (low < high) {
            pivotLoc = partitionLoc(a, low, high);
            quickSort(a, low, pivotLoc-1);
            quickSort(a, pivotLoc+1, high);
        }
    }

    //获取到a的下标 low ~ high 中, a[low]的应该放的位置, 即左边的数 < a[low] 右边的数 > a[low]
    private static int partitionLoc(int[] a, int low, int high) {
        a[0] = a[low];
        while (low < high) {
            while (low < high && a[high] >= a[0]) {
                high--;
            }
            a[low] = a[high];
            while (low < high && a[low] <= a[0]) {
                low++;
            }
            a[high] = a[low];
        }
        a[low] = a[0];
        return low;
    }
}
