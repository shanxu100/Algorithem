package netease.game;

/**
 * @author Guan
 * @date Created on 2018/9/15
 */
public class Foo {

    public static int count=0;

    public static void main(String[] args) {

        foo(foo(8));
        System.out.println(count);
    }

    public static int foo(int n) {
        count++;
        if (n <= 3) {
            return 1;
        } else {
            return foo(n - 2) + foo(n - 4) + 1;
        }
    }
}
