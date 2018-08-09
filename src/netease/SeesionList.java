package netease;

import java.util.*;

/**
 * @author Guan
 * @date Created on 2018/8/9
 */
public class SeesionList {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for (int i = 0; i < T; i++) {
            int N = in.nextInt();
            Set<Integer> set=new LinkedHashSet<>();
            for (int j = 0; j < N; j++) {
                int id=in.nextInt();
                if (set.contains(id)){
                    set.remove(id);
                }
                set.add(id);
            }
            StringBuilder sb=new StringBuilder();
            for (int k:set){
                sb.insert(0," ").insert(0,k);
            }
            sb.deleteCharAt(sb.length()-1);
            System.out.println(sb.toString());
        }

//        set.add(1);
//        set.add(2);
//        set.add(3);
//        set.remove(1);
//        set.add(1);
//        for (Integer i:set){
//            System.out.println(i);
//        }

    }
}
