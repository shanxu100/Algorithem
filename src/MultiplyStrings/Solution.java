package MultiplyStrings;

import com.sun.deploy.util.StringUtils;

import java.util.Arrays;
import java.util.StringJoiner;

/**
 * Created by guan on 10/10/16.
 */
public class Solution {
    /**
     * 把两个数的乘法变为n个数的加法
     *
     * @param num1
     * @param num2
     * @return
     */
    public String multiply(String num1, String num2) {

        int[] res = new int[num1.length() + num2.length() + 2];
        //char[] c1=num1.toCharArray();
        char[] c2 = num2.toCharArray();
        int[] n2 = new int[c2.length];
        int count = 0;
        int jinwei = 0;
        int tmp = 0;

        for (int i = 0, end = c2.length - 1; i < c2.length; i++) {
            n2[end - i] = c2[i] - '0';
        }

        //这一步Integer.valueOf(num1)表明，受限于num1的大小。
        for (int i = 0; i < Integer.valueOf(num1); i++) {
            //下面计算num1个num2相加
            while (true) {

                if (jinwei == 0 && count >= n2.length) {
                    break;
                }

                if (count < n2.length) {
                    tmp = res[count] + n2[count] + jinwei;
                } else {
                    tmp = res[count] + jinwei;
                }

                res[count] = (tmp) % 10;
                jinwei = (tmp) / 10;
                count++;
            }

            jinwei = 0;
            count = 0;
        }

        //将res翻转过来成String再返回
        //return (res);

        return null;
    }


    public String multiply2(String num1, String num2) {
        char[] c1 = num1.toCharArray();
        char[] c2 = num2.toCharArray();
        int[] n1 = new int[c1.length];
        int[] n2 = new int[c2.length];
        int length = c1.length + c2.length + 3;
        int[] res = new int[length];//默认初始化为0

        int[][] sum = new int[length][length];
        int tmp = 0;
        StringBuilder result = new StringBuilder();
        result.append("0");


        //翻转
        for (int i = 0, j = c1.length - 1; i < c1.length; i++, j--) {
            n1[i] = c1[j] - '0';
        }
        for (int i = 0, j = c2.length - 1; i < c2.length; i++, j--) {
            n2[i] = c2[j] - '0';
        }

//        System.out.println(Arrays.toString(n1));
//        System.out.println(Arrays.toString(n2));

        for (int i = 0; i < n1.length; i++) {
            for (int j = 0; j < n2.length; j++) {
                sum[i][j + i] = n1[i] * n2[j];
            }
        }

//        for (int[] i:sum)
//        {
//            for (int j:i)
//            {
//                System.out.print(j+"\t");
//            }
//            System.out.println();
//        }

        //处理进位
        for (int j = 0; j < length; j++) {
            for (int i = 0; i < length; i++) {
                tmp += sum[i][j];
            }
            res[j] = tmp % 10;
            tmp = tmp / 10;
        }

        System.out.println(Arrays.toString(res));

        for (int i = res.length - 1; i >= 0; i--) {
            if (res[i]!=0)
            {
                result.deleteCharAt(0);
                for (;i>=0;i--)
                {
                    result.append(res[i]);
                    //Java 5种字符串拼接方式性能比较。http://blog.csdn.net/kimsoft/article/details/3353849
                }
                break;
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {

        Solution solution = new Solution();
        String num1 = "98";
        String num2 = "37";
        System.out.println(solution.multiply2(num1, num2));
    }
}
