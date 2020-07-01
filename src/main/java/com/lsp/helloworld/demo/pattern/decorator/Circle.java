package com.lsp.helloworld.demo.pattern.decorator;

/**
 * 圆形
 * Created by lisp on 2020/5/28/下午2:25.
 */
public class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Shape: Circle");
    }
}
