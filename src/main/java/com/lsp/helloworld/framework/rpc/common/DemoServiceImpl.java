package com.lsp.helloworld.framework.rpc.common;

import com.lsp.helloworld.framework.rpc.util.IpUtils;

import java.lang.reflect.Method;

/**
 * @author lishuaipeng
 * @date 2020/8/10/6:03 下午
 */
public class DemoServiceImpl implements DemoService {

    private final static StringBuffer ip = new StringBuffer(IpUtils.getIp());

    @Override
    public String say(String msg) {
        return ip.append("-")
                .append(Thread.currentThread().getName())
                .append(":")
                .append(msg).toString();
    }

    public static void main(String[] args) throws Exception {
        DemoService demoService = new DemoServiceImpl();
        Class<? extends DemoService> aClass = demoService.getClass();
        Method method = aClass.getDeclaredMethod("say", String.class);
        Class<?> returnType = method.getReturnType();
        Object obj = method.invoke(demoService, "I'm is Test");
        System.out.println(obj);
        if (returnType.isInstance(obj)){
            Object cast = returnType.cast(obj);
            System.out.println(cast);
        }
    }
}
