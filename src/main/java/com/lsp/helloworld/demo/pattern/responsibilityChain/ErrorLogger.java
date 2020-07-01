package com.lsp.helloworld.pattern.responsibilityChain;

/**
 * Created by lisp on 2020/5/28/上午11:38.
 */
public class ErrorLogger extends AbstractLogger {
    public ErrorLogger(Integer level){
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("ERROR::Logger" + message);
    }
}
