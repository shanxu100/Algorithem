package nowcoder.Tencent.shixi;

import java.util.*;

/**
 * @author Guan
 * @date Created on 2018/4/5
 */
public class Jobs {
    public static int n, m;
    public static List<Job> jobList;
    public static List<Machine> machineList;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            n = in.nextInt();
            m = in.nextInt();
            machineList = new ArrayList<>(n);
            jobList = new ArrayList<>(m);
            for (int i = 0; i < n; i++) {
                machineList.add(new Machine(in.nextInt(), in.nextInt()));
            }

            for (int i = 0; i < m; i++) {
                jobList.add(new Job(in.nextInt(), in.nextInt()));
            }
            doJobs();

        }

    }

    /**
     * 贪心解决一部分：30%
     */
    public static void doJobs() {

        Collections.sort(jobList, new MyCompareJob());
        Collections.sort(machineList, new MyCompareMachine());

        int totle = 0;
        int count = 0;

        for (Job job : jobList) {
            for (Machine machine : machineList) {
                if (machine.job != null) {
                    continue;
                }
                if (job.z <= machine.x && job.w <= machine.y) {
                    totle += gain(job.z, job.w);
                    count++;
                    machine.job = job;
                }
            }
        }

        System.out.println(count+" "+totle);

    }

    public static int gain(int z, int w) {
        return 200 * z + 3 * w;
    }

    public static class Job {
        int z, w;

        public Job(int z, int w) {
            this.z = z;
            this.w = w;
        }
    }

    public static class Machine {
        int x, y;
        Job job;

        public Machine(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static class MyCompareJob implements Comparator<Job> {

        @Override
        public int compare(Job o1, Job o2) {
            if (o1.z > o2.z) {
                return -1;
            } else if (o1.z < o2.z) {
                return 1;
            } else if (o1.w > o2.w) {
                return -1;
            } else {
                return 1;
            }
        }
    }

    public static class MyCompareMachine implements Comparator<Machine> {

        @Override
        public int compare(Machine o1, Machine o2) {
            if (o1.x > o2.x) {
                return 1;
            } else if (o1.x < o2.x) {
                return -1;
            } else if (o1.y > o2.y) {
                return 1;
            } else {
                return -1;
            }
        }
    }

}
