package com.lsp.helloworld.framework.rpc.netty;

/**
 * @author lishuaipeng
 * @date 2020/10/20 9:10 下午
 */
public class test {

    public static void main(String[] args) {
        for ( int i = 0; i < 10; i++) {
            final int a = i;
            new Thread(()->{
                System.out.println("1111");
                System.out.println("nihao");
                System.out.println(a);
            }).start();
        }
    }
}
