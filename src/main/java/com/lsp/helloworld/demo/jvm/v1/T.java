package com.lsp.helloworld.jvm.v1;

/**
 * Created by lisp on 2020/6/2/上午10:35.
 */
public class T {
    public static int a =2;
    // 在a下面 结果：3 在a上面 结果：2
    public static T t = new T();

    public int b = 2;

    private T() {
        System.out.println(b);
        a++;
    }


    public static void main(String[] args) {
        System.out.println(T.a);
        System.out.println(T.t.b);
    }
}
