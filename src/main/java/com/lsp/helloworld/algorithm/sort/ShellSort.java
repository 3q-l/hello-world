package com.lsp.helloworld.algorithm.sort;

/**
 * 希尔排序 O(n^1.3)
 * 分治 分组插入排序
 * Created by lisp on 2020/7/10/下午4:28.
 */
public class ShellSort {
    public static void main(String[] args) {
        int[] data = {9,6,11,3,5,12,8,7,10,15,14,4,1,13,2};
        sort(data);
        SortUtils.print(data);
    }

    /**
     * @param data
     * @author lisp
     * @date 2020/7/10 下午3:51
     * @return {@link }
     */
    public static void sort(int[] data){
        int length = data.length;
        int h = 1;
        while (h < length /3){
            h = h * 3 + 1;
        }
        for (int gap = h; gap > 0; gap = ( gap - 1 ) / 3) {
            for (int i = gap; i < length; i ++) {
                for (int j = i; j > gap - 1; j-=gap) {
                    if (data[j] < data[j-gap]){
                        SortUtils.swap(data,j,j-1);
                    }
                }
            }
        }
    }
}
