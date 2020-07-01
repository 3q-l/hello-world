package com.lsp.helloworld.demo.pattern.responsibilityChain;

/**
 * Created by lisp on 2020/5/28/上午11:38.
 */
public class DebugLogger extends AbstractLogger {
    public DebugLogger(Integer level){
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("DEBUG::Logger" + message);
    }
}
