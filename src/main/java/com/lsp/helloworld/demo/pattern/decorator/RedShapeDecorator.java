package com.lsp.helloworld.demo.pattern.decorator;

/**
 * 扩展了ShapeDecorator的装饰类 +了颜色
 * Created by lisp on 2020/5/28/下午2:26.
 */
public class RedShapeDecorator extends ShapeDecorator {

    public RedShapeDecorator(Shape decoratedShape) {
        super(decoratedShape);
    }

    @Override
    public void draw() {
        decoratedShape.draw();
        setRedBorder(decoratedShape);
    }

    // 装饰的颜色
    private void setRedBorder(Shape decoratedShape){
        System.out.println("Border Color: Red");
    }

}
