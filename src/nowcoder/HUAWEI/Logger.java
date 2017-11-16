package nowcoder.HUAWEI;

import java.awt.event.FocusEvent;
import java.util.*;

public class Logger {

    public static HashMap<String, Holder> map = new HashMap<String, Holder>(1024);

    /**
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String filePath;
        int lineNum;
        int index = 0;
        while (scanner.hasNext()) {
            filePath=scanner.next();
            lineNum=scanner.nextInt();

            doLog(filePath, lineNum, index);
            //System.out.println(index);
            index++;
        }


        doPrint();
    }

    public static void doLog(String filePath, int lineNum, int index) {
        Holder holder = new Holder(filePath, lineNum, index);
        if (map.containsKey(holder.getKey())) {
            map.get(holder.getKey()).count++;
        } else {
            map.put(holder.getKey(), holder);
        }

    }

    public static void doPrint() {
        List<Map.Entry<String, Holder>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Holder>>() {
            @Override
            public int compare(Map.Entry<String, Holder> o1, Map.Entry<String, Holder> o2) {
                System.out.println("compare");
                if (o1.getValue().count > o2.getValue().count) {
                    return 1;
                } else if (o1.getValue().count < o2.getValue().count) {
                    return -1;
                } else if (o1.getValue().index > o2.getValue().index) {
                    return 1;
                } else {
                    return 0;
                }
            }
        });

        StringBuilder stringBuilder = new StringBuilder();
        int printLine = list.size() > 8 ? 8 : list.size();
        for (int i = 0; i < printLine; i++) {
            Holder holder = list.get(i).getValue();
            stringBuilder.append(holder.fileName);
            stringBuilder.append(" ");
            stringBuilder.append(holder.lineNum);
            stringBuilder.append(" ");
            stringBuilder.append(holder.count);
            System.out.println(stringBuilder.toString());
        }
    }

    public static class Holder {
        public String fileName;
        public String fileName_long;
        public int lineNum;
        public int index;

        public int count = 0;

        //辅助用
        static int fileNameFirstIndex;
        static int length;

        public Holder(String filePath, int lineNum, int index) {

            fileNameFirstIndex = filePath.lastIndexOf("\\") + 1;
            this.fileName_long = filePath.substring(fileNameFirstIndex);
            length = fileName_long.length();
            fileNameFirstIndex = length > 16 ? length - 16 : 0;

            this.fileName = fileName_long.substring(fileNameFirstIndex);
            this.lineNum = lineNum;
            this.index = index;
            this.count = 1;
        }

        public String getKey() {
            return fileName_long + " " + lineNum;
        }
    }
}
