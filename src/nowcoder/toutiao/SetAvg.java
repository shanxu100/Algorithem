package nowcoder.toutiao;

import java.util.*;

/**
 * @author Guan
 * @date Created on 2018/3/24
 */
public class SetAvg {

    public static int n, m;


    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            n = in.nextInt();
            m = in.nextInt();

            Group a = new Group(n);
            Group b = new Group(m);
            for (int i = 0; i < n; i++) {
                a.add(in.nextInt());
            }
            for (int i = 0; i < m; i++) {
                b.add(in.nextInt());
            }
            int result = 0;
            int lastResult = -1;
            while (result > lastResult) {
                lastResult = result;
                a.doAvg();
                b.doAvg();
                if (a.getAvg() > b.getAvg()) {
                    Set<Integer> removeSet = a.getBetween(b.getAvg(), a.getAvg());
                    result = removeSet.size();
                    b.addNewSet(removeSet);
                } else {
                    Set<Integer> removeSet = b.getBetween(a.getAvg(), b.getAvg());
                    result = removeSet.size();
                    a.addNewSet(removeSet);
                }
            }

            System.out.println(result);

        }
    }

    public static class Group {
        Set<Integer> set;
        int size;
        double avg;

        public Group(int size) {
            set = new HashSet<>(size);
            this.size = size;
        }

        public void add(int i) {
            set.add(i);
        }

        public void doAvg() {
            double result = 0;
            for (Integer i : set) {
                result += i;
            }
            avg = result / size;
        }

        public double getAvg() {
            return avg;
        }

        public void addNewSet(Set<Integer> newSet) {
            for (Integer i : newSet) {
                set.add(i);
            }
        }

        public Set<Integer> getBetween(double low, double high) {
            int count = 0;
            Set<Integer> removeSet = new HashSet<>();
            Iterator<Integer> it = set.iterator();
            while (it.hasNext()) {
                int tmp = it.next();
                if (tmp > low && tmp < high) {
                    count++;
                    removeSet.add(tmp);
                    it.remove();
                }

            }
            return removeSet;
        }
    }

}
