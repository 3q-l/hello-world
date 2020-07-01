package com.lsp.helloworld.demo.pattern.decorator;

/**
 * 装饰类
 * Created by lisp on 2020/5/28/下午2:25.
 */
public abstract class ShapeDecorator implements Shape {
    protected Shape decoratedShape;

    public ShapeDecorator(Shape decoratedShape){
        this.decoratedShape = decoratedShape;
    }

    @Override
    public void draw(){
        decoratedShape.draw();
    }
}
