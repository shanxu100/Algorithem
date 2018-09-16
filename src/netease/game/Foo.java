package netease.game;

/**
 * @author Guan
 * @date Created on 2018/9/15
 */
public class Foo {


    public static void main(String[] args) {

        System.out.println(foo(12));
    }

    public static int foo(int n) {

        if (n <= 3) {
            return 1;
        }else {
            return foo(n - 2) + foo(n - 6) + 1;
        }

    }
}
