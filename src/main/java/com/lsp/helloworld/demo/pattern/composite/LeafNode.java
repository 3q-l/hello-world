package com.lsp.helloworld.pattern.composite;

/**
 * Created by lisp on 2020/5/29/下午6:04.
 */
public class LeafNode extends Node {
    String content;

    public LeafNode(String content){
        this.content = content;
    }
    @Override
    public void p() {
        System.out.println(content);
    }
}
