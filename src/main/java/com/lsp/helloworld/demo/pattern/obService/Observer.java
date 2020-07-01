package com.lsp.helloworld.demo.pattern.obService;

/**
 * 观察者类
 * Created by lisp on 2020/5/29/下午5:43.
 */
public abstract class Observer {
    protected Subject subject;
    public abstract void update();
}
