package com.lsp.helloworld.algorithm.sort;

/**
 * Created by lisp on 2020/7/10/下午3:47.
 */
public class SortUtils {

    public static void swap(int[] data,int i,int j){
        int datum = data[i];
        data[i] = data[j];
        data[j] = datum;
    }

    public static void print(int[] data){
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + "\t");
        }
        System.out.println();
    }
}
