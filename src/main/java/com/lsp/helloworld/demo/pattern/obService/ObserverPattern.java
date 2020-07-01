package com.lsp.helloworld.demo.pattern.obService;

/**
 * 观察者模式
 * Created by lisp on 2020/5/29/下午5:42.
 */
public class ObserverPattern {
    public static void main(String[] args) {
        Subject subject = new Subject();

        new HexaObserver(subject);
        new OctalObserver(subject);
        new BinaryObserver(subject);

        System.out.println("First state change: 15");
        subject.setState(15);
        System.out.println("Second state change: 10");
        subject.setState(10);
    }
}
