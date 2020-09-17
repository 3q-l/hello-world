package com.lsp.helloworld.algorithm.sort;

/**
 * 快速排序 O(n log2^n)
 * Created by lisp on 2020/7/10/下午4:28.
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] data = {3,2,9,5,1,-1,6,7,4};
        sort(data,0,data.length - 1);
        SortUtils.print(data);
    }

    /**
     * @param data
     * @author lisp
     * @date 2020/7/10 下午3:51
     * @return {@link }
     */
    public static void sort(int[] data,Integer leftBound,Integer rightBound){
        if (leftBound >= rightBound){
            return;
        }
        partition(data, leftBound, rightBound);
    }

    private static void partition(int[] data,Integer leftBound,Integer rightBound) {
        SortUtils.swap(data,0,1);
    }
}
