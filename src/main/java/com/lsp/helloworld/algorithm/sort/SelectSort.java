package com.lsp.helloworld.algorithm.sort;

/**
 * 选择排序 O(n^2)
 * 先找出最小值，放到第一位、、、、、、、、
 * Created by lisp on 2020/7/10/下午2:44.
 */
public class SelectSort {

    public static void main(String[] args) {
        int[] data = {3,2,4,5,1,1,-1};
        sort2(data);
    }

    /**
     * 找最小值
     * @param data
     * @author lisp
     * @date 2020/7/10 下午3:51
     * @return {@link }
     */
    public static void sort1(int[] data){
        int length = data.length;
        for (int i = 0; i < length; i++) {
            int min = i;
            for (int j = i + 1; j < length; j++) {
                if (data[min] > data[j]){
                    min = j;
                }
            }
            SortUtils.swap(data,i,min);
        }
        SortUtils.print(data);
    }

    /**
     * 找最小值、最大值
     * @param data
     * @author lisp
     * @date 2020/7/10 下午3:51
     * @return {@link }
     */
    public static void sort2(int[] data){
        int length = data.length;
        for (int i = 0; i < length/2; i++) {
            int min = i;
            int max = i;
            for (int j = i + 1; j < length-i; j++) {
                if (data[min] > data[j]){
                    min = j;
                }
                if (data[max] < data[j]){
                    max = j;
                }
            }
            SortUtils.swap(data,i,min);
            SortUtils.swap(data,max,length - i -1 );
        }
        SortUtils.print(data);
    }
}
