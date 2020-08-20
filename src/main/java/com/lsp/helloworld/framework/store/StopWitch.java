package com.lsp.helloworld.framework.store;

/**
 * @author lsp
 * @date 2020/6/20/8:34 PM
 */
public class StopWitch {
    private long start;

    private long end;

    public void start(){
        start = System.currentTimeMillis();
    }

    public void print(){
        end = System.currentTimeMillis();
        witch();
    }

    private void witch(){
        System.out.println(end - start +"ms");
    }
}
