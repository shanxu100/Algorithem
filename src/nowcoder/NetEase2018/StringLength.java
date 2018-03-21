package nowcoder.NetEase2018;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * @author Guan
 * @date Created on 2018/3/20
 */
public class StringLength {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str;
        while (in.hasNextLine()) {
            str = in.nextLine();
            System.out.println(getStringLength(str));
        }
    }

    public static String getStringLength(String str) {
        char[] chars=str.toCharArray();
        char tmp=chars[0];
        float count=1;
        for (char c: chars)
        {
            if (c!=tmp)
            {
                count++;
                tmp=c;
            }
        }
        float result=str.length()/count;
        DecimalFormat format=new DecimalFormat("#######0.00");
        return format.format(result);
    }


}
