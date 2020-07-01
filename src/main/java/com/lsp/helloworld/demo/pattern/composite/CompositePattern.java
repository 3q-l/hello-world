package com.lsp.helloworld.demo.pattern.composite;

/**
 * 组合模式
 *  依据树形结构来组合对象，用来表示部分以及整体层次。
 * --1
 * ----1.1
 * ------1.1.1
 * ------1.1.2
 * ----1.2
 * ------1.2.1
 * ------1.2.2
 * 比如城市级联
 * Created by lisp on 2020/5/29/下午5:55.
 */
public class CompositePattern {

    public static void main(String[] args) {
        BranchNode root = new BranchNode("1");
        BranchNode chapter1 = new BranchNode("1.1");
        BranchNode chapter2 = new BranchNode("1.2");
        LeafNode c11 = new LeafNode("1.1.1");
        LeafNode c12 = new LeafNode("1.1.2");
        LeafNode c21 = new LeafNode("1.2.1");
        LeafNode c22 = new LeafNode("1.2.2");
        root.add(chapter1);
        root.add(chapter2);
        chapter1.add(c11);
        chapter1.add(c12);
        chapter2.add(c21);
        chapter2.add(c22);
        tree(root,0);
    }

    public static void tree(Node node, Integer depth){
        for (Integer i = 0; i <= depth; i++) {
            System.out.print("--");
        }
        node.p();
        if (node instanceof BranchNode){
            for (Node n : ((BranchNode) node).nodes){
                tree(n, depth+1);
            }
        }
    }
}
