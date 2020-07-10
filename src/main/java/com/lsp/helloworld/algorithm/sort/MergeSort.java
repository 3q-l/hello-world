package com.lsp.helloworld.algorithm.sort;

/**
 * 归并排序 O(n log2^n)
 * Created by lisp on 2020/7/10/下午4:28.
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] data = {1,3,6,4,5};
        sort(data);
        SortUtils.print(data);
    }

    public static void sort(int[] data){
//        merge(data);
    }

    public static void merge(int[] data,int leftPtr,int rightPtr,int rightBound){
        int length = data.length;
        int mid = length / 2;
        int[] tamp = new int[rightBound - leftPtr + 1];
        int i = leftPtr;
        int j = rightPtr;
        int k = 0;
        while (i <= mid && j < length){
            if (data[i] <= data[j]){
                tamp[k++] = data[i++];
            } else {
                tamp[k++] = data[j++];
            }
        }
        while (i <= mid) {tamp[k++] = data[i++];}
        while (j < length) {tamp[k++] = data[j++];}
        SortUtils.print(tamp);
    }
}
