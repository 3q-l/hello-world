package com.lsp.helloworld.demo.pattern.memento;

/**
 * Created by lisp on 2020/6/1/下午3:17.
 */
public class Memento {
    private String state;

    public Memento(String state){
        this.state = state;
    }

    public String getState(){
        return state;
    }
}
