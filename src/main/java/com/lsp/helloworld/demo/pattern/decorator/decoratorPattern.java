package com.lsp.helloworld.demo.pattern.decorator;

/**
 * 装饰模式
 * 1.给某个物体添加某些装饰物
 *      eg：人+头花+西服
 *      可以使用继承的方法，但是会造成类爆炸
 *          eg: 人+头花   人+西服  人+头花+西服 每增加一种装饰都需要生成一个类
 *      可以使用聚合方案。
 *          eg：人、头花、西服 均是属性，需要增加某种装饰就增加某一个装饰的属性
 * Created by lisp on 2020/5/28/上午11:47.
 */
public class decoratorPattern {

    public static void main(String[] args) {
        Shape circle = new Circle();
        ShapeDecorator redCircle = new RedShapeDecorator(new Circle());
        ShapeDecorator redRectangle = new RedShapeDecorator(new Rectangle());
        //Shape redCircle = new RedShapeDecorator(new Circle());
        //Shape redRectangle = new RedShapeDecorator(new Rectangle());
        System.out.println("Circle with normal border");
        circle.draw();

        System.out.println("\nCircle of red border");
        redCircle.draw();

        System.out.println("\nRectangle of red border");
        redRectangle.draw();
    }
}
