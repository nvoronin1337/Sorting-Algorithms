package com.company;

import java.util.Arrays;

public class HeapSort {


    public static void main(String[] args) {
        Integer[] arr = {10,6,5,9,12,1};

        HeapSort(arr);
        System.out.println(Arrays.toString(arr));

        DecreasingHeapSort(arr);
        System.out.println(Arrays.toString(arr));
    }


    public static <T extends Comparable <? super T>> void HeapSort(T[] arr){
        int n = arr.length;
        BuildMaxHeap(arr, n);

        for(int i = n-1; i >= 0; i--){
            Swap(arr,i, 0);
            MaxHeapify(arr,i,0);
        }
    }


    public static <T extends Comparable <? super T>> void DecreasingHeapSort(T[] arr){
        int n = arr.length;
        BuildMinHeap(arr, n);

        for(int i = n-1; i >= 0; i--){
            Swap(arr, i, 0);
            MinHeapify(arr, i, 0);
        }
    }


    public static <T extends Comparable <? super T>> void BuildMaxHeap(T[] tree, int n){
        for(int i = n/2 - 1; i >= 0; i--){
            MaxHeapify(tree, n, i);
        }
    }


    public static <T extends Comparable <? super T>> void BuildMinHeap(T[] tree, int n){
        for(int i = n/2; i >= 0; i--){
            MinHeapify(tree, n, i);
        }
    }


    public static <T extends Comparable <? super T>> void MaxHeapify(T[] tree, int n, int i){
        int largest = i;
        int l = 2*i + 1;
        int r = 2*i+2;

        if(l < n && tree[l].compareTo(tree[largest]) > 0){
            largest = l;
        }

        if(r < n && tree[r].compareTo(tree[largest]) > 0){
            largest = r;
        }

        if(largest != i){
            Swap(tree, i, largest);
            MaxHeapify(tree, n, largest);
        }
    }


    public static <T extends Comparable <? super T>> void MinHeapify(T[] tree, int n, int i){
        int smallest = i;
        int l = 2*i + 1;
        int r = 2*i+2;

        if(l < n && tree[l].compareTo(tree[smallest]) < 0){
            smallest = l;
        }

        if(r < n && tree[r].compareTo(tree[smallest]) < 0){
            smallest = r;
        }

        if(smallest != i){
            Swap(tree, i, smallest);
            MaxHeapify(tree, n, smallest);
        }
    }


    public static <T extends Comparable <? super T>> void Swap(T[] arr, int i, int j){
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
