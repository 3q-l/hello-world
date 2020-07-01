package com.lsp.helloworld.demo.pattern.proxy.test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by lisp on 2020/6/3/上午10:45.
 */
public class Test {
    public static void main(String[] args) throws Exception {
        IA ia = (IA) createObject(IA.class.getName() + "$getName=Abc");
        System.out.println(ia.getName());
    }

    public static Object createObject(String str) throws Exception {
        IA ia = (IA) Proxy.newProxyInstance(Test.class.getClassLoader(),
                new Class[]{IA.class}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                String[] split = str.split("=");
                if (split[0].equals(method.getDeclaringClass().getName()+"$"+method.getName())){
                    return split[1];
                }
                return null;
            }
        });
        return ia;
    }

}

interface IA {
    String getName();
}
