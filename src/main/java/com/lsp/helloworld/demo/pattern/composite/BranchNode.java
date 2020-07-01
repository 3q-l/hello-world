package com.lsp.helloworld.pattern.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lisp on 2020/5/29/下午6:06.
 */
public class BranchNode extends Node {
    List<Node> nodes = new ArrayList<>();
    String name;
    public void add(Node node) {
        nodes.add(node);
    }

    public BranchNode(String name){
        this.name = name;
    }
    @Override
    public void p() {
        System.out.println(name);
    }
}
