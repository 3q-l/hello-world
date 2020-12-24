package com.lsp.helloworld.demo.guava.basic;

import com.google.common.collect.Range;

/**
 * @author lishuaipeng
 * @date 2020/12/8 下午5:04
 */
public class Section {

    public static void main(String[] args) {
        Range<Character> open = Range.open('a', 'z');
        System.out.println(open.contains('A'));
        System.out.println(open.contains('b'));
    }
}
