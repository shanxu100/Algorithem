package nowcoder.Tencent.shixi;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author Guan
 * @date Created on 2018/3/23
 */
public class QCoin {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        if(n<=2) {
            System.out.println(n);
            return;
        }
        Set<Integer> countset=new HashSet<>();
        int stop=n/2;
        for(int i=1;i<=stop;i++) {
            int result=(i)^(n-i);//异或a和b
            countset.add(result);
        }
        System.out.println(countset.size());
    }
}
