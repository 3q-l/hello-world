package com.lsp.helloworld.demo.guava.basic;

import java.util.Optional;

/**
 * @author lishuaipeng
 * @date 2020/12/4 下午2:27
 */
public class OptionalTest {

    /**
     * 判空
     * @param args
     */
    public static void main(String[] args) {
        Optional<Integer> optional = Optional.ofNullable(1);
        // 判断是否为空
        if (optional.isPresent()){
            System.out.println(optional.get());
        } else {
            System.out.println("Present 空");
        }
        // 如果为空则赋值
        System.out.println(optional.orElse(2));
        // 是否等于这个值
        System.out.println(optional.equals(2));
        // 如果为空执行并返回数值
        System.out.println(optional.orElseGet(()->{
            System.out.println("我是空");
            return 2;})
        );
    }
}
