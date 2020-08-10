package com.lsp.helloworld.algorithm.sort;

import java.util.Arrays;

/**
 * 归并排序 O(n log2^n)
 * Created by lisp on 2020/7/10/下午4:28.
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] data = {1,8,7,4,10,6,9};
        Arrays.sort(data);
        sort(data,0,data.length - 1);
        SortUtils.print(data);
    }

    public static void sort(int[] data,int left,Integer right){
        if (left < 0 || right <= 0 || left >= right){
            return;
        }
        // 分成两半
        int mid = left + (right - left) / 2;
        // 左边排序
        sort(data,left,mid);
        // 右边排序
        sort(data,mid + 1,right);
        merge(data,left,mid + 1,right);
    }

    public static void merge(int[] data,int leftPtr,int rightPtr,int rightBound){
        int mid = rightPtr - 1;
        int[] tamp = new int[rightBound - leftPtr + 1];
        int i = leftPtr;
        int j = rightPtr;
        int k = 0;
        while (i <= mid && j <= rightBound){
            tamp[k++] = data[i] <= data[j] ? data[i++] : data[j++];
        }
        while (i <= mid) {tamp[k++] = data[i++];}
        while (j <= rightBound) {tamp[k++] = data[j++];}
        for (int m = 0; m < tamp.length; m++) {
            data[leftPtr + m] = tamp[m];
        }
    }
}
