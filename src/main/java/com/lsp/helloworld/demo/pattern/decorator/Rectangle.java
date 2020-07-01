package com.lsp.helloworld.demo.pattern.decorator;

/**
 * 矩形
 * Created by lisp on 2020/5/28/下午2:24.
 */
public class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Shape: Rectangle");
    }
}
