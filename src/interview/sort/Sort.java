package interview.sort;

/**
 * @author Guan
 * @date Created on 2018/2/27
 */
public class Sort {
    public static void main(String[] args) {
        int[] L = new int[]{5, 10, 25, 1, 8, 16};
//        int[] L = new int[]{5};

//        BubbleSort(L);
//        SelectionSort(L);
        InsertionSort(L);
        PrintResult(L);

    }

    public static void BubbleSort(int[] L) {
        System.out.println("冒泡排序");

        for (int j = L.length - 1; j > 0; j--) {
            for (int i = 1; i <= j; i++) {
                if (L[i] < L[i - 1]) {
                    Swap(L, i, i - 1);
                }
            }
        }

    }

    public static void SelectionSort(int[] L) {
        System.out.println("选择排序");
        int index;
        for (int i = 0; i < L.length; i++) {
            index = i;
            for (int j = i + 1; j < L.length; j++) {
                if (L[j] < L[index]) {
                    index = j;
                }
            }
            Swap(L, i, index);
        }

    }

    public static void InsertionSort(int[] L) {
        System.out.println("插入排序");

        int tmp;
        for (int i = 1; i < L.length; i++) {
            if (L[i] < L[i - 1]) {

            }
        }

    }


    //=====================Helper==========================
    public static void PrintResult(int[] L) {
        for (int i : L) {
            System.out.print(i + "\t");
        }
        System.out.println();
    }

    public static void Swap(int[] L, int i, int j) {
        int tmp = L[i];
        L[i] = L[j];
        L[j] = tmp;
    }

}
