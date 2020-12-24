package com.lsp.helloworld.demo;

import org.junit.Test;

/**
 * @author lishuaipeng
 * @date 2020/10/27 3:06 下午
 */
public class BooleanTest {

    @Test
    public void test(){
        boolean tag = true;
        if (tag){
            System.out.println("是的");
        }
        if (tag == true){
            System.out.println("真真的");
        }
        A a = new A();
        a.b();
    }

    public void invoke(Object a,Object... objects){

    }

    public void invoke(String a,Object object,Object... objects){

    }
}

class A{
    public void b(){
        System.out.println("aaaaaa");
    }
}
class B extends A{
    public void b(){
        System.out.println("bbbbbbb");
    }
}
