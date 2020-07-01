package com.lsp.helloworld.pattern.responsibilityChain;

/**
 * Created by lisp on 2020/5/28/上午11:36.
 */
public class InfoLogger extends AbstractLogger {

    public InfoLogger(Integer level){
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("INFO::Logger" + message);
    }
}
