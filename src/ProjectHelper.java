import java.io.*;

/**
 * Created by Guan on 2017/9/27.
 */
public class ProjectHelper {

    public static void main(String[] args) {
        String path = "E:\\PROJECT\\androidstudio-project\\yjy3.0\\TeacherClient\\app\\src\\main\\res\\anim";
        File file = new File(path);
        String[] list = file.list();
        int length = list.length;
        System.out.println("file.size=" + length);
        for (int i = 0; i < length; i++) {
            String onePath = list[i];
            File oneFile = new File(path, onePath);
            FileInputStream fis = null;
            FileReader fr = null;
            char[] b = new char[1];
            try {
                //                System.out.print("寻找当前文件="+onePath);
                fr = new FileReader(oneFile);
                fr.read(b, 0, 1);
                //                System.out.println("the first c of the file = "+b[0]);
                if (b[0] == 0xfeff) {
                    System.out.println("=========================当前文件出现异常字符， file=" + onePath);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (fis != null) {
                    try {
                        fis.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            //            System.out.println("the first c of the file = "+b[0]);
            if (b[0] == 0xfeff) {

            }
        }
    }
}
