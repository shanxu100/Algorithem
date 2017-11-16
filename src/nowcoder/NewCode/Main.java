package nowcoder.NewCode;

import java.text.DecimalFormat;
import java.util.Scanner;


/**
 * Created by Guan on 2017/9/9.
 */
public class Main {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            System.out.println(perfectDot(in.nextInt()));
        }

    }

    public static int perfectDot(int rr) {
        int count = 0;
        double r = Math.sqrt(rr);
        int tmp_r = (int) r;
        if (tmp_r * tmp_r == rr) {
            count += 4;
        }
        double middle=Math.sqrt(rr / 2);
        int tmp = (int) middle;
        if (tmp * tmp * 2 == rr) {
            count += 4;
        }
        int tmp_count = 0;
        for (int i = 1; i < middle; i++) {
            for (int j = (int) r; j > r - i; j--) {
                if (i * i + j * j == rr) {
                    tmp_count++;
                    //System.out.println(i+"\t"+j);
                }
            }
        }
        tmp_count = tmp_count * 8;

        return count + tmp_count;
    }


    //数值翻转后求和
    public static class OppositeNum {
        public static int addNum(int num) {
            String num_str = String.valueOf(num);
            String reverse_num_str = new StringBuffer(num_str).reverse().toString();
            int reverse_num = Integer.parseInt(reverse_num_str);
            return num + reverse_num;
        }
    }

    //计算String碎片的额平均值
    public static class StringChip {
        //public static
        public static String countStringChip(String s) {
            //double result = 0;
            double chipNum = 1;
            char[] chars = s.toCharArray();
            char c = chars[0];
            for (int i = 1; i < chars.length; i++) {
                if (chars[i] != chars[i - 1]) {
                    chipNum++;
                }
            }

            //0	数值部分	是	数字，是0也显示
            //#	数值部分	是	数字，如果是0则不显示（仅限开始和小数点后的末尾位置）
            DecimalFormat df = new DecimalFormat("#########0.00");
            double result = chars.length / chipNum;
            return df.format(result);
        }
    }

    //重新排列，相邻两个数之积是否被4整除
    public static class FourTimes {
        public static String fourTimesOfNumArray(int[] array) {
            int type0 = 0, type1 = 0, type2 = 0;
            for (int i = 0; i < array.length; i++) {
                if (array[i] % 4 == 0) {
                    type2++;
                } else if (array[i] % 2 == 0) {
                    type1++;
                } else {
                    type0++;
                }
            }
            //System.out.println("type0:"+type0+"\ttype1:"+type1+"\ttype2:"+type2);
            int needType2Num = 0;
            if (type0 != 0 && type1 != 0) {
                needType2Num++;
            }
            needType2Num += type0 > 0 ? type0 - 1 : 0;
            if (needType2Num > type2)
                return "No";
            else
                return "Yes";
        }

    }

    //生产魔法币
    public static class ProduceCoin {
        public static String produceCoins(int n) {
            StringBuffer stringBuffer = new StringBuffer();
            while (n > 0) {
                if (n % 2 == 0) {
                    stringBuffer.append("2");
                    n = (n - 2) / 2;
                } else {
                    stringBuffer.append("1");
                    n = (n - 1) / 2;
                }
            }

            return stringBuffer.reverse().toString();
        }

    }


}
