package com.lsp.helloworld.jmh;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by lisp on 2020/5/27/下午4:11.
 */
public class PS {
    static List<Integer> nums = new ArrayList<>();
    static {
        Random r = new Random();
        for (int i = 0; i < 1000; i++) {
            nums.add(100000+r.nextInt(100000));
        }
    }

    public static void foreach(){
        nums.forEach(v -> isPrime(v));
    }

    static void parallel(){
        nums.parallelStream().forEach(PS::isPrime);
    }

    static boolean isPrime(Integer num){
        for (int i = 2; i < num / 2; i++) {
            if (num % i == 0){
                return false;
            }
        }
        return true;
    }
}
