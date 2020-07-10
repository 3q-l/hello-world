package com.lsp.helloworld.algorithm.sort;

/**
 * 插入排序 O(n^2)
 * 拿后面的值与已经排好顺序的数组对比放入该放的位置
 * Created by lisp on 2020/7/10/下午4:27.
 */
public class InsertionSort {
    public static void main(String[] args) {
        int[] data = {3,2,4,5,1};
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
        for (int i = 1; i < length; i++) {
            for (int j = i; j > 0; j--) {
                if (data[j] < data[j-1]){
                    SortUtils.swap(data,j,j-1);
                }
            }
        }
        SortUtils.print(data);
    }
}
