package com.lsp.helloworld.algorithm.sort;

/**
 * 冒泡排序 O(n^2)
 * Created by lisp on 2020/7/10/下午4:19.
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] data = {3,2,4,5,1,-1};
        sort(data);
    }

    /**
     * @param data
     * @author lisp
     * @date 2020/7/10 下午3:51
     * @return {@link }
     */
    public static void sort(int[] data){
        int length = data.length;
        for (int i = length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (data[j] > data[j+1]){
                    SortUtils.swap(data,j,j+1);
                }
            }
        }
        SortUtils.print(data);
    }
}
