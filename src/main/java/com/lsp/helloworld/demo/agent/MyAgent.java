package com.lsp.helloworld.demo.agent;

/**
 * @author lishuaipeng
 * @date 2020/11/23 2:26 下午
 */
public class MyAgent {

    public static void preMain(String args){
        System.out.println("premain");
    }

    public static void main(String[] args) {
        try {
            // do something
            System.exit(1);
        } finally {
            System.out.println("Print from finally");
        }
    }
}
