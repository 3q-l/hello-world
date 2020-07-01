package com.lsp.helloworld.demo.jvm.v2;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author lisp
 * @date 2020/6/2/下午5:06
 */
public class MyClassLoader extends ClassLoader {

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        File f = new File(name);
        try {
            FileInputStream fis = new FileInputStream(f);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            int b = 0;

            while ((b=fis.read()) !=0) {
                baos.write(b);
            }

            byte[] bytes = baos.toByteArray();
            baos.close();
            //可以写的更加严谨
            fis.close();

            return defineClass(name, bytes, 0, bytes.length);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return super.findClass(name); //throws ClassNotFoundException
    }

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        ClassLoader l = new MyClassLoader();
        String name = "cn.lsp.helloworld.jvm.v2.HelloWord";
//        String name = "/Users/lisp/projects/lsp/helloworld/target/classes/cn/lsp/helloworld/jvm/v2/HelloWord.class";
        Class clazz = l.loadClass(name);

        HelloWord h = (HelloWord) clazz.newInstance();
        h.p();

        System.out.println(l.getClass().getClassLoader());
        System.out.println(l.getParent());

        System.out.println(getSystemClassLoader());
    }
}

/**
 * @author lisp
 */
class HelloWord {
    public void p(){
        System.out.println("你好");
    }
    static Map<String,Integer> map = new HashMap<>();
    static {
        map.put("A",0);
        map.put("B",1);
        map.put("C",1);
        map.put("D",2);
        map.put("E",2);
        map.put("F",5);
        map.put("G",5);
        map.put("H",4);
        map.put("I",4);
    }
    public static void main(String[] args) {
        for (String s : map.keySet()) {
            Integer num = map.get(s);
            for (Integer i = 0; i < num; i++) {
                System.out.print("    ");
            }
            System.out.println(s);
        }
    }
}
