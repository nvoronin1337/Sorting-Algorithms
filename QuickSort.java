package com.company;

import java.text.DecimalFormat;
import java.util.Arrays;

public class QuickSort {

    private static DecimalFormat df2 = new DecimalFormat("#.####");

    public static void main(String[] args) {
	    Integer[] arr = {9,4,5,6,1,2,3,5,3};
	    Integer[] arr1 = {1,2,3,4,5,6,7,8,9,10};
	    Integer[] arr2 = {9,8,7,6,5,4,3,2,1,0,-1,-2};

	    long start_time = System.nanoTime();
	    GenericQuickSort(arr, 0, arr.length-1);
	    long end_time = System.nanoTime();

        long start_time1 = System.nanoTime();
        GenericQuickSort(arr1, 0, arr1.length-1);
        long end_time1 = System.nanoTime();

        long start_time2 = System.nanoTime();
        GenericQuickSort(arr2, 0, arr2.length-1);
        long end_time2 = System.nanoTime();


        System.out.println(Arrays.toString(arr));
        System.out.println("Time elapsed: " + df2.format((end_time - start_time)*0.000001) + "ms");

        System.out.println(Arrays.toString(arr1));
        System.out.println("Time elapsed: " + df2.format((end_time1 - start_time1)*0.000001) + "ms");

        System.out.println(Arrays.toString(arr2));
        System.out.println("Time elapsed: " + df2.format((end_time2 - start_time2)*0.000001) + "ms");
    }


    public static <T extends Comparable<? super T>> void GenericQuickSort(T[] arr, int left, int right){
        if(left < right){
            int split = Partition(arr, left, right);
            GenericQuickSort(arr, left, split-1);
            GenericQuickSort(arr, split+1, right);
        }
    }


    public static <T extends Comparable<? super T>> int Partition(T[] arr, int left, int right){
        T pivot = GetPivot(arr, left, right);
        int i = left - 1;
        for(int j = left; j <= right - 1; j++){
            if(arr[j].compareTo(pivot) <= 0){
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i+1,right);
        return i+1;
    }


    /**
     * This "median-of-three" rule counters the case of sorted (or reverse-sorted) input,
     * and gives a better estimate of the optimal pivot (the true median) than selecting
     * any single element, when no information about the ordering of the input is known.
     * Source: https://en.wikipedia.org/wiki/Quicksort in part "implementation issues"
     * @param arr
     * @param left
     * @param right
     * @param <T>
     * @return T pivot
     */
    public static <T extends  Comparable<? super T>> T GetPivot(T[] arr, int left, int right){
        int middle = (left + right) / 2;
        if(arr[middle].compareTo(arr[left]) < 0){
            swap(arr, left, middle);
        }
        if(arr[right].compareTo(arr[left]) < 0){
            swap(arr, left, right);
        }
        if(arr[middle].compareTo(arr[right]) < 0){
            swap(arr, middle, right);
        }
        return arr[right];
    }


    public static <T> void swap (T[] arr, int i, int j) {
        T t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
