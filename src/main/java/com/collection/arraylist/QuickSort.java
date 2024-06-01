package com.collection.arraylist;

import java.util.Comparator;

public class QuickSort<T extends Comparable<T>> {

    public static <T> void sort(MyArrayList<String> arrayList, Comparator<String> comparator){

        if(arrayList == null || arrayList.size() == 0){
            return;
        }
        quickSort(arrayList,0,arrayList.size() - 1, comparator);
    }

    private static <T> void quickSort(MyArrayList<T> arrayList, int low, int high,
                                  Comparator<? super T> comparator){
        // if low is more than high, then the subarray contains one element or less and no sorting is required.
        if(low < high){
            int pivotIndex = partition(arrayList, low, high, comparator);
            quickSort(arrayList,low,pivotIndex - 1, comparator);
            quickSort(arrayList,pivotIndex + 1, high, comparator);
        }
    }

    private static <T> int partition(MyArrayList<T> arrayList, int low, int high,
                                     Comparator<? super T> comparator){

        int middle = low + (high - low) / 2;
        T pivot = arrayList.get(middle);

        T temp = arrayList.get(middle);
        arrayList.set(middle,arrayList.get(high));
        arrayList.set(high,temp);

        int i = low - 1;
        for(int j = low; j < high; j++){
            if(comparator.compare(arrayList.get(j), pivot) < 0){ // if current elem is higher or equal to pivot element, so we need
                //to switch them
                i++; // increase i pointer to determine where to put current element
                T pi = arrayList.get(i);
                arrayList.set(i,arrayList.get(j));
                arrayList.set(j,pi);
            }
        }
        //after the loop completes, all elements with lower values are collected to the left of the pivot.
        // index i point to the last from the first group of partition
        // we put pivot between two groups after the partition
        T tempPivot = arrayList.get(i + 1); // put the pivot in temp
        arrayList.set(i + 1,arrayList.get(high));
        arrayList.set(high,tempPivot); // put the pivot on the i + 1 position
        // return index of the pivot after partition
        return i + 1;
    }
}
