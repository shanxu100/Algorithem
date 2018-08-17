package DP.example;

/**
 * 最长递增子序列
 * 两个方法:
 * 1、将原序列排序成一个新序列。两个序列求公共子序列。属于DP
 * 2、本例使用的方法O(nlogn)
 * <p>
 * 最笨的方法：O(N 2 )解法，且不去说
 *
 * @author Guan
 * @date Created on 2018/8/17
 */
public class AscentSequence {

    public static void main(String[] args) {
        int[] A = new int[]{2, 1, 5, 3, 6, 4, 8, 9, 7};
        System.out.println(new AscentSequence().findLongest(A, A.length));

        /**
         * 链接：https://www.nowcoder.com/questionTerminal/585d46a1447b4064b749f08c2ab9ce66
         来源：牛客网

         假设存在一个序列A[0..8] = 2 1 5 3 6 4 8 9 7，可以看出来它的LIS长度为5。
         下面一步一步试着找出它。
         我们定义一个序列B，然后令 i = 0 到 8 逐个考察这个序列。
         此外，我们用一个变量end来记录B中最后一个数的下标。

         首先，令B[0] = A[0] = 2，就是说当只有1一个数字2的时候，长度为1的LIS的最小末尾是2，这时end=0。

         然后，把A[2]有序地放到B里，令B[0] = 1，就是说长度为1的LIS的最小末尾是1，B[0]=2已经被淘汰了，这时 end =1。

         接着，A[2] = 5，A[2]>B[0]，所以令B[1]=A[2]=5，就是说长度为2的LIS的最小末尾是5，很容易理解吧。这时候B[0..1] = 1, 5， end ＝1。

         再来，A[3] = 3，它正好加在1,5之间，放在1的位置显然不合适，因为1小于3，长度为1的LIS最小末尾应该是1，这样很容易推知，长度为2的LIS最小末尾是3，于是可以把5淘汰掉，这时候B[0..1] = 1, 3， end = 2。

         继续，A[4] = 6，比B中最大的数3还要大 ，于是很容易可以推知B[2] = 6, 这时B[0..2] = 1, 3, 6， end = 2。

         A[5] = 4，它在3和6之间，于是我们就要把6替换掉，得到B[2] = 4，B[0..2] = 1, 3, 4， end 继续等于2。

         A[6] = 8，它很大，比4大。于是继续往B中追加，B[3] = 8， end 变成3了。

         A[7] = 9，得到B[4] = 9，此时B是1,3,4,8,9，end是4。

         最后一个, A[8] = 7，它在4和8之间，所以我们知道，最新的B[3] =7，B[0..4] = 1, 3, 4, 7, 9， end = 4。

         于是我们知道了LIS的长度为 end+1 = 5 。

         注意： 这个1,3,4,7,9不是LIS字符串，比如本题例的LIS应该是1,3,4,8,9，7代表的意思是存储4位长度LIS的最小末尾是7， 所以我们的B数组，是存储对应长度LIS的最小末尾。有了这个末尾，我们就可以一个一个地插入数据。虽然最后一个A[8] = 7更新进去对于这组数据没有什么意义，但是如果后面再出现两个数字 8 和 9，那么就可以把8更新到B[4], 9更新到B[5]，得出LIS的长度为6。

         然后应该发现一件事情了：在B中插入数据是有序的，而且是进行替换而不需要挪动——也就是说，我们可以使用 二分查找 ，将每一个数字的插入时间优化到 O(logN)，于是算法的时间复杂度就降低到了O(NlogN)。
         */
    }

    public int findLongest(int[] A, int n) {
        // write code here
        int[] B = new int[n];
        int end = 0;
        B[0] = A[0];
        for (int i = 1; i < n; i++) {
            int target = A[i];
            int index = binSearch(B, 0, end, target);
            B[index] = target;
            end = index > end ? index : end;
        }

        return end + 1;
    }


    /**
     * 二分查找，降低时间复杂度
     *
     * @param data
     * @param left
     * @param right
     * @param target
     * @return
     */
    public int binSearch(int[] data, int left, int right, int target) {
        int mid;
        while (left <= right) {
            mid = (left + right) / 2;
            if (data[mid] < target) {
                left = mid + 1;
            } else if (data[mid] > target) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return left;
    }


}
